package com.create.lalala.ui.package_view

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.checkPermissions
import com.create.lalala.core.extensions.goToSettings
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.handleBackLeftToRight
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.requestPermission
import com.create.lalala.core.extensions.setImageActionBar
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.key.RequestKey
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.data.local.PackageRepository
import com.create.lalala.databinding.ActivityViewPackageBinding
import com.create.lalala.dialog.YesNoDialog
import com.create.lalala.ui.permission.PermissionViewModel
import com.create.lalala.ui.view.ViewViewModel
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
        binding.actionBar.btnActionBarLeft.tap { handleBackLeftToRight() }
        binding.actionBar.btnActionBarRight.tap { handleDelete() }
        binding.actionBar.btnActionBarNextRight.tap { checkStoragePermission() }
        binding.actionBar.btnActionBarNextRight1.tap { viewModel.shareFiles(this) }
        binding.includeLayoutBottom.btnShare.tap { viewModel.shareFiles(this) }
        binding.includeLayoutBottom.btnDownload.tap { checkStoragePermission() }
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            btnActionBarRight.visible()
            btnActionBarNextRight.gone()
            btnActionBarNextRight1.gone()
            tvCenter.gone()
            setImageActionBar(btnActionBarRight, R.drawable.ic_delete_view)
            btnActionBarRightText.gone()
        }
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
