package com.emojimaker.horor.emoji.dialog

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseDialog
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.data.local.PackageRepository
import com.emojimaker.horor.emoji.data.model.PackageModel
import com.emojimaker.horor.emoji.databinding.DialogAddPackageBinding
import com.emojimaker.horor.emoji.ui.my_creation.adapter.AddPackageAdapter

class AddPackageDialog(
    private val activity: Activity
) : BaseDialog<DialogAddPackageBinding>(activity, maxWidth = true, maxHeight = true) {

    override val layoutId: Int = R.layout.dialog_add_package
    override val isCancelOnTouchOutside: Boolean = true
    override val isCancelableByBack: Boolean = true

    var onCreateNewPackageClick: ((AddPackageDialog) -> Unit) = {}
    var onAddToPackageClick: ((String) -> Unit) = {}

    private val adapter = AddPackageAdapter()
    private var selectedPackageId = ""

    override fun initView() {
        binding.rcvPackage.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rcvPackage.adapter = adapter
        reloadPackages()
        updateAddButton()
    }

    override fun initAction() {
        binding.root.setOnClickListener { dismiss() }
        (binding.root as? android.view.ViewGroup)?.getChildAt(0)?.setOnClickListener { }
        adapter.onAddClick = {
            onCreateNewPackageClick.invoke(this)
        }
        adapter.onPackageClick = { packageModel ->
            selectedPackageId = packageModel.id
            adapter.selectedPackageId = packageModel.id
            adapter.notifyItemRangeChanged(0, adapter.itemCount)
            updateAddButton()
        }
        binding.btnAddPackage.tap {
            if (selectedPackageId.isEmpty()) return@tap
            onAddToPackageClick.invoke(selectedPackageId)
        }
    }

    override fun onDismissListener() {}

    fun reloadPackages() {
        val list = PackageRepository.getPackages(activity)
        list.add(0, PackageModel(AddPackageAdapter.ADD_ID, ""))
        adapter.submitList(list)
    }

    private fun updateAddButton() {
        val enabled = selectedPackageId.isNotEmpty()
        binding.btnAddPackage.isEnabled = enabled
        binding.btnAddPackage.alpha = if (enabled) 1f else 0.45f
    }
}
