package com.emojimaker.horor.emoji.ui.package_view

import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.dp
import com.emojimaker.horor.emoji.core.extensions.setMargins
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.databinding.ActivityViewAllPackageBinding
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.ui.my_creation.adapter.PackageItemAdapter
import com.emojimaker.horor.emoji.ui.my_creation.view_model.MyCreationViewModel
import com.emojimaker.horor.emoji.ui.my_creation.view_model.ViewAllPackageViewModel
import com.emojimaker.horor.emoji.core.utils.share.whatsapp.WhatsappSharingActivity
import com.lvt.ads.util.Admob
import kotlinx.coroutines.launch

class ViewAllPackageActivity : WhatsappSharingActivity<ActivityViewAllPackageBinding>() {
    private val viewModel: ViewAllPackageViewModel by viewModels()
    private val shareViewModel: MyCreationViewModel by viewModels()
    private val packageItemAdapter by lazy { PackageItemAdapter() }
    private var isInSelectionMode = false
    private var isAllSelected = false

    override fun setViewBinding(): ActivityViewAllPackageBinding {
        return ActivityViewAllPackageBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        val packageId = intent.getStringExtra(IntentKey.PACKAGE_ID_KEY).orEmpty()
        viewModel.loadPackage(this, packageId)
        binding.rcvPackageItem.adapter = packageItemAdapter
        binding.rcvPackageItem.itemAnimator = null
        binding.actionBar.tvCenter.text = intent.getStringExtra(IntentKey.PACKAGE_NAME_KEY).orEmpty()
        binding.actionBar.tvCenter.select()
        binding.actionBar.tvCenter.setMargins(left = 100.dp(this), right = 100.dp(this))
    }

    override fun dataObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.itemList.collect { list ->
                    packageItemAdapter.submitList(list)
                    if (list.isEmpty()) {
                        binding.tvNoItemHere.visible()
                    } else {
                        binding.tvNoItemHere.gone()
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                shareViewModel.downloadState.collect { state ->
                    when (state) {
                        HandleState.LOADING -> showLoading()
                        HandleState.SUCCESS -> {
                            dismissLoading()
                            showToast(R.string.download_success)
                        }
                        else -> {
                            dismissLoading()
                            showToast(R.string.download_failed_please_try_again_later)
                        }
                    }
                }
            }
        }
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarLeft.tap {
            if (isInSelectionMode) resetSelectionMode() else showInterAll {  handleBackLeftToRight() }
        }
        binding.actionBar.btnActionBarNextRight.tap { handleDeleteSelected() }
        binding.actionBar.btnActionBarRight.tap { handleSelectAll() }
        binding.bottomView.btnRight.tap { handleAddToWhatsApp(getTargetPackagePaths()) }
        binding.bottomView.btnLeft.tap { handleAddToTelegram(getTargetPackagePaths()) }
        binding.bottomView.btnDownLoad.tap {
            val paths = getTargetPackagePaths()
            if (paths.isEmpty()) {
                showToast(R.string.please_select_an_image)
            } else {
                shareViewModel.downloadFiles(this, paths)
            }
        }
        packageItemAdapter.onItemClick = { path ->
            if (!isInSelectionMode) {
                startActivity(Intent(this, ViewPackageActivity::class.java).apply {
                    putExtra(IntentKey.INTENT_KEY, path)
                    putExtra(IntentKey.PACKAGE_ID_KEY, viewModel.packageId)
                })
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
        packageItemAdapter.onLongClick = { position ->
            viewModel.showLongClick(position)
            enterSelectionMode()
            updateSelectAllIcon(viewModel.itemList.value.all { it.isSelected })
        }
        packageItemAdapter.onItemTick = { position ->
            viewModel.toggleSelect(position)
            updateSelectAllIcon(viewModel.itemList.value.all { it.isSelected })
        }
    }

    private fun getTargetPackagePaths(): ArrayList<String> {
        return if (isInSelectionMode) viewModel.getSelectedPaths() else viewModel.getAllPaths()
    }

    private fun handleAddToTelegram(paths: ArrayList<String>) {
        if (paths.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        shareViewModel.addToTelegram(this, paths)
        if (isInSelectionMode) resetSelectionMode()
    }

    private fun handleAddToWhatsApp(paths: ArrayList<String>) {
        if (paths.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        if (paths.size < 3) {
            showToast(R.string.limit_3_items)
            return
        }
        if (paths.size > 30) {
            showToast(R.string.limit_30_items)
            return
        }
        val packageName = viewModel.packageName.ifBlank {
            intent.getStringExtra(IntentKey.PACKAGE_NAME_KEY).orEmpty()
        }
        shareViewModel.addToWhatsapp(this, packageName, paths) { stickerPack ->
            if (stickerPack != null) {
                addToWhatsapp(stickerPack)
                if (isInSelectionMode) resetSelectionMode()
            }
        }
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            tvCenter.visible()
            btnActionBarNextRight.gone()
            btnActionBarRight.gone()
        }
        binding.flBottom.visible()
    }

    override fun initAds() {
        super.initAds()
        Admob.getInstance().loadNativeCollapNotBanner(this@ViewAllPackageActivity,getString(R.string.native_collap_detail),binding.flNativeCollab)
    }

    override fun onRestart() {
        super.onRestart()
        initAds()
    }


    private fun enterSelectionMode() {
        isInSelectionMode = true
        isAllSelected = false
        binding.actionBar.btnActionBarNextRight.visible()
        binding.actionBar.btnActionBarNextRight.apply {
            setImageResource(R.drawable.ic_delete_creation)
            updateLayoutParams {
                width = (30f * resources.displayMetrics.density).toInt()
                height = (30f * resources.displayMetrics.density).toInt()
            }
        }
        binding.actionBar.btnActionBarRight.visible()
        binding.actionBar.btnActionBarRight.apply {
            setImageResource(R.drawable.ic_not_select_all)
            updateLayoutParams {
                width = (30f * resources.displayMetrics.density).toInt()
                height = (30f * resources.displayMetrics.density).toInt()
            }
        }
        binding.flBottom.visible()
    }

    private fun resetSelectionMode() {
        isInSelectionMode = false
        isAllSelected = false
        viewModel.clearSelection()
        binding.actionBar.btnActionBarNextRight.gone()
        binding.actionBar.btnActionBarRight.gone()
        binding.flBottom.visible()
    }

    private fun handleSelectAll() {
        if (isAllSelected) {
            viewModel.selectAll(false)
            updateSelectAllIcon(false)
        } else {
            viewModel.selectAll(true)
            updateSelectAllIcon(true)
        }
    }

    private fun updateSelectAllIcon(allSelected: Boolean) {
        isAllSelected = allSelected
        binding.actionBar.btnActionBarRight.setImageResource(
            if (allSelected) R.drawable.ic_select_all else R.drawable.ic_not_select_all
        )
    }

    private fun handleDeleteSelected() {
        val selectedPaths = viewModel.getSelectedPaths()
        if (selectedPaths.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        val dialog = YesNoDialog(this, R.string.delete, R.string.are_you_sure_want_to_delete_this_item)
        LanguageHelper.setLocale(this)
        dialog.show()
        dialog.onNoClick = {
            dialog.dismiss()
            hideNavigation()
        }
        dialog.onYesClick = {
            viewModel.deletePaths(this, selectedPaths)
            dialog.dismiss()
            hideNavigation()
            resetSelectionMode()
        }
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.packageId.isNotEmpty()) viewModel.loadPackage(this, viewModel.packageId)
    }
}
