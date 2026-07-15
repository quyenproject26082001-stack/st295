package com.create.lalala.ui.choose_character

import androidx.core.content.ContextCompat
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.custom.CustomizeModel
import com.create.lalala.databinding.ItemChooseAvatarBinding

class ChooseCharacterAdapter : BaseAdapter<CustomizeModel, ItemChooseAvatarBinding>(ItemChooseAvatarBinding::inflate) {
    var onItemClick: ((position: Int) -> Unit) = {}


    override fun onBind(binding: ItemChooseAvatarBinding, item: CustomizeModel, position: Int) {
        binding.apply {
            //binding.imvImage.maskDrawable = ContextCompat.getDrawable(binding.root.context, R.drawable.mask_hexagon)

            loadImage(item.avatar, imvImage, onDismissLoading = {
                sflShimmer.stopShimmer()
                sflShimmer.gone()
            })
            root.tap { onItemClick.invoke(position) }
        }
    }
}