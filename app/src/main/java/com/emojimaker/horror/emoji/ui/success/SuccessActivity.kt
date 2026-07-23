package com.emojimaker.horor.emoji.ui.success

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.lvt.ads.util.Admob
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.extensions.checkPermissions
import com.emojimaker.horor.emoji.core.extensions.goToSettings
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.invisible
import com.emojimaker.horor.emoji.core.extensions.loadImage
import com.emojimaker.horor.emoji.core.extensions.loadNativeCollabAds
import com.emojimaker.horor.emoji.core.extensions.requestPermission
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.setImageActionBar
import com.emojimaker.horor.emoji.core.extensions.setTextActionBar
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.startIntentRightToLeft
import com.emojimaker.horor.emoji.core.extensions.startIntentWithClearTop
import com.emojimaker.horor.emoji.core.extensions.strings
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.UnitHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.RequestKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PackageRepository
import com.emojimaker.horor.emoji.databinding.ActivitySuccessBinding
import com.emojimaker.horor.emoji.dialog.AddNewPackageDialog
import com.emojimaker.horor.emoji.dialog.AddPackageDialog
import com.emojimaker.horor.emoji.ui.home.HomeActivity
import com.emojimaker.horor.emoji.ui.my_creation.MyCreationActivity
import com.emojimaker.horor.emoji.ui.permission.PermissionViewModel
import kotlinx.coroutines.launch

class SuccessActivity : BaseActivity<ActivitySuccessBinding>() {
    private val viewModel: SuccessViewModel by viewModels()
    private val permissionViewModel: PermissionViewModel by viewModels()
    private var statusFrom: Int = ValueKey.MY_DESIGN_TYPE

    override fun setViewBinding(): ActivitySuccessBinding {
        return ActivitySuccessBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        viewModel.setPath(intent.getStringExtra(IntentKey.INTENT_KEY) ?: "")
        statusFrom = intent.getIntExtra(IntentKey.STATUS_KEY, ValueKey.MY_DESIGN_TYPE)
        setButtonBackgrounds()
    }

    private fun setButtonBackgrounds() {
        binding.includeLayoutBottom.apply {
            btnDownload.select()
            btnMyCreation.select()
            btnAddPackage.select()
        }
    }

    override fun dataObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.pathInternal.collect { path ->
                        if (path.isNotEmpty()) {
                            loadImage(this@SuccessActivity, path, binding.imvImage)
                        }
                    }
                }
            }
        }
    }

    private fun handleBack() {
        handleBackLeftToRight()
    }
    override fun viewListener() {
        binding.apply {
            actionBar.apply {
                btnActionBarNextRight.tap(2000) {

                        viewModel.shareFiles(this@SuccessActivity)

                }
                btnActionBarLeft.tap {  showInterAll {  handleBack()  } }

                btnActionBarRight.tap(1000){
                    showInterAll {  startIntentWithClearTop(HomeActivity::class.java)}

                }
            }

            // My Album button
            includeLayoutBottom.btnMyCreation.tap(1000) {

                    startIntentRightToLeft(MyCreationActivity::class.java, IntentKey.TAB_KEY, statusFrom)

            }

            // Download button
            includeLayoutBottom.btnDownload.tap(1000) {
                checkStoragePermission()
            }

            includeLayoutBottom.btnAddPackage.tap(1000) {
                showAddPackageDialog()
            }

        }
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

    private fun hideNavigationAfterDialog() {
        hideNavigation()
        Handler(Looper.getMainLooper()).postDelayed({ hideNavigation() }, 250)
    }
    override fun initActionBar() {
        binding.actionBar.apply {

            btnActionBarLeft.visible()
            btnActionBarRight.visible()
            btnActionBarRight.setImageResource(R.drawable.ic_home)
//            tvCenter.visible()
//            tvCenter.setText(R.string.successfully)
            imgCenter.gone()
                setImageActionBar(btnActionBarNextRight, R.drawable.ic_share)
            btnActionBarNextRight.visible()


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
            viewModel.downloadFiles(this@SuccessActivity).collect { state ->
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

    override fun onRestart() {
        super.onRestart()
        initAds()
    }

    override fun initAds() {
        initNativeCollab()
    }

    fun initNativeCollab() {

        loadNativeCollabAds(R.string.native_collap_success, binding.flNativeCollab)


    }

    @android.annotation.SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        handleBackLeftToRight()
    }
}
