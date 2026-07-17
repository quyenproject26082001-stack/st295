package com.create.lalala.ui.emoji_copy

import android.graphics.Color
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.databinding.ItemEmojiCopyTabBinding

class EmojiCopyTabAdapter :
    BaseAdapter<EmojiCopyCategory, ItemEmojiCopyTabBinding>(ItemEmojiCopyTabBinding::inflate) {

    var onItemClick: ((Int) -> Unit) = {}
    var selectedPosition: Int = 0
        set(value) {
            val oldPosition = field
            field = value
            notifyItemChanged(oldPosition)
            notifyItemChanged(value)
        }

    override fun onBind(binding: ItemEmojiCopyTabBinding, item: EmojiCopyCategory, position: Int) {
        val isSelected = position == selectedPosition
        binding.root.setBackgroundResource(
            if (isSelected) R.drawable.bg_creation_tab_selected else R.drawable.bg_creation_tab_unselected
        )
        binding.tvName.text = item.name
        binding.tvName.setTextColor(if (isSelected) Color.WHITE else Color.parseColor("#FF8600"))
        if (isSelected) binding.viewOverlay.gone() else binding.viewOverlay.visible()
        binding.root.tap(800) {
            onItemClick.invoke(position)
        }
    }
}
