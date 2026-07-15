package com.create.lalala.ui.intro

import android.content.Context
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.strings
import com.create.lalala.data.model.IntroModel
import com.create.lalala.databinding.ItemIntroBinding

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