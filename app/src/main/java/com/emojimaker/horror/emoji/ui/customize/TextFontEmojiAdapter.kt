package com.emojimaker.horor.emoji.ui.customize

import android.graphics.Color
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.setFont
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.data.model.SelectedModel
import com.emojimaker.horor.emoji.databinding.ItemFontBinding

class TextFontEmojiAdapter : BaseAdapter<SelectedModel, ItemFontBinding>(ItemFontBinding::inflate) {
    var onTextFontClick: ((Int, Int) -> Unit) = { _, _ -> }

    override fun onBind(binding: ItemFontBinding, item: SelectedModel, position: Int) {
        binding.apply {
            tvFont.setFont(item.color)
            tvFont.setTextColor(Color.parseColor("#FF8600"))
            cvMain.setBackgroundResource(if (item.isSelected) R.drawable.bg_slt_emoji_text else R.drawable.bg_circle_white)
            root.tap { onTextFontClick.invoke(item.color, position) }
        }
    }

    fun submitItem(position: Int, list: ArrayList<SelectedModel>) {
        items.clear()
        items.addAll(list.mapIndexed { index, item -> item.copy(isSelected = index == position) })
        notifyDataSetChanged()
    }
}
