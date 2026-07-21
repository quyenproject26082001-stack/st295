package com.create.lalala.ui.customize

import android.graphics.Color
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.setFont
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemFontBinding

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
