package com.create.lalala.ui.customize

import android.graphics.Color
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemColorTextEmojiBinding

class TextColorEmojiAdapter : BaseAdapter<SelectedModel, ItemColorTextEmojiBinding>(ItemColorTextEmojiBinding::inflate) {
    var onTextColorClick: ((Int, Int) -> Unit) = { _, _ -> }

    override fun onBind(binding: ItemColorTextEmojiBinding, item: SelectedModel, position: Int) {
        binding.apply {
            cardTextColorEmoji.strokeWidth = if (item.isSelected) dp(binding, 3) else 0
            cardTextColorEmoji.strokeColor = Color.parseColor("#FF8600")
            cardTextColorEmoji.setCardBackgroundColor(item.color)
            tvColor.text = ""
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
