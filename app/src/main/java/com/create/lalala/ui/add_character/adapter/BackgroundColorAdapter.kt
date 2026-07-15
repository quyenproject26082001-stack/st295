package com.create.lalala.ui.add_character.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.create.lalala.R
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.utils.key.AssetsKey
import com.create.lalala.data.model.SelectedModel
import com.create.lalala.databinding.ItemBackgroundColorBinding
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class BackgroundColorAdapter :
    BaseAdapter<SelectedModel, ItemBackgroundColorBinding>(ItemBackgroundColorBinding::inflate) {
    var onChooseColorClick: (() -> Unit) = {}
    var onBackgroundColorClick: ((Int, Int) -> Unit) = {_,_ ->}


    var currentSelected = -1
    override fun onBind(binding: ItemBackgroundColorBinding, item: SelectedModel, position: Int) {
        Log.d("BackgroundColorAdapter", "onBind position=$position, color=${String.format("#%06X", 0xFFFFFF and item.color)}, isSelected=${item.isSelected}, path=${item.path}")


        binding.apply {
            cardBackgroundColor.strokeWidth = if (item.isSelected) dp(2) else 0
            cardBackgroundColor.strokeColor = if (item.isSelected) Color.parseColor("#333333") else Color.TRANSPARENT

            val radiusPx = (10f *
                    root.context.resources.displayMetrics.density).toInt()
            if (position == 0) {
                Log.d("BackgroundColorAdapter", "Position 0: Loading img with CircleCrop")
                Glide.with(root.context).clear(imvColor)
                imvColor.background = null
                imvColor.scaleType = ImageView.ScaleType.CENTER_CROP
                Glide.with(root.context)
                    .load(R.drawable.img)
                    .transform(RoundedCorners(radiusPx))
                    .into(imvColor)
                root.tap { onChooseColorClick.invoke() }
            } else if (item.path == AssetsKey.NONE_LAYER) {
                Log.d("BackgroundColorAdapter", "Position $position: Loading none")
                Glide.with(root.context).clear(imvColor)
                imvColor.background = null
                imvColor.scaleType = ImageView.ScaleType.FIT_CENTER
                imvColor.setImageResource(R.drawable.ic_none_background)
                root.tap { onBackgroundColorClick.invoke(android.graphics.Color.TRANSPARENT, position) }
            } else {
                Log.d("BackgroundColorAdapter", "Position $position: Setting color background")
                Glide.with(root.context)
                    .clear(imvColor)
                imvColor.setImageDrawable(null)
                imvColor.background = null
                imvColor.scaleType = ImageView.ScaleType.CENTER_CROP
                Glide.with(root.context)
                    .load(ColorDrawable(item.color))
                    .transform(RoundedCorners(radiusPx))
                    .into(imvColor)
                root.tap { onBackgroundColorClick.invoke(item.color, position) }
            }
        }
    }

    private fun dp(value: Int): Int {
        return (value * android.content.res.Resources.getSystem().displayMetrics.density).toInt()
    }

    fun submitItem(position: Int, list: ArrayList<SelectedModel>){
        Log.d("BackgroundColorAdapter", "submitItem called with position=$position")
        Log.d("BackgroundColorAdapter", "Item at position 0: color=${String.format("#%06X", 0xFFFFFF and list[0].color)}, isSelected=${list[0].isSelected}")
        if (position == 0) {
            Log.d("BackgroundColorAdapter", "WARNING: Position 0 was selected!")
        }

        items.clear()
        items.addAll(list)

        if (position != currentSelected){
            Log.d("BackgroundColorAdapter", "Notifying changes for positions $currentSelected and $position")
            notifyItemChanged(currentSelected)
            notifyItemChanged(position)
            currentSelected = position
        } else {
            Log.d("BackgroundColorAdapter", "Notifying change for position $position")
            notifyItemChanged(position)
        }
    }
}
