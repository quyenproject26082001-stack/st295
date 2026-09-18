package com.emojimaker.horor.emoji.ui.my_creation.adapter

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.data.model.PackageModel
import com.emojimaker.horor.emoji.databinding.ItemAddPackageBinding
import java.io.File

class AddPackageAdapter : BaseAdapter<PackageModel, ItemAddPackageBinding>(ItemAddPackageBinding::inflate) {
    companion object {
        const val ADD_ID = "add_package_item"
    }

    var selectedPackageId: String = ""
    var onAddClick: () -> Unit = {}
    var onPackageClick: (PackageModel) -> Unit = {}

    override fun areItemsTheSame(oldItem: PackageModel, newItem: PackageModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PackageModel, newItem: PackageModel): Boolean {
        return oldItem == newItem && oldItem.id != selectedPackageId && newItem.id != selectedPackageId
    }

    override fun onBind(binding: ItemAddPackageBinding, item: PackageModel, position: Int) {
        binding.apply {
            if (item.id == ADD_ID) {
                btnAdd.visible()
                btnAvailable.gone()
                btnAdd.tap { onAddClick.invoke() }
                return
            }

            btnAdd.gone()
            btnAvailable.visible()
            tvPackageName.text = item.name
            tvAddPackage.select()
            tvPackageName.select()
            val firstItemPath = item.items.firstOrNull().orEmpty()
            val file = File(firstItemPath)
            if (firstItemPath.isNotEmpty() && file.exists()) {
                Glide.with(root.context)
                    .load(file)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .signature(ObjectKey(file.lastModified()))
                    .into(ivItem)
            } else {
                Glide.with(root.context).clear(ivItem)
                ivItem.setImageResource(R.drawable.item_empty)
            }

            val selected = item.id == selectedPackageId
            btnAvailable.strokeColor = if (selected) ContextCompat.getColor(root.context, R.color.app) else Color.parseColor("#212121")
            btnAvailable.strokeWidth = root.resources.getDimensionPixelSize(if (selected) R.dimen.dp_3 else R.dimen.dp_0_5)
            btnAvailable.tap { onPackageClick.invoke(item) }
        }
    }

}
