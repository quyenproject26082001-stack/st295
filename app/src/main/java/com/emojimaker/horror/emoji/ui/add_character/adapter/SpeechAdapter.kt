package com.emojimaker.horor.emoji.ui.add_character.adapter

import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.loadImageSticker
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.data.model.SelectedModel
import com.emojimaker.horor.emoji.databinding.ItemSpeechBinding

class SpeechAdapter : BaseAdapter<SelectedModel, ItemSpeechBinding>(ItemSpeechBinding::inflate) {
    var onItemClick: ((String) -> Unit) = {}

    override fun onBind(binding: ItemSpeechBinding, item: SelectedModel, position: Int) {
        binding.apply {
            loadImageSticker(root, item.path, imvSpeech)
            root.tap { onItemClick.invoke(item.path) }
        }
    }
}
