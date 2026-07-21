package com.create.lalala.dialog

import android.animation.ObjectAnimator
import android.app.Activity
import android.view.animation.LinearInterpolator
import com.create.lalala.R
import com.create.lalala.core.base.BaseDialog
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.databinding.DialogLoadingBinding

class WaitingDialog(val context: Activity) :
    BaseDialog<DialogLoadingBinding>(context, maxWidth = true, maxHeight = true) {
    override val layoutId: Int = R.layout.dialog_loading
    override val isCancelOnTouchOutside: Boolean = false
    override val isCancelableByBack: Boolean = false

    private var spinnerAnim: ObjectAnimator? = null

    override fun initView() {
        context.hideNavigation(isBlack = false)
    }

    override fun onStart() {
        super.onStart()
        spinnerAnim = ObjectAnimator.ofFloat(binding.ivSpinner, "rotation", 0f, 360f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
            start()
        }
        context.hideNavigation(isBlack = false)   // 👈 sửa lại đây
    }

    override fun initAction() {}

    override fun onDismissListener() {
        spinnerAnim?.cancel()
        spinnerAnim = null
    }

}
