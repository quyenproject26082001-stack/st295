package com.emojimaker.horor.emoji.ui.my_creation.fragment

import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import kotlinx.coroutines.flow.combine
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseFragment
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.invisible
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.databinding.FragmentPackageBinding
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.ui.my_creation.MyCreationActivity
import com.emojimaker.horor.emoji.ui.my_creation.adapter.PackageCreationAdapter
import com.emojimaker.horor.emoji.ui.my_creation.view_model.MyCreationViewModel
import com.emojimaker.horor.emoji.ui.my_creation.view_model.PackageViewModel
import com.emojimaker.horor.emoji.ui.package_view.ViewAllPackageActivity
import kotlinx.coroutines.launch

class PackageFragment : BaseFragment<FragmentPackageBinding>() {
    private val viewModel: PackageViewModel by viewModels()
    private val myCreationViewModel: MyCreationViewModel by activityViewModels()
    private val packageAdapter by lazy { PackageCreationAdapter() }

    private val myAlbumActivity: MyCreationActivity
        get() = requireActivity() as MyCreationActivity

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPackageBinding {
        return FragmentPackageBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.tvNoitem.select()
        binding.rcvMyDesign.adapter = packageAdapter
        binding.rcvMyDesign.itemAnimator = null
    }

    override fun dataObservable() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.packageList.collect { list ->
                        packageAdapter.submitList(list)
                        binding.layoutNoItem.isVisible = list.isEmpty()
                        if (myCreationViewModel.typeStatus.value == ValueKey.PACKAGE_TYPE) {
                            myAlbumActivity.binding.lnlBottom.gone()
                        }
                    }
                }
                launch {
                    combine(myCreationViewModel.typeStatus, PersistenceRepository.creationRevision) { type, revision ->
                        type to revision
                    }.collect { (type, _) ->
                        if (type == ValueKey.PACKAGE_TYPE) viewModel.loadPackages(myAlbumActivity)
                    }
                }
            }
        }
    }

    override fun viewListener() {
        packageAdapter.onItemClick = { packageModel ->
            if (packageAdapter.items.any { it.isShowSelection }) {
                val position = viewModel.packageList.value.indexOfFirst { it.id == packageModel.id }
                if (position != -1) {
                    viewModel.toggleSelect(position)
                    myAlbumActivity.updateSelectAllIcon(viewModel.packageList.value.all { it.isSelected })
                }
            } else {
                val intent = Intent(myAlbumActivity, ViewAllPackageActivity::class.java)
                intent.putExtra(IntentKey.PACKAGE_ID_KEY, packageModel.id)
                intent.putExtra(IntentKey.PACKAGE_NAME_KEY, packageModel.name)
                myAlbumActivity.showInterAll { startActivity(intent) }
            }
        }
        packageAdapter.onLongClick = { position ->
            viewModel.showLongClick(position)
            myAlbumActivity.enterSelectionMode()
            myAlbumActivity.updateSelectAllIcon(viewModel.packageList.value.all { it.isSelected })
        }
        packageAdapter.onItemTick = { position ->
            viewModel.toggleSelect(position)
            myAlbumActivity.updateSelectAllIcon(viewModel.packageList.value.all { it.isSelected })
        }
    }

    fun deleteSelectedItems() {
        val selectedIds = viewModel.getSelectedIds()
        if (selectedIds.isEmpty()) {
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
            viewModel.deleteSelected(myAlbumActivity)
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
            myAlbumActivity.exitSelectionMode()
        }
    }

    fun selectAllItems() {
        viewModel.selectAll(true)
        packageAdapter.notifyItemRangeChanged(0, packageAdapter.itemCount)
    }

    fun deselectAllItems() {
        viewModel.selectAll(false)
        packageAdapter.notifyItemRangeChanged(0, packageAdapter.itemCount)
    }

    fun resetSelectionMode() {
        viewModel.clearSelection()
        myAlbumActivity.exitSelectionMode()
    }

    fun getAllPackageIds(): ArrayList<String> = viewModel.getAllIds()

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) myAlbumActivity.binding.lnlBottom.gone()
    }


}
