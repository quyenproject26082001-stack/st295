package com.emojimaker.horor.emoji.ui.package_view

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.extensions.checkPermissions
import com.emojimaker.horor.emoji.core.extensions.goToSettings
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.loadImage
import com.emojimaker.horor.emoji.core.extensions.requestPermission
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.setImageActionBar
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.RequestKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PackageRepository
import com.emojimaker.horor.emoji.databinding.ActivityViewPackageBinding
import com.emojimaker.horor.emoji.dialog.AddNewPackageDialog
import com.emojimaker.horor.emoji.dialog.AddPackageDialog
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.ui.permission.PermissionViewModel
import com.emojimaker.horor.emoji.ui.view.ViewViewModel
import com.lvt.ads.util.Admob
import kotlinx.coroutines.launch

class ViewPackageActivity : BaseActivity<ActivityViewPackageBinding>() {
    private val viewModel: ViewViewModel by viewModels()
    private val permissionViewModel: PermissionViewModel by viewModels()
    private var packageId: String = ""

    override fun setViewBinding(): ActivityViewPackageBinding {
        return ActivityViewPackageBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        val path = intent.getStringExtra(IntentKey.INTENT_KEY).orEmpty()
        packageId = intent.getStringExtra(IntentKey.PACKAGE_ID_KEY).orEmpty()
        viewModel.setPath(path)
    }

    override fun dataObservable() {
        lifecycleScope.launch {
            viewModel.pathInternal.collect { path ->
                if (path.isNotEmpty()) loadImage(this@ViewPackageActivity, path, binding.imvImage)
            }
        }
    }

    override fun viewListener() {
        binding.actionBar.btnActionBarLeft.tap { showInterAll {  handleBackLeftToRight() } }
        binding.actionBar.btnActionBarRight.tap(2000) { handleDelete() }
        binding.actionBar.btnActionBarNextRight.tap(2000) { checkStoragePermission() }
        binding.actionBar.btnActionBarNextRight1.tap(2000) { viewModel.shareFiles(this) }
        binding.includeLayoutBottom.btnShare.tap(2000) { viewModel.shareFiles(this) }
        binding.includeLayoutBottom.btnDownload.tap(2000) { checkStoragePermission() }
        binding.includeLayoutBottom.btnAddPackage.tap(800) {
            showAddPackageDialog()
        }
    }

    private fun showAddNewPackageDialog(addPackageDialog: AddPackageDialog) {
        val dialog = AddNewPackageDialog(this)
        dialog.onAddPackageClick = { packageName ->
            if (packageName.isEmpty()) {
                showToast(R.string.please_enter_your_package_name)
            } else if (PackageRepository.hasPackageName(this, packageName)) {
                showToast(R.string.package_name_already_exists)
            } else {
                val success = PackageRepository.createPackageWithImage(this, packageName, viewModel.pathInternal.value)
                if (success) {
                    showToast(R.string.package_created_successfully)
                    dialog.dismiss()
                    addPackageDialog.dismiss()
                    hideNavigationAfterDialog()
                } else {
                    showToast(R.string.save_failed_please_try_again)
                }
            }
        }
        dialog.show()
    }
    private fun showAddPackageDialog() {
        val dialog = AddPackageDialog(this)
        dialog.onCreateNewPackageClick = {
            showAddNewPackageDialog(dialog)
        }
        dialog.onAddToPackageClick = { selectedPackageId ->
            val success = PackageRepository.addImageToPackage(this, selectedPackageId, viewModel.pathInternal.value)
            if (success) {
                showToast(R.string.added_to_package_successfully)
                dialog.dismiss()
                hideNavigationAfterDialog()
            } else {
                showToast(R.string.save_failed_please_try_again)
            }
        }
        dialog.show()
    }
    private fun hideNavigationAfterDialog() {
        hideNavigation()
        Handler(Looper.getMainLooper()).postDelayed({ hideNavigation() }, 250)
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            btnActionBarRight.visible()
            btnActionBarNextRight.gone()
            btnActionBarNextRight1.gone()
            tvCenter.gone()
            tvCenter.select()
            setImageActionBar(btnActionBarRight, R.drawable.ic_delete_view)
            btnActionBarRightText.gone()
        }
    }
    override fun initAds() {
        super.initAds()
        Admob.getInstance().loadNativeCollapNotBanner(this@ViewPackageActivity,getString(R.string.native_collap_detail),binding.flNativeCollab)
    }

    override fun onRestart() {
        super.onRestart()
        initAds()
    }
    private fun checkStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            handleDownload()
        } else {
            val perms = permissionViewModel.getStoragePermissions()
            if (checkPermissions(perms)) {
                handleDownload()
            } else if (permissionViewModel.needGoToSettings(sharePreference, true)) {
                goToSettings()
            } else {
                requestPermission(perms, RequestKey.STORAGE_PERMISSION_CODE)
            }
        }
    }

    private fun handleDownload() {
        lifecycleScope.launch {
            viewModel.downloadFiles(this@ViewPackageActivity).collect { state ->
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

    private fun handleDelete() {
        val dialog = YesNoDialog(this, R.string.delete, R.string.are_you_sure_want_to_delete_this_item)
        LanguageHelper.setLocale(this)
        dialog.show()
        dialog.onNoClick = {
            dialog.dismiss()
            hideNavigation()
        }
        dialog.onYesClick = {
            PackageRepository.deleteItems(this, packageId, arrayListOf(viewModel.pathInternal.value))
            dialog.dismiss()
            hideNavigation()
            setResult(Activity.RESULT_OK, Intent())
            finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RequestKey.STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                permissionViewModel.updateStorageGranted(sharePreference, true)
                handleDownload()
            } else {
                permissionViewModel.updateStorageGranted(sharePreference, false)
            }
        }
    }
}
