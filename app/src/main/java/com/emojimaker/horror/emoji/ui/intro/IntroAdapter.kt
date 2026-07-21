package com.emojimaker.horor.emoji.ui.intro

import android.content.Context
import com.emojimaker.horor.emoji.core.base.BaseAdapter
import com.emojimaker.horor.emoji.core.extensions.loadImage
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.strings
import com.emojimaker.horor.emoji.data.model.IntroModel
import com.emojimaker.horor.emoji.databinding.ItemIntroBinding

class IntroAdapter(val context: Context) : BaseAdapter<IntroModel, ItemIntroBinding>(
    ItemIntroBinding::inflate
) {
    override fun onBind(binding: ItemIntroBinding, item: IntroModel, position: Int) {
        binding.apply {
            loadImage(root, item.image, imvImage, false)
            tvContent.text = context.strings(item.content)
            tvContent.select()
        }
    }
}