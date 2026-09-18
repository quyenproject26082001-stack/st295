package com.emojimaker.horor.emoji.dialog

import android.app.Activity
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseDialog
import com.emojimaker.horor.emoji.core.extensions.setMargins
import com.emojimaker.horor.emoji.core.extensions.strings
import com.emojimaker.horor.emoji.databinding.DialogConfirmBinding

class YesNoDialog(
    val context: Activity,
    val title: Int,
    val description: Int,
    val isError: Boolean = false,
    val notifAds: Boolean = false,
    val isReward: Boolean = false,
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
        if (isError && isSingleActionDialog()) {
            binding.btnNo.gone()
            binding.llButtons.setMargins(left = context.resources.getDimensionPixelSize(R.dimen.dp_70), right = context.resources.getDimensionPixelSize(R.dimen.dp_70))
            binding.btnYes.setMargins(left = 0, right = 0)
        }
        context.hideNavigation()
        binding.tvTitle.isSelected = true
        if(notifAds){
            binding.tvDescription.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.sp_18))
            binding.tvTitle.visibility ==View.GONE
        }
        if (isReward){
            binding.btnYes.setText(R.string.free1)
            binding.btnYes.setTextColor(ContextCompat.getColor(context,R.color.white))
            binding.btnNo.setText(R.string.cancel)
            binding.btnYes.setBackgroundResource(R.drawable.bg_dialog_btn_free)
            binding.btnYes.setPadding(
                context.resources.getDimensionPixelSize(R.dimen.dp_32),
                binding.btnYes.paddingTop,
                binding.btnYes.paddingRight,
                binding.btnYes.paddingBottom
            )
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
            if (isError && isSingleActionDialog()) {
                btnYes.text = context.strings(R.string.ok)
                btnYes.select()
            }
        }
    }

    private fun isSingleActionDialog(): Boolean {
        return title == R.string.no_internet ||
                description == R.string.please_check_your_internet ||
                description == R.string.internet_required_for_more_characters ||
                description == R.string.creation_data_updated_cannot_edit
    }
}
