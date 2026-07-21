package com.emojimaker.horor.emoji.ui.my_creation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.data.model.MyAlbumModel
import com.emojimaker.horor.emoji.databinding.ItemViewPackageBinding
import java.io.File

class PackageItemAdapter : BaseAdapter<MyAlbumModel, ItemViewPackageBinding>(ItemViewPackageBinding::inflate) {
    var onItemClick: (String) -> Unit = {}
    var onLongClick: (Int) -> Unit = {}
    var onItemTick: (Int) -> Unit = {}

    override fun areItemsTheSame(oldItem: MyAlbumModel, newItem: MyAlbumModel): Boolean {
        return oldItem.path == newItem.path
    }

    override fun areContentsTheSame(oldItem: MyAlbumModel, newItem: MyAlbumModel): Boolean {
        return oldItem == newItem
    }

    override fun onBind(binding: ItemViewPackageBinding, item: MyAlbumModel, position: Int) {
        binding.apply {
            val file = File(item.path)
            Glide.with(root.context)
                .load(file.takeIf { it.exists() })
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .signature(ObjectKey(file.lastModified()))
                .into(ivItem)

            if (item.isShowSelection) btnSelect.visible() else btnSelect.gone()
            btnSelect.setBackgroundResource(if (item.isSelected) R.drawable.ic_selected else R.drawable.ic_not_select)

            root.tap { onItemClick.invoke(item.path) }
            root.setOnLongClickListener {
                if (items.any { model -> model.isShowSelection }) return@setOnLongClickListener false
                val (rv, rvChild) = findRecyclerView(root) ?: return@setOnLongClickListener false
                val actualPos = rv.getChildAdapterPosition(rvChild)
                if (actualPos == RecyclerView.NO_POSITION) return@setOnLongClickListener false
                onLongClick.invoke(actualPos)
                true
            }
            btnSelect.tap {
                val (rv, rvChild) = findRecyclerView(root) ?: return@tap
                val actualPos = rv.getChildAdapterPosition(rvChild)
                if (actualPos != RecyclerView.NO_POSITION) onItemTick.invoke(actualPos)
            }
        }
    }

    private fun findRecyclerView(view: android.view.View): Pair<RecyclerView, android.view.View>? {
        var child: android.view.View = view
        var parent = view.parent
        while (parent != null) {
            if (parent is RecyclerView) return Pair(parent, child)
            child = parent as? android.view.View ?: return null
            parent = child.parent
        }
        return null
    }
}
