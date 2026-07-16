package com.create.lalala.ui.my_creation.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.create.lalala.R
import com.create.lalala.core.base.BaseFragment
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.core.extensions.invisible
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.showInterAll
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.databinding.FragmentPackageBinding
import com.create.lalala.dialog.YesNoDialog
import com.create.lalala.ui.my_creation.MyCreationActivity
import com.create.lalala.ui.my_creation.adapter.PackageCreationAdapter
import com.create.lalala.ui.my_creation.view_model.MyCreationViewModel
import com.create.lalala.ui.my_creation.view_model.PackageViewModel
import com.create.lalala.ui.package_view.ViewAllPackageActivity
import kotlinx.coroutines.launch

class PackageFragment : BaseFragment<FragmentPackageBinding>() {
    private val viewModel: PackageViewModel by viewModels()
    private val myCreationViewModel: MyCreationViewModel by activityViewModels()
    private val packageAdapter by lazy { PackageCreationAdapter() }

    private val myAlbumActivity: MyCreationActivity
        get() = requireActivity() as MyCreationActivity

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPackageBinding {
        return FragmentPackageBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        binding.tvNoitem.select()
        binding.rcvMyDesign.adapter = packageAdapter
        binding.rcvMyDesign.itemAnimator = null
    }

    override fun dataObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.packageList.collect { list ->
                    packageAdapter.submitList(list)
                    binding.layoutNoItem.isVisible = list.isEmpty()
                    if (myCreationViewModel.typeStatus.value == ValueKey.PACKAGE_TYPE) {
                        myAlbumActivity.binding.lnlBottom.gone()
                    }
                }
            }
        }
    }

    override fun viewListener() {
        packageAdapter.onItemClick = { packageModel ->
            if (packageAdapter.items.any { it.isShowSelection }) {
                resetSelectionMode()
            } else {
                val intent = Intent(myAlbumActivity, ViewAllPackageActivity::class.java)
                intent.putExtra(IntentKey.PACKAGE_ID_KEY, packageModel.id)
                intent.putExtra(IntentKey.PACKAGE_NAME_KEY, packageModel.name)
                myAlbumActivity.showInterAll { startActivity(intent) }
            }
        }
        packageAdapter.onLongClick = { position ->
            viewModel.showLongClick(position)
            myAlbumActivity.enterSelectionMode()
            myAlbumActivity.updateSelectAllIcon(viewModel.packageList.value.all { it.isSelected })
        }
        packageAdapter.onItemTick = { position ->
            viewModel.toggleSelect(position)
            myAlbumActivity.updateSelectAllIcon(viewModel.packageList.value.all { it.isSelected })
        }
    }

    fun deleteSelectedItems() {
        val selectedIds = viewModel.getSelectedIds()
        if (selectedIds.isEmpty()) {
            myAlbumActivity.showToast(R.string.please_select_an_image)
            return
        }
        val dialog = YesNoDialog(myAlbumActivity, R.string.delete, R.string.are_you_sure_want_to_delete_this_item)
        LanguageHelper.setLocale(myAlbumActivity)
        dialog.show()
        dialog.onDismissClick = {
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
        }
        dialog.onNoClick = {
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
        }
        dialog.onYesClick = {
            viewModel.deleteSelected(myAlbumActivity)
            dialog.dismiss()
            myAlbumActivity.hideNavigation()
            myAlbumActivity.exitSelectionMode()
        }
    }

    fun selectAllItems() {
        viewModel.selectAll(true)
        packageAdapter.notifyItemRangeChanged(0, packageAdapter.itemCount)
    }

    fun deselectAllItems() {
        viewModel.selectAll(false)
        packageAdapter.notifyItemRangeChanged(0, packageAdapter.itemCount)
    }

    fun resetSelectionMode() {
        viewModel.clearSelection()
        myAlbumActivity.exitSelectionMode()
    }

    fun getAllPackageIds(): ArrayList<String> = viewModel.getAllIds()

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) myAlbumActivity.binding.lnlBottom.gone()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadPackages(myAlbumActivity)
    }
}
