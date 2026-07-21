package com.emojimaker.horor.emoji.dialog

import android.app.Activity
import android.graphics.Color
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.updateLayoutParams
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseDialog
import com.emojimaker.horor.emoji.core.extensions.dp
import com.emojimaker.horor.emoji.core.extensions.setMargins
import com.emojimaker.horor.emoji.core.extensions.strings
import com.emojimaker.horor.emoji.databinding.DialogConfirmBinding

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
        if (isError && isInternetDialog()) {
            binding.btnNo.gone()
            binding.llButtons.setMargins(left = 70.dp(context), right = 70.dp(context))
            binding.btnYes.setMargins(left = 0, right = 0)
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
            if (isError && isInternetDialog()) {
                btnYes.text = context.strings(R.string.ok)
                btnYes.select()
            }
        }
    }

    private fun isInternetDialog(): Boolean {
        return title == R.string.no_internet ||
                description == R.string.please_check_your_internet ||
                description == R.string.internet_required_for_more_characters
    }
}
