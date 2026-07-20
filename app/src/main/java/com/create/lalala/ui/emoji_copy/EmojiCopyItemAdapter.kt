package com.create.lalala.ui.emoji_copy

import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap
import com.create.lalala.databinding.ItemEmojiCopyBinding

class EmojiCopyItemAdapter :
    BaseAdapter<String, ItemEmojiCopyBinding>(ItemEmojiCopyBinding::inflate) {

    var onItemClick: ((String) -> Unit) = {}

    override fun onBind(binding: ItemEmojiCopyBinding, item: String, position: Int) {
        binding.tvEmoji.text = item
        binding.tvEmoji.select()
        binding.root.tap(800) {
            onItemClick.invoke(item)
        }
    }
}
