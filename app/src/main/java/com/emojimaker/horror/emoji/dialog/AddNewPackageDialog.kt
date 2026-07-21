package com.emojimaker.horor.emoji.dialog

import android.app.Activity
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseDialog
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.databinding.DialogAddNewPackageBinding

class AddNewPackageDialog(
    activity: Activity
) : BaseDialog<DialogAddNewPackageBinding>(activity, maxWidth = true, maxHeight = true) {

    override val layoutId: Int = R.layout.dialog_add_new_package
    override val isCancelOnTouchOutside: Boolean = true
    override val isCancelableByBack: Boolean = true

    var onAddPackageClick: ((String) -> Unit) = {}

    override fun initView() {}

    override fun initAction() {
        binding.root.setOnClickListener { dismiss() }
        (binding.root as? android.view.ViewGroup)?.getChildAt(0)?.setOnClickListener { }
        binding.btnAddPackageInput.tap {
            onAddPackageClick.invoke(binding.edPackage.text.toString().trim())
        }
    }

    override fun onDismissListener() {}
}
