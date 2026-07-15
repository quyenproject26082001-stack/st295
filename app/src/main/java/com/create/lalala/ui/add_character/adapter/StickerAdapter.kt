package com.create.lalala.ui.add_character.adapter

import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.loadImageSticker
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemStickerBinding

class StickerAdapter : BaseAdapter<SelectedModel, ItemStickerBinding>(ItemStickerBinding::inflate) {
    var onItemClick : ((String) -> Unit) = {}
    override fun onBind(binding: ItemStickerBinding, item: SelectedModel, position: Int) {
        binding.apply {
            loadImageSticker(root, item.path, imvSticker)
            root.tap { onItemClick.invoke(item.path) }
        }
    }
}