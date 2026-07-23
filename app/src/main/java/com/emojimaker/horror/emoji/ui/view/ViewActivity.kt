package com.emojimaker.horor.emoji.ui.view

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.extensions.checkPermissions
import com.emojimaker.horor.emoji.core.extensions.goToSettings
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.invisible
import com.emojimaker.horor.emoji.core.extensions.loadImage
import com.emojimaker.horor.emoji.core.extensions.loadImageFromFile
import com.emojimaker.horor.emoji.core.extensions.requestPermission
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.setImageActionBar
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.RequestKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey.AVATAR_TYPE
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PackageRepository
import com.emojimaker.horor.emoji.databinding.ActivityViewBinding
import com.emojimaker.horor.emoji.dialog.AddNewPackageDialog
import com.emojimaker.horor.emoji.dialog.AddPackageDialog
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.ui.customize.CustomizeCharacterActivity
import com.emojimaker.horor.emoji.ui.home.DataViewModel
import com.emojimaker.horor.emoji.ui.my_creation.view_model.MyAvatarViewModel
import com.emojimaker.horor.emoji.ui.permission.PermissionViewModel
import com.lvt.ads.util.Admob
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewActivity : BaseActivity<ActivityViewBinding>() {
    private val viewModel: ViewViewModel by viewModels()
    private val myAvatarViewModel: MyAvatarViewModel by viewModels()
    private val dataViewModel: DataViewModel by viewModels()
    private val permissionViewModel: PermissionViewModel by viewModels()

    override fun setViewBinding(): ActivityViewBinding {
        return ActivityViewBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        dataViewModel.ensureData(this)
        val path = intent.getStringExtra(IntentKey.INTENT_KEY)!!
        val statusFrom = intent.getIntExtra(IntentKey.STATUS_KEY, ValueKey.AVATAR_TYPE)
        android.util.Log.d("ViewActivity", "initView path=$path statusFrom=$statusFrom")
        android.util.Log.d("ViewActivity", "file exists=${java.io.File(path).exists()} size=${java.io.File(path).length()}")
        viewModel.setPath(path)
        viewModel.updateStatusFrom(statusFrom)
        binding.includeLayoutBottom.tvShare.select()
        binding.includeLayoutBottom.tvDownload.select()
        binding.includeLayoutBottom.tvPackage.select()

        setButtonBackgrounds()
        setupUI()
    }

    private fun setButtonBackgrounds() {

    }


    private fun setupUI() {
        binding.apply {
            actionBar.apply {
                setImageActionBar(
                    btnActionBarNextRight,
                    if (viewModel.statusFrom == AVATAR_TYPE) R.drawable.ic_edit_view else R.drawable.ic_download_actionbar
                )
                setImageActionBar(btnActionBarNextRight1, R.drawable.ic_share_actionbar)
                setImageActionBar(btnActionBarRight, R.drawable.ic_delete_view)
            }
            includeLayoutBottom.apply {
                btnShare.visible()
                btnDownload.visible()
            }

            // Set scaleType based on content type
            if (viewModel.statusFrom == ValueKey.AVATAR_TYPE) {
                imvImage.scaleType = android.widget.ImageView.ScaleType.FIT_CENTER
            } else {
                imvImage.scaleType = android.widget.ImageView.ScaleType.CENTER
            }
        }
    }

    private val editLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val newPath =
                    result.data?.getStringExtra("NEW_PATH") ?: return@registerForActivityResult
                viewModel.setPath(newPath)
                binding.imvImage.loadImageFromFile(newPath)
            }
        }

    override fun dataObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pathInternal.collect { path ->
                    android.util.Log.d("ViewActivity", "collect path=$path")
                    android.util.Log.d("ViewActivity", "file exists=${java.io.File(path).exists()} size=${java.io.File(path).length()}")
                    loadImage(this@ViewActivity, path, binding.imvImage)
                }
            }
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.apply {
                btnActionBarLeft.tap { showInterAll {   handleBack() } }
                btnActionBarRight.tap {
                    handleDelete()
                }
                btnActionBarNextRight.tap {
                    if (viewModel.statusFrom == AVATAR_TYPE) handleEditClick(viewModel.pathInternal.value)
                    else checkStoragePermission()
                }
                btnActionBarNextRight1.tap {
                    viewModel.shareFiles(this@ViewActivity)
                }
            }


            includeLayoutBottom.btnShare.tap(2000) {
                viewModel.shareFiles(this@ViewActivity)
            }
            includeLayoutBottom.btnDownload.tap(2000) {
                checkStoragePermission()
            }
            includeLayoutBottom.btnAddPackage.tap(800) {
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
            btnActionBarRightText.gone()
            btnActionBarRight.visible()
            if (viewModel.statusFrom == ValueKey.AVATAR_TYPE) {
                btnActionBarNextRight.visible()
                btnActionBarNextRight1.gone()
            } else if (viewModel.statusFrom == ValueKey.EMOJI_TYPE) {
                btnActionBarNextRight.gone()
                btnActionBarNextRight1.gone()
            } else if (viewModel.statusFrom == ValueKey.MY_DESIGN_TYPE) {
                btnActionBarNextRight.gone()
                btnActionBarNextRight1.gone()
            } else {
                btnActionBarNextRight.visible()
                btnActionBarNextRight1.visible()
            }
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
            viewModel.downloadFiles(this@ViewActivity).collect { state ->
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
        val dialog =
            YesNoDialog(this, R.string.delete, R.string.are_you_sure_want_to_delete_this_item)
        LanguageHelper.setLocale(this)
        dialog.show()
        dialog.onNoClick = {
            dialog.dismiss()
            hideNavigation()
        }
        dialog.onYesClick = {
            dialog.dismiss()
            lifecycleScope.launch {
                viewModel.deleteFile(this@ViewActivity, viewModel.pathInternal.value)
                    .collect { state ->
                        when (state) {
                            HandleState.LOADING -> showLoading()
                            HandleState.SUCCESS -> {
                                dismissLoading()
                                setResult(Activity.RESULT_OK, Intent().apply {
                                    putExtra("DELETED_PATH", viewModel.pathInternal.value)
                                })
                                finish()
                            }

                            else -> {
                                dismissLoading()
                                showToast(R.string.delete_failed_please_try_again)
                            }
                        }
                    }
            }
        }
    }

    private fun handleBack() {
        handleBackLeftToRight()
    }

    private fun handleEditClick(pathInternal: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            showLoading()
            myAvatarViewModel.editItem(this@ViewActivity, pathInternal, dataViewModel.allData.value)

            withContext(Dispatchers.Main) {
                delay(300)
                dismissLoading()

                myAvatarViewModel.checkDataInternet(this@ViewActivity) {
                    val intent =
                        Intent(this@ViewActivity, CustomizeCharacterActivity::class.java).apply {
                            putExtra(IntentKey.INTENT_KEY, myAvatarViewModel.positionCharacter)
                            putExtra(IntentKey.STATUS_FROM_KEY, ValueKey.EDIT)
                        }

                 showInterAll {   editLauncher.launch(intent)
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right) }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
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
        initNativeCollab()
    }

    override fun initAds() {
        initNativeCollab()
    }

    fun initNativeCollab() {


        Admob.getInstance().loadNativeCollapNotBanner(this@ViewActivity,getString(R.string.native_collap_detail),binding.flNativeCollab)

    }



    @android.annotation.SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        handleBack()
    }
}
