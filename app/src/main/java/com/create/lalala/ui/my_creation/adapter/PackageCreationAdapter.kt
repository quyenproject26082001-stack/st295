package com.create.lalala.ui.my_creation.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.gone
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
            imageViews.forEachIndexed { index, imageView ->
                val path = item.items.getOrNull(index)
                if (path.isNullOrEmpty()) {
                    imageView.gone()
                } else {
                    imageView.visible()
                    val file = File(path)
                    Glide.with(root.context)
                        .load(file.takeIf { it.exists() })
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .signature(ObjectKey(file.lastModified()))
                        .into(imageView)
                }
            }

            root.alpha = if (item.isSelected) 0.55f else 1f
            root.tap { onItemClick.invoke(item) }
            root.setOnLongClickListener {
                if (items.any { pkg -> pkg.isShowSelection }) return@setOnLongClickListener false
                onLongClick.invoke(position)
                true
            }
        }
    }
}
