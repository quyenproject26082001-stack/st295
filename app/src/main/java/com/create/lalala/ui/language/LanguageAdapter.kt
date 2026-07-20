package com.create.lalala.ui.language

import android.content.Context
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.LanguageModel
import com.create.lalala.databinding.ItemLanguageBinding

class LanguageAdapter(val context: Context) : BaseAdapter<LanguageModel, ItemLanguageBinding>(
    ItemLanguageBinding::inflate
) {
    var onItemClick: ((code: String) -> Unit) = {}
    var isFirstLanguage: Boolean = false

    override fun areItemsTheSame(oldItem: LanguageModel, newItem: LanguageModel): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: LanguageModel, newItem: LanguageModel): Boolean {
        return oldItem == newItem
    }

    override fun onBind(
        binding: ItemLanguageBinding, item: LanguageModel, position: Int
    ) {
        binding.apply {
            tvLang.text = "\u00A0${item.name}\u00A0"
            tvLang.select()
            imvFlag.setImageResource(item.flag)

            // Set text color based on selection state
            val textColor = if (item.activate) {
                android.graphics.Color.parseColor("#FFFFFF") // White when selected
            } else {
                android.graphics.Color.parseColor("#212121") // Dark blue when not selected
            }

            // Remove shader and set solid color
            tvLang.paint.shader = null
            tvLang.setTextColor(textColor)

            val ratio = if (item.activate) {
                R.drawable.ic_tick_lang
            } else {
                R.drawable.ic_not_tick_lang
            }
            btnRadio.setImageResource(ratio)

            // Apply color tint when activated and not first language
//            if (item.activate && !isFirstLanguage) {
//                btnRadio.setColorFilter(
//                    android.graphics.Color.parseColor("#01579B"),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//            } else {
//                btnRadio.clearColorFilter()
//            }

            // Set selected state to trigger the selector drawable
            flMain.isSelected = item.activate

            root.tap {
                onItemClick.invoke(item.code)
            }
        }
    }
}
