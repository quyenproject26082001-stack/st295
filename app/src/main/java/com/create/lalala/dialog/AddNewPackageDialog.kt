package com.create.lalala.dialog

import android.app.Activity
import com.create.lalala.R
import com.create.lalala.core.base.BaseDialog
import com.create.lalala.core.extensions.tap
import com.create.lalala.databinding.DialogAddNewPackageBinding

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
