package com.create.lalala.ui.my_creation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.create.lalala.R
import com.create.lalala.core.custom.text.DoubleStrokeTextView
import com.create.lalala.core.custom.text.OuterStrokeTextView
import com.create.lalala.core.extensions.checkPermissions
import com.create.lalala.core.extensions.goToSettings
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.core.extensions.invisible
import com.create.lalala.core.extensions.requestPermission
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap

import com.create.lalala.core.extensions.startIntentWithClearTop
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.key.RequestKey
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.core.utils.share.whatsapp.WhatsappSharingActivity
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.databinding.ActivityAlbumBinding
import com.create.lalala.ui.home.HomeActivity
import com.create.lalala.dialog.CreateNameDialog
import com.create.lalala.ui.my_creation.fragment.MyAvatarFragment
import com.create.lalala.ui.my_creation.fragment.MyDesignFragment
import com.create.lalala.ui.my_creation.view_model.MyCreationViewModel
import com.create.lalala.ui.permission.PermissionViewModel
import kotlinx.coroutines.launch

class MyCreationActivity : WhatsappSharingActivity<ActivityAlbumBinding>() {
    private val viewModel: MyCreationViewModel by viewModels()
    private val permissionViewModel: PermissionViewModel by viewModels()

    private val viewActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _ ->
        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")
        when {
            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.resetSelectionMode()
            designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.resetSelectionMode()
        }
        exitSelectionMode()
    }

    fun launchViewActivity(intent: Intent, options: ActivityOptionsCompat? = null) {
        viewActivityLauncher.launch(intent, options)
    }

    private var myAvatarFragment: MyAvatarFragment? = null
    private var myDesignFragment: MyDesignFragment? = null
    private var isInSelectionMode = false
    private var isAllSelected = false
    private var pendingDownloadList: ArrayList<String>? = null

    override fun setViewBinding(): ActivityAlbumBinding {
        return ActivityAlbumBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        val initialTab = intent.getIntExtra(IntentKey.TAB_KEY, ValueKey.AVATAR_TYPE)
        viewModel.setTypeStatus(initialTab)
        viewModel.setStatusFrom(intent.getBooleanExtra(IntentKey.FROM_SAVE, false))

        // Hide action bar buttons by default (only show in selection mode)
        binding.actionBar.apply {
            btnActionBarNextRight.gone()
            btnActionBarRight.gone()
            tvCenter.visible()
            tvCenter.setText(R.string.my_creation)
        }
        binding.lnlBottom.visible()
        binding.lnlBottom.isSelected = true

    }

    override fun dataObservable() {
        binding.apply {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.CREATED) {
                    launch {
                        viewModel.typeStatus.collect { type ->
                            if (type != -1) {
                                when (type) {
                                    ValueKey.AVATAR_TYPE -> {
                                        imvTabBackground.setImageResource(R.drawable.bg_avatar_slt)
                                        setupSelectedTab(tvMyPride)
                                        setupUnselectedTab(tvMyDesign)
                                        showFragment(ValueKey.AVATAR_TYPE)
                                    }
                                    ValueKey.MY_DESIGN_TYPE -> {
                                        imvTabBackground.setImageResource(R.drawable.bg_design_slt)
                                        setupUnselectedTab(tvMyPride)
                                        setupSelectedTab(tvMyDesign)
                                        showFragment(ValueKey.MY_DESIGN_TYPE)
                                    }
                                }
                                updateBottomButtonsVisibility()
                            }
                        }
                    }
                    launch {
                        viewModel.downloadState.collect { state ->
                            when (state) {
                                HandleState.LOADING -> {
                                    showLoading()
                                }

                                HandleState.SUCCESS -> {
                                    dismissLoading()
                                    hideNavigation()
                                    showToast(R.string.download_success)
                                    if (isInSelectionMode) {
                                        binding.actionBar.btnActionBarLeft.performClick()
                                    }
                                }

                                else -> {
                                    dismissLoading()
                                    hideNavigation()
                                    showToast(R.string.download_failed_please_try_again_later)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun viewListener() {
        binding.apply {
            actionBar.apply {
                btnActionBarLeft.tap {
                    if (isInSelectionMode) {
                        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
                        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")
                        when {
                            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.resetSelectionMode()
                            designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.resetSelectionMode()
                        }
                    } else {
                        startIntentWithClearTop(HomeActivity::class.java)
                    }
                }

                // Delete button
                btnActionBarNextRight.tap {
                    handleDeleteSelectedFromCurrentFragment()
                }

                // Select All button
                btnActionBarRight.tap {
                    handleSelectAllFromCurrentFragment()
                }
            }

            btnMyPixel.tap { viewModel.setTypeStatus(ValueKey.AVATAR_TYPE) }
            btnMyDesign.tap { viewModel.setTypeStatus(ValueKey.MY_DESIGN_TYPE) }

            // WhatsApp, Telegram buttons in lnlBottom
            val layoutBottom = lnlBottom.getChildAt(0)
            layoutBottom.findViewById<View>(R.id.btnRight)?.tap(800) {
                val paths = getAllPathsFromCurrentFragment()
                handleAddToWhatsApp(paths)
            }
            layoutBottom.findViewById<View>(R.id.btnLeft)?.tap(800) {
                val paths = getAllPathsFromCurrentFragment()
                handleAddToTelegram(paths)
            }

            // Share/Download buttons in flBottomView (select mode)
            bottomView.btnWhatsapp.tap(800) {
                val paths = getSelectedPathsFromCurrentFragment()
                handleShare(paths)
            }
            bottomView.btnTelegram.tap(800) {
                val paths = getSelectedPathsFromCurrentFragment()
                if (paths.isEmpty()) { showToast(R.string.please_select_an_image); return@tap }
                checkStoragePermissionForDownload(paths)
            }
        }
    }

    private fun handleShareFromCurrentFragment() {
        val selectedPaths = getSelectedPathsFromCurrentFragment()
        handleShare(selectedPaths)
    }

    private fun handleDownloadFromCurrentFragment() {
        val selectedPaths = getSelectedPathsFromCurrentFragment()
        if (selectedPaths.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        checkStoragePermissionForDownload(selectedPaths)
    }

    private fun checkStoragePermissionForDownload(list: ArrayList<String>) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+ không cần quyền WRITE_EXTERNAL_STORAGE
            handleDownload(list)
        } else {
            // Android 8-9 cần check quyền
            val perms = permissionViewModel.getStoragePermissions()
            if (checkPermissions(perms)) {
                handleDownload(list)
            } else if (permissionViewModel.needGoToSettings(sharePreference, true)) {
                goToSettings()
            } else {
                // Lưu lại list để download sau khi được cấp quyền
                pendingDownloadList = list
                requestPermission(perms, RequestKey.STORAGE_PERMISSION_CODE)
            }
        }
    }

    private fun handleSelectAllFromCurrentFragment() {
        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")

        val doSelect: (() -> Unit)
        val doDeselect: (() -> Unit)

        when {
            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> {
                doSelect = { avatarFragment.selectAllItems() }
                doDeselect = { avatarFragment.deselectAllItems() }
            }
            designFragment is MyDesignFragment && designFragment.isVisible -> {
                doSelect = { designFragment.selectAllItems() }
                doDeselect = { designFragment.deselectAllItems() }
            }
            else -> return
        }

        if (isAllSelected) {
            doDeselect()
            isAllSelected = false
            binding.actionBar.btnActionBarRight.setImageResource(R.drawable.ic_not_select_all)
        } else {
            doSelect()
            isAllSelected = true
            binding.actionBar.btnActionBarRight.setImageResource(R.drawable.ic_select_all)
        }
    }

    private fun handleDeleteSelectedFromCurrentFragment() {
        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")

        when {
            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.deleteSelectedItems()
            designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.deleteSelectedItems()
        }
    }

    private fun getAllPathsFromCurrentFragment(): ArrayList<String> {
        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")
        return when {
            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.getAllPaths()
            designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.getAllPaths()
            else -> arrayListOf()
        }
    }

    private fun getSelectedPathsFromCurrentFragment(): ArrayList<String> {
        val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
        val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")

        return when {
            avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.getSelectedPaths()
            designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.getSelectedPaths()
            else -> arrayListOf()
        }
    }

    override fun initActionBar() {
        binding.actionBar.apply {

            btnActionBarLeft.visible()

            btnActionBarNextRight.gone()

            // Delete All button - hidden initially, only shown in selection mode
            btnActionBarRight.setImageResource(R.drawable.ic_delete_creation)
            tvCenter.visible()
            tvCenter.setText(R.string.my_creation)
            btnActionBarRight.translationX = -6 * resources.displayMetrics.density
            btnActionBarRight.translationY = 4 * resources.displayMetrics.density
            btnActionBarRight.invisible()
        }
    }

    override fun initText() {
        binding.apply {
            tvMyPride.select()
            tvMyDesign.select()
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
                showToast(R.string.granted_storage)
                // Thực hiện download sau khi được cấp quyền
                pendingDownloadList?.let { list ->
                    handleDownload(list)
                    pendingDownloadList = null
                }
            } else {
                permissionViewModel.updateStorageGranted(sharePreference, false)
                pendingDownloadList = null
            }
        }
    }

    fun handleShare(list: ArrayList<String>) {
        if (list.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        viewModel.shareImages(this, list)
    }

    fun handleAddToTelegram(list: ArrayList<String>) {
        if (list.isEmpty()) {
            showToast(R.string.please_select_an_image)
            return
        }
        viewModel.addToTelegram(this, list)
        if (isInSelectionMode) {
            binding.actionBar.btnActionBarLeft.performClick()
        }
    }

    fun handleAddToWhatsApp(list: ArrayList<String>) {
        if (list.size < 3) {
            showToast(R.string.limit_3_items)
            return
        }
        if (list.size > 30) {
            showToast(R.string.limit_30_items)
            return
        }

        val dialog = CreateNameDialog(this)
        LanguageHelper.setLocale(this)
        dialog.show()

        fun dismissDialog() {
            dialog.dismiss()
            hideNavigation()
        }
        dialog.onNoClick = {
            dismissDialog()
        }
        dialog.onDismissClick = {
            dismissDialog()
        }

        dialog.onYesClick = { packageName ->
            dismissDialog()
            viewModel.addToWhatsapp(this, packageName, list) { stickerPack ->
                if (stickerPack != null) {
                    addToWhatsapp(stickerPack)
                    if (isInSelectionMode) {
                        binding.actionBar.btnActionBarLeft.performClick()
                    }
                }
            }
        }
    }

    private fun handleDownload(list: ArrayList<String>) {
        viewModel.downloadFiles(this, list)
    }

    private fun showFragment(type: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        if (myAvatarFragment == null) {
            myAvatarFragment = MyAvatarFragment()
            transaction.add(R.id.frmList, myAvatarFragment!!, "MyAvatarFragment")
        }
        if (myDesignFragment == null) {
            myDesignFragment = MyDesignFragment()
            transaction.add(R.id.frmList, myDesignFragment!!, "MyDesignFragment")
        }
        when (type) {
            ValueKey.AVATAR_TYPE -> {
                myAvatarFragment?.let { transaction.show(it) }
                myDesignFragment?.let { transaction.hide(it) }
            }
            ValueKey.MY_DESIGN_TYPE -> {
                myAvatarFragment?.let { transaction.hide(it) }
                myDesignFragment?.let { transaction.show(it) }
            }
        }

        transaction.commit()
    }

    @SuppressLint("MissingSuperCall", "GestureBackNavigation")
    override fun onBackPressed() {
        startIntentWithClearTop(HomeActivity::class.java)
    }

//    fun initNativeCollab() {
//        Admob.getInstance().loadNativeCollapNotBanner(this,getString(R.string.native_cl_myWork), binding.flNativeCollab)
//    }
//    override fun initAds() {
//        initNativeCollab()
//        Admob.getInstance().loadNativeAd(
//            this,
//            getString(R.string.native_myWork),
//            binding.nativeAds,
//            R.layout.ads_native_banner
//        )
//    }

    override fun onRestart() {
        super.onRestart()
        android.util.Log.w(
            "MyCreationActivity",
            "🔄 onRestart() called - Activity restarting after being stopped"
        )
        android.util.Log.w(
            "MyCreationActivity",
            "Current tab: ${when (viewModel.typeStatus.value) { ValueKey.AVATAR_TYPE -> "MyAvatar"; else -> "MyDesign" }}"
        )
        android.util.Log.w("MyCreationActivity", "Selection mode: $isInSelectionMode")

        // Check permission status
        val hasPermission =
            checkPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE))
        android.util.Log.w("MyCreationActivity", "📱 Storage permission: $hasPermission")

        // Exit selection mode when returning from another activity
        if (isInSelectionMode) {
            val avatarFragment = supportFragmentManager.findFragmentByTag("MyAvatarFragment")
            val designFragment = supportFragmentManager.findFragmentByTag("MyDesignFragment")

            when {
                avatarFragment is MyAvatarFragment && avatarFragment.isVisible -> avatarFragment.resetSelectionMode()
                designFragment is MyDesignFragment && designFragment.isVisible -> designFragment.resetSelectionMode()
            }
            exitSelectionMode()
        }

        // initNativeCollab()
        android.util.Log.w("MyCreationActivity", "🔄 onRestart() END")
    }

    override fun onStart() {
        super.onStart()
        android.util.Log.w("MyCreationActivity", "🔵 onStart() called - Activity becoming visible")
    }

    override fun onResume() {
        super.onResume()
        android.util.Log.w("MyCreationActivity", "🟢 onResume() called - Activity in foreground")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.w("MyCreationActivity", "🟡 onPause() called - Activity losing focus")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.w("MyCreationActivity", "🔴 onStop() called - Activity no longer visible")
    }

    fun enterSelectionMode() {
        isInSelectionMode = true
        isAllSelected = false
        binding.actionBar.apply {
            btnActionBarNextRight.visible()
            btnActionBarNextRight.setImageResource(R.drawable.ic_delete_creation)
            btnActionBarNextRight.translationY = 0f * resources.displayMetrics.density
            btnActionBarRight.updateLayoutParams {
                width = (26f*resources.displayMetrics.density).toInt()
                height = (26f*resources.displayMetrics.density).toInt()
            }

            btnActionBarNextRight.updateLayoutParams {
                width = (26f*resources.displayMetrics.density).toInt()
                height = (26f*resources.displayMetrics.density).toInt()
            }
            btnActionBarRight.visible()
            btnActionBarRight.setImageResource(R.drawable.ic_not_select_all)
            btnActionBarNextRight1.gone()
        }
        // Show share/download bottom view for both tabs
        binding.flBottomView.visible()
        // Avatar tab: keep lnlBottom (whatsapp/telegram), move closer to flBottomView
        // Design tab: hide lnlBottom (no whatsapp/telegram)
        if (viewModel.typeStatus.value == ValueKey.AVATAR_TYPE) {
            binding.lnlBottom.visible()
            binding.lnlBottom.translationY = (15f * resources.displayMetrics.density)
        } else {
            binding.lnlBottom.gone()
        }
    }

    fun exitSelectionMode() {
        isInSelectionMode = false
        isAllSelected = false
        binding.actionBar.apply {
            btnActionBarNextRight.gone()
            btnActionBarRight.gone()
        }
        binding.flBottomView.gone()
        val currentlyEmpty = when (viewModel.typeStatus.value) {
            ValueKey.AVATAR_TYPE -> myAvatarFragment?.getAllPaths()?.isEmpty() ?: true
            ValueKey.MY_DESIGN_TYPE -> myDesignFragment?.getAllPaths()?.isEmpty() ?: true
            else -> true
        }
        if (!currentlyEmpty) {
            if (viewModel.typeStatus.value == ValueKey.AVATAR_TYPE) {
                binding.lnlBottom.visible()
            } else {
                binding.lnlBottom.invisible()
            }
            binding.lnlBottom.translationY = (-0f*resources.displayMetrics.density)
        }
    }

    private fun updateBottomButtonsVisibility() {
        val layoutBottom = binding.lnlBottom.getChildAt(0)
        val btnRight = layoutBottom.findViewById<View>(R.id.btnRight)
        val btnLeft = layoutBottom.findViewById<View>(R.id.btnLeft)
        val imgBgBtnLeft = layoutBottom.findViewById<android.widget.ImageView>(R.id.imgBgBtnLeft)
        val imgBgBtnRight = layoutBottom.findViewById<android.widget.ImageView>(R.id.imgBgBtnRight)
        val tvLeft = layoutBottom.findViewById<android.widget.TextView>(R.id.tvTelegram)
        val tvRight = layoutBottom.findViewById<android.widget.TextView>(R.id.tvWhatsapp)

        // Bottom buttons always visible, content depends on current tab
        btnLeft?.visible()
        btnRight?.visible()

        if (viewModel.typeStatus.value == ValueKey.AVATAR_TYPE) {
            imgBgBtnLeft?.setImageResource(R.drawable.bg_btn_telegram)
            imgBgBtnRight?.setImageResource(R.drawable.bg_btn_whatsapp)
            tvLeft?.setText(R.string.add_to_telegram)
            tvRight?.setText(R.string.add_to_whatsapp)

        } else {
            imgBgBtnLeft?.setImageResource(R.drawable.bg_btn_layout_bottom)
            imgBgBtnRight?.setImageResource(R.drawable.bg_btn_layout_bottom)
            tvLeft?.setText(R.string.share)
            tvRight?.setText(R.string.download)

        }

        // ActionBar download/share buttons: only in selection mode (avatar tab only)
        binding.actionBar.apply {
            if (isInSelectionMode && viewModel.typeStatus.value == ValueKey.AVATAR_TYPE) {
                btnActionBarNextRight.setImageResource(R.drawable.ic_download_actionbar)
                btnActionBarNextRight1.setImageResource(R.drawable.ic_share_actionbar)
                btnActionBarNextRight.invisible()
                btnActionBarNextRight1.invisible()
            } else {
                btnActionBarNextRight.setImageResource(R.drawable.ic_download_actionbar)
                btnActionBarNextRight1.setImageResource(R.drawable.ic_share_actionbar)
                btnActionBarNextRight.invisible()
                btnActionBarNextRight1.invisible()
            }
        }
    }

    private fun setupSelectedTab(textView: DoubleStrokeTextView) {
        textView.setTextColor(Color.parseColor("#FFFFFF"))
      //  textView.setShadowLayer(2f, 0f, 2f, Color.WHITE)
       // textView.setupSelectedTab()
    }

    private fun setupUnselectedTab(textView: com.create.lalala.core.custom.text.DoubleStrokeTextView) {
        textView.setTextColor(Color.parseColor("#333333"))
       // textView.setupUnselectedTab()
    }

    // Public method to update select all icon based on selection state
    fun updateSelectAllIcon(allSelected: Boolean) {
        isAllSelected = allSelected
        if (allSelected) {
            binding.actionBar.btnActionBarRight.setImageResource(R.drawable.ic_select_all)
        } else {
            binding.actionBar.btnActionBarRight.setImageResource(R.drawable.ic_not_select_all)
        }
    }
}