package com.emojimaker.horor.emoji.ui.customize

import android.graphics.Color
import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.data.model.SelectedModel
import com.emojimaker.horor.emoji.databinding.ItemColorTextEmojiBinding

class TextColorEmojiAdapter : BaseAdapter<SelectedModel, ItemColorTextEmojiBinding>(ItemColorTextEmojiBinding::inflate) {
    var onTextColorClick: ((Int, Int) -> Unit) = { _, _ -> }

    override fun onBind(binding: ItemColorTextEmojiBinding, item: SelectedModel, position: Int) {
        binding.apply {
            cardTextColorEmoji.strokeWidth = if (item.isSelected) dp(binding, 3) else 0
            cardTextColorEmoji.strokeColor = Color.parseColor("#FF8600")
            cardTextColorEmoji.setCardBackgroundColor(item.color)
            tvColor.text = ""
            tvColor.select()
            root.tap { onTextColorClick.invoke(item.color, position) }
        }
    }

    fun submitItem(position: Int, list: ArrayList<SelectedModel>) {
        items.clear()
        items.addAll(list.mapIndexed { index, item -> item.copy(isSelected = index == position) })
        notifyDataSetChanged()
    }

    private fun dp(binding: ItemColorTextEmojiBinding, value: Int): Int {
        return (value *  binding.root.resources.displayMetrics.density).toInt()
    }
}
