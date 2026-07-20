package com.create.lalala.ui.cosplay

import android.annotation.SuppressLint
import androidx.constraintlayout.widget.ConstraintSet
import android.content.pm.PackageManager
import android.os.Build
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.checkPermissions
import com.create.lalala.core.extensions.goToSettings
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.handleBackLeftToRight
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.requestPermission
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.showInterAll
import com.create.lalala.core.extensions.startIntentWithClearTop
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.key.RequestKey
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.databinding.ActivityCosplaySuccessfulBinding
import com.create.lalala.ui.home.HomeActivity
import com.create.lalala.ui.permission.PermissionViewModel
import com.create.lalala.ui.success.SuccessViewModel
import kotlinx.coroutines.launch

class CosplaySuccessfulActivity : BaseActivity<ActivityCosplaySuccessfulBinding>() {

    private val viewModel: SuccessViewModel by viewModels()
    private val permissionViewModel: PermissionViewModel by viewModels()

    private var finalProgress = 0
    private var targetImagePath = ""

    override fun setViewBinding(): ActivityCosplaySuccessfulBinding {
        return ActivityCosplaySuccessfulBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        val path = intent.getStringExtra(IntentKey.INTENT_KEY) ?: ""
        finalProgress = intent.getIntExtra(IntentKey.STATUS_KEY, 0)
        targetImagePath = intent.getStringExtra(IntentKey.PATH_KEY) ?: ""
        viewModel.setPath(path)
        updateProgressDisplay()
        if (targetImagePath.isNotEmpty()) {
            loadImage(this, targetImagePath, binding.btnSamplePhoto)
        }
    }

    override fun dataObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pathInternal.collect { path ->
                    if (path.isNotEmpty()) {
                        loadImage(this@CosplaySuccessfulActivity, path, binding.imvImage)
                    }
                }
            }
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarRight.tap {
                showInterAll {
                    startIntentWithClearTop(HomeActivity::class.java)
                }

            }
            actionBar.btnActionBarLeft.tap{
                handleBackLeftToRight()
            }
            includeLayoutBottom.btnWhatsapp.tap(800) {
                showInterAll {
                    startIntentWithClearTop(CosplayRandomActivity::class.java)
                }
            }



            includeLayoutBottom.btnTelegram.tap(2000) {
                viewModel.saveToAvatar(this@CosplaySuccessfulActivity) {
                    showToast(R.string.image_has_been_saved_successfully)
                }
            }
        }
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarRight.visible()
            btnActionBarRight.setImageResource(R.drawable.ic_home)

        }
    }

    private fun updateProgressDisplay() {
        binding.progressBar.pivotX = 0f
        binding.progressBar.scaleX = finalProgress / 100f
        binding.progressContainer.post {
            if (finalProgress == 100) {
                binding.icThumb.translationX = 0f
                val cs = ConstraintSet()
                cs.clone(binding.main)
                cs.connect(R.id.ic_thumb, ConstraintSet.START, R.id.progressContainer, ConstraintSet.END)
                cs.connect(R.id.ic_thumb, ConstraintSet.END, R.id.progressContainer, ConstraintSet.END)
                cs.applyTo(binding.main)
            } else {
                val containerW = binding.progressContainer.width
                val thumbW = binding.icThumb.width
                val maxX = (containerW - thumbW).toFloat().coerceAtLeast(0f)
                val offsetPx = 5f * resources.displayMetrics.density
                binding.icThumb.translationX = (finalProgress / 100f) * maxX - offsetPx
            }
            binding.tvProgress.text = "$finalProgress/100"
            binding.tvProgress.select()
        }
        val starRes = when {
            finalProgress == 0 -> R.drawable.zeo_star_ss
            finalProgress in 1 until 20 -> R.drawable.one_star_ss
            finalProgress < 40 -> R.drawable.two_star_ss
            finalProgress < 70 -> R.drawable.three_star_ss
            finalProgress <99 -> R.drawable.four_star_ss
            else -> R.drawable.five_star_ss
        }
        binding.starSS.setImageResource(starRes)
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
            viewModel.downloadFiles(this@CosplaySuccessfulActivity).collect { state ->
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

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
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

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        handleBackLeftToRight()
    }
}
