package com.emojimaker.horor.emoji.ui.emoji_copy

import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.databinding.ItemEmojiCopyBinding

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
