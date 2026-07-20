package com.create.lalala.ui.add_character.adapter

import android.graphics.Color
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.R
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.loadImage
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.utils.key.AssetsKey
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemBackgroundImageBinding

class BackgroundImageAdapter :
    BaseAdapter<SelectedModel, ItemBackgroundImageBinding>(ItemBackgroundImageBinding::inflate) {
    var onAddImageClick: (() -> Unit) = {}
    var onBackgroundImageClick: ((String, Int) -> Unit) = { _, _ -> }
    var currentSelected = -1

    override fun submitList(list: List<SelectedModel>) {
        currentSelected = list.indexOfFirst { it.isSelected }
        super.submitList(list)
    }

    override fun onBind(binding: ItemBackgroundImageBinding, item: SelectedModel, position: Int) {
        binding.apply {
            tvAddImg.select()
            cardBackgroundImage.strokeWidth = if (item.isSelected) dp(2) else 0
            cardBackgroundImage.strokeColor = if (item.isSelected) Color.parseColor("#333333") else Color.TRANSPARENT
            if (position == 0) {
                lnlAddItem.visible()
                imvImage.gone()
                lnlAddItem.tap(800) { onAddImageClick.invoke() }
            } else if (item.path == AssetsKey.NONE_LAYER) {
                lnlAddItem.gone()
                imvImage.visible()
                Glide.with(root).clear(imvImage)
                imvImage.scaleType = android.widget.ImageView.ScaleType.FIT_CENTER
                imvImage.setImageResource(R.drawable.ic_none_background)
                imvImage.tap { onBackgroundImageClick.invoke(item.path, position) }
            } else {
                lnlAddItem.gone()
                imvImage.visible()
                imvImage.scaleType = android.widget.ImageView.ScaleType.CENTER_CROP
                val cornerRadiusPx = (10 * root.context.resources.displayMetrics.density).toInt()
                Glide.with(root)
                    .load(item.path)
                    .override(256, 256)
                    .encodeQuality(60)
                    .transform(RoundedCorners(cornerRadiusPx))
                    .into(imvImage)
                imvImage.tap { onBackgroundImageClick.invoke(item.path, position) }
            }
        }
    }

    private fun dp(value: Int): Int {
        return (value * android.content.res.Resources.getSystem().displayMetrics.density).toInt()
    }

    fun submitItem(position: Int, list: ArrayList<SelectedModel>) {
        items.clear()
        items.addAll(list)

        if (position != currentSelected) {
            if (currentSelected >= 0) {
                notifyItemChanged(currentSelected)
            }
            notifyItemChanged(position)

            currentSelected = position
        } else {
            notifyItemChanged(position)
        }
    }
}
