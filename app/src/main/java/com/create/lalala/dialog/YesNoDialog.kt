package com.create.lalala.dialog

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap
import com.create.lalala.R
import com.create.lalala.core.base.BaseDialog
import com.create.lalala.core.extensions.strings
import com.create.lalala.databinding.DialogConfirmBinding

class YesNoDialog(
    val context: Activity,
    val title: Int,
    val description: Int,
    val isError: Boolean = false,
    val notifAds: Boolean = false,
) : BaseDialog<DialogConfirmBinding>(context, maxWidth = true, maxHeight = true) {
    override val layoutId: Int = R.layout.dialog_confirm
    override val isCancelOnTouchOutside: Boolean = false
    override val isCancelableByBack: Boolean = false

    var onNoClick: (() -> Unit) = {}
    var onYesClick: (() -> Unit) = {}
    var onDismissClick: (() -> Unit) = {}

    override fun initView() {
        initText()
        initBackground()
        if (isError) {
            binding.btnNo.gone()
        }
        context.hideNavigation()
        binding.tvTitle.isSelected = true
        if(notifAds){
            binding.tvDescription.textSize = 18f
            binding.tvTitle.visibility ==View.GONE
        }
    }

    private fun initBackground() {
        binding.containerDialog.setBackgroundResource(R.drawable.bg_dialog_delete_exit)
        binding.btnNo.setBackgroundResource(R.drawable.bg_btn_dialog)
        binding.btnYes.setBackgroundResource(R.drawable.bg_btn_dialog)
       // val paddingVertical = (9 * context.resources.displayMetrics.density).toInt()
//        binding.btnNo.setPadding(0, paddingVertical, 0, paddingVertical)
//        binding.btnYes.setPadding(0, paddingVertical, 0, paddingVertical)
    }

    override fun initAction() {
        binding.apply {
            btnNo.tap { onNoClick.invoke() }
            btnYes.tap { onYesClick.invoke() }
            flOutSide.tap { onDismissClick.invoke() }
        }
    }

    override fun onDismissListener() {}

    private fun initText() {
        binding.apply {
            tvTitle.text = context.strings(title)
            tvDescription.text = context.strings(description)
            tvTitle.select()
            tvDescription.select()
            if (isError) {
                btnYes.text = context.strings(R.string.ok)
                btnYes.select()
            }
        }
    }
}
