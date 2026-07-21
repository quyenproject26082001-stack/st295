package com.emojimaker.horor.emoji.ui.add_character.adapter

import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.loadImage
import com.emojimaker.horor.emoji.core.extensions.loadImageSticker
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.data.model.SelectedModel
import com.emojimaker.horor.emoji.databinding.ItemStickerBinding

class StickerAdapter : BaseAdapter<SelectedModel, ItemStickerBinding>(ItemStickerBinding::inflate) {
    var onItemClick : ((String) -> Unit) = {}
    override fun onBind(binding: ItemStickerBinding, item: SelectedModel, position: Int) {
        binding.apply {
            loadImageSticker(root, item.path, imvSticker)
            root.tap { onItemClick.invoke(item.path) }
        }
    }
}