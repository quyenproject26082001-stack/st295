package com.create.lalala.ui.add_character.adapter

import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.loadImageSticker
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemSpeechBinding

class SpeechAdapter : BaseAdapter<SelectedModel, ItemSpeechBinding>(ItemSpeechBinding::inflate) {
    var onItemClick: ((String) -> Unit) = {}

    override fun onBind(binding: ItemSpeechBinding, item: SelectedModel, position: Int) {
        binding.apply {
            loadImageSticker(root, item.path, imvSpeech)
            root.tap { onItemClick.invoke(item.path) }
        }
    }
}
