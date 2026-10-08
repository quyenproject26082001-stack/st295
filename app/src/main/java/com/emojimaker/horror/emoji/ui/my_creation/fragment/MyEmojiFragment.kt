package com.emojimaker.horor.emoji.ui.my_creation.fragment

import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import kotlinx.coroutines.flow.combine
import android.content.Intent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseFragment
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.databinding.FragmentMyEmojiBinding
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.ui.my_creation.MyCreationActivity
import com.emojimaker.horor.emoji.ui.my_creation.adapter.MyEmojiAdapter
import com.emojimaker.horor.emoji.ui.my_creation.view_model.MyCreationViewModel
import com.emojimaker.horor.emoji.ui.my_creation.view_model.MyEmojiViewModel
import com.emojimaker.horor.emoji.ui.view.ViewActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyEmojiFragment : BaseFragment<FragmentMyEmojiBinding>() {
    private val viewModel: MyEmojiViewModel by viewModels()
    private val myCreationViewModel: MyCreationViewModel by activityViewModels()
    private val myEmojiAdapter by lazy { MyEmojiAdapter() }

    private val myAlbumActivity: MyCreationActivity
        get() = requireActivity() as MyCreationActivity

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMyEmojiBinding {
        return FragmentMyEmojiBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.tvNoitem.select()
        binding.rcvMyEmoji.apply {
            adapter = myEmojiAdapter
            itemAnimator = null
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            isNestedScrollingEnabled = true
        }
    }

    override fun dataObservable() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.myEmojiList.collect { list ->
                        myEmojiAdapter.submitList(list)
                        val isSelectionMode = list.any { it.isShowSelection }
                        binding.root.clipToPadding = isSelectionMode
                        binding.rcvMyEmoji.clipToPadding = isSelectionMode
                        binding.layoutNoItem.isVisible = list.isEmpty()
                        if (myCreationViewModel.typeStatus.value == ValueKey.EMOJI_TYPE) {
                            if (list.isEmpty()) myAlbumActivity.binding.lnlBottom.gone()
                            else myAlbumActivity.binding.lnlBottom.visible()
                        }
                    }
                }
                launch {
                    combine(myCreationViewModel.typeStatus, PersistenceRepository.creationRevision) { type, revision ->
                        type to revision
                    }.collect { (type, _) ->
                        if (type == ValueKey.EMOJI_TYPE) viewModel.loadMyEmoji(myAlbumActivity)
                    }
                }
            }
        }
    }

    override fun viewListener() {
        binding.rcvMyEmoji.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(recyclerView: RecyclerView, motionEvent: MotionEvent): Boolean {
                return when {
                    motionEvent.action != MotionEvent.ACTION_UP || recyclerView.findChildViewUnder(motionEvent.x, motionEvent.y) != null -> false
                    else -> {
                        resetData()
                        true
                    }
                }
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
            override fun onTouchEvent(recyclerView: RecyclerView, motionEvent: MotionEvent) {}
        })

        myEmojiAdapter.onItemClick = { pathInternal -> handleItemClick(pathInternal) }
        myEmojiAdapter.onItemTick = { position ->
            viewModel.toggleSelect(position)
            myAlbumActivity.updateSelectAllIcon(viewModel.myEmojiList.value.all { it.isSelected })
        }
        myEmojiAdapter.onDeleteClick = { pathInternal -> handleDelete(arrayListOf(pathInternal)) }
        myEmojiAdapter.onLongClick = { position -> handleLongClick(position) }
    }

    private fun handleItemClick(pathInternal: String) {
        if (myEmojiAdapter.items.any { it.isShowSelection }) resetSelectionMode()
        val intent = Intent(myAlbumActivity, ViewActivity::class.java).apply {
            putExtra(IntentKey.INTENT_KEY, pathInternal)
            putExtra(IntentKey.TYPE_KEY, ValueKey.TYPE_VIEW)
            putExtra(IntentKey.STATUS_KEY, ValueKey.EMOJI_TYPE)
        }
        val options = ActivityOptionsCompat.makeCustomAnimation(myAlbumActivity, R.anim.slide_in_right, R.anim.slide_out_left)
        myAlbumActivity.showInterAll { myAlbumActivity.launchViewActivity(intent, options) }
    }

    private fun handleLongClick(position: Int) {
        if (position >= viewModel.myEmojiList.value.size) return
        viewModel.showLongClick(position)
        myAlbumActivity.enterSelectionMode()
        myAlbumActivity.updateSelectAllIcon(viewModel.myEmojiList.value.all { it.isSelected })
    }

    private fun handleDelete(pathInternalList: ArrayList<String>) {
        if (pathInternalList.isEmpty()) {
            myAlbumActivity.showToast(R.string.please_select_an_image)
            return
        }
        val dialog = YesNoDialog(myAlbumActivity, R.string.delete, R.string.are_you_sure_want_to_delete_this_item)
        LanguageHelper.setLocale(myAlbumActivity)
        dialog.show()
        dialog.onDismissClick = {
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
        }
        dialog.onNoClick = {
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
        }
        dialog.onYesClick = {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.deleteItem(myAlbumActivity, pathInternalList)
                withContext(Dispatchers.Main) {
                    dialog.dismiss()
                    myAlbumActivity.hideNavigation()
                    resetData()
                }
            }
        }
    }

    fun resetData() {
        viewModel.clearSelection()
        myAlbumActivity.exitSelectionMode()
        viewModel.loadMyEmoji(myAlbumActivity)
    }

    fun getAllPaths(): ArrayList<String> {
        return viewModel.myEmojiList.value.map { it.path }.toCollection(ArrayList())
    }

    fun getSelectedPaths(): ArrayList<String> {
        return viewModel.getPathSelected()
    }

    fun deleteSelectedItems() {
        handleDelete(viewModel.getPathSelected())
    }

    fun selectAllItems() {
        viewModel.selectAll(true)
        myEmojiAdapter.notifyItemRangeChanged(0, myEmojiAdapter.itemCount)
    }

    fun deselectAllItems() {
        viewModel.selectAll(false)
        myEmojiAdapter.notifyItemRangeChanged(0, myEmojiAdapter.itemCount)
    }

    fun resetSelectionMode() {
        viewModel.clearSelection()
        myAlbumActivity.exitSelectionMode()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            if (viewModel.myEmojiList.value.isEmpty()) myAlbumActivity.binding.lnlBottom.gone()
            else myAlbumActivity.binding.lnlBottom.visible()
        }
    }


}
