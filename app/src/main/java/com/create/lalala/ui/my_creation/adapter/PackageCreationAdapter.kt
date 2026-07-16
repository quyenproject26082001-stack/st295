package com.create.lalala.ui.my_creation.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.invisible
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.data.model.PackageModel
import com.create.lalala.databinding.ItemPackageCreationBinding
import java.io.File

class PackageCreationAdapter : BaseAdapter<PackageModel, ItemPackageCreationBinding>(ItemPackageCreationBinding::inflate) {
    var onItemClick: (PackageModel) -> Unit = {}
    var onLongClick: (Int) -> Unit = {}
    var onItemTick: (Int) -> Unit = {}

    override fun areItemsTheSame(oldItem: PackageModel, newItem: PackageModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PackageModel, newItem: PackageModel): Boolean {
        return oldItem == newItem
    }

    override fun onBind(binding: ItemPackageCreationBinding, item: PackageModel, position: Int) {
        binding.apply {
            tvPackageNameMycreation.text = item.name
            val imageViews = listOf(ivIt1, ivIt2, ivIt3, ivIt4)
            val itemViews = listOf(it1, it2, it3, it4)
            if (item.items.isEmpty()) ivNoItem.visible() else ivNoItem.gone()
            imageViews.forEachIndexed { index, imageView ->
                val path = item.items.getOrNull(index)
                if (path.isNullOrEmpty()) {
                    itemViews[index].invisible()
                } else {
                    itemViews[index].visible()
                    imageView.visible()
                    val file = File(path)
                    Glide.with(root.context)
                        .load(file.takeIf { it.exists() })
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .signature(ObjectKey(file.lastModified()))
                        .into(imageView)
                }
            }

            root.alpha = 1f
            if (item.isSelected) viewCover.visible() else viewCover.gone()
            if (item.isShowSelection) {
                btnSelect.visible()
                btnSelect.setImageResource(if (item.isSelected) R.drawable.ic_selected else R.drawable.ic_not_select)
            } else {
                btnSelect.gone()
            }
            root.tap { onItemClick.invoke(item) }
            btnSelect.tap { onItemTick.invoke(position) }
            root.setOnLongClickListener {
                if (items.any { pkg -> pkg.isShowSelection }) return@setOnLongClickListener false
                onLongClick.invoke(position)
                true
            }
        }
    }
}
