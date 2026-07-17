package com.create.lalala.ui.success

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lvt.ads.util.Admob
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.checkPermissions
import com.create.lalala.core.extensions.goToSettings
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.handleBackLeftToRight
import com.create.lalala.core.extensions.invisible
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.loadNativeCollabAds
import com.create.lalala.core.extensions.requestPermission
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.setImageActionBar
import com.create.lalala.core.extensions.setTextActionBar
import com.create.lalala.core.extensions.showInterAll
import com.create.lalala.core.extensions.startIntentRightToLeft
import com.create.lalala.core.extensions.startIntentWithClearTop
import com.create.lalala.core.extensions.strings
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.helper.UnitHelper
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.key.RequestKey
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.data.local.PackageRepository
import com.create.lalala.data.model.PackageModel
import com.create.lalala.databinding.ActivitySuccessBinding
import com.create.lalala.databinding.DialogAddNewPackageBinding
import com.create.lalala.databinding.DialogAddPackageBinding
import com.create.lalala.ui.home.HomeActivity
import com.create.lalala.ui.my_creation.MyCreationActivity
import com.create.lalala.ui.my_creation.adapter.AddPackageAdapter
import com.create.lalala.ui.permission.PermissionViewModel
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
                    showInterAll {
                        viewModel.shareFiles(this@SuccessActivity)
                    }
                }
                btnActionBarLeft.tap {  handleBack()  }

                btnActionBarRight.tap(2000){
                    startIntentWithClearTop(HomeActivity::class.java)

                }
            }

            // My Album button
            includeLayoutBottom.btnMyCreation.tap(2590) {
                showInterAll {
                    startIntentRightToLeft(MyCreationActivity::class.java, IntentKey.TAB_KEY, statusFrom)
                }
            }

            // Download button
            includeLayoutBottom.btnDownload.tap(2000) {
                checkStoragePermission()
            }

            includeLayoutBottom.btnAddPackage.tap(800) {
                showAddPackageDialog()
            }

        }
    }

    private fun showAddPackageDialog() {
        val dialogBinding = DialogAddPackageBinding.inflate(layoutInflater)
        val dialog = createCenterDialog(dialogBinding.root)
        val adapter = AddPackageAdapter()
        var selectedPackageId = ""

        fun packageListWithAdd(): ArrayList<PackageModel> {
            val list = PackageRepository.getPackages(this)
            list.add(0, PackageModel(AddPackageAdapter.ADD_ID, ""))
            return list
        }

        fun updateAddButton() {
            val enabled = selectedPackageId.isNotEmpty()
            dialogBinding.btnAddPackage.isEnabled = enabled
            dialogBinding.btnAddPackage.alpha = if (enabled) 1f else 0.45f
        }

        fun reloadPackages() {
            adapter.submitList(packageListWithAdd())
            updateAddButton()
        }

        dialogBinding.rcvPackage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        dialogBinding.rcvPackage.adapter = adapter
        adapter.onAddClick = {
            showAddNewPackageDialog {
                reloadPackages()
            }
        }
        adapter.onPackageClick = { packageModel ->
            selectedPackageId = packageModel.id
            adapter.selectedPackageId = packageModel.id
            adapter.notifyItemRangeChanged(0, adapter.itemCount)
            updateAddButton()
        }
        dialogBinding.btnAddPackage.tap {
            if (selectedPackageId.isEmpty()) return@tap
            val success = PackageRepository.addImageToPackage(this, selectedPackageId, viewModel.pathInternal.value)
            if (success) {
                showToast(R.string.added_to_package_successfully)
                dialog.dismiss()
            } else {
                showToast(R.string.save_failed_please_try_again)
            }
        }

        reloadPackages()
        dialog.show()
    }

    private fun showAddNewPackageDialog(onCreated: () -> Unit) {
        val dialogBinding = DialogAddNewPackageBinding.inflate(layoutInflater)
        val dialog = createCenterDialog(dialogBinding.root)
        dialogBinding.btnAddPackageInput.tap {
            val packageName = dialogBinding.edPackage.text.toString().trim()
            if (packageName.isEmpty()) {
                showToast(R.string.please_enter_your_package_name)
                return@tap
            }
            PackageRepository.createPackage(this, packageName, viewModel.pathInternal.value)
            showToast(R.string.package_created_successfully)
            dialog.dismiss()
            onCreated.invoke()
        }
        dialog.show()
    }

    private fun createCenterDialog(view: android.view.View): Dialog {
        return Dialog(this).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            setContentView(view)
            view.setOnClickListener { dismiss() }
            (view as? ViewGroup)?.getChildAt(0)?.setOnClickListener { }
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setOnShowListener {
                window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            }
        }
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

//    override fun initAds() {
//        initNativeCollab()
//    }
//
//    fun initNativeCollab() {
//
//        loadNativeCollabAds(R.string.native_cl_success, binding.flNativeCollab)
//
//
//    }

    @android.annotation.SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        handleBackLeftToRight()
    }
}
