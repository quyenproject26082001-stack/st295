package com.create.lalala.ui.customize

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.create.lalala.R
import com.create.lalala.core.extensions.tap
import com.create.lalala.databinding.ItemColorCircleBinding

class DrawColorAdapter : RecyclerView.Adapter<DrawColorAdapter.ColorViewHolder>() {

    var onAddColorClick: (() -> Unit) = {}
    var onColorClick: ((Int) -> Unit) = {}
    private val colors = arrayListOf<Int?>(null, Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.YELLOW)
    private var selectedPosition = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(ItemColorCircleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colors[position], position)
    }

    override fun getItemCount(): Int = colors.size

    fun addColor(color: Int) {
        colors.add(1, color)
        selectedPosition = 1
        notifyDataSetChanged()
    }

    fun selectedColor(): Int = colors.getOrNull(selectedPosition) ?: Color.BLACK

    inner class ColorViewHolder(private val binding: ItemColorCircleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: Int?, position: Int) = with(binding) {
            root.post {
                val targetHeight = root.width
                if (targetHeight > 0 && root.layoutParams.height != targetHeight) {
                    root.layoutParams = root.layoutParams.apply {
                        height = targetHeight
                    }
                }
            }
            cardColorDraw.strokeWidth = if (position == selectedPosition && color != null) dp(3) else 0
            cardColorDraw.strokeColor = Color.parseColor("#212121")
            if (color == null) {
                imvColorDraw.setImageResource(R.drawable.add_color_emoji)
                imvColorDraw.background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.WHITE)
                }
            } else {
                imvColorDraw.setImageDrawable(null)
                imvColorDraw.background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(color)
                }
            }
            root.tap {
                if (color == null) {
                    onAddColorClick.invoke()
                } else {
                    selectedPosition = bindingAdapterPosition
                    notifyDataSetChanged()
                    onColorClick.invoke(color)
                }
            }
        }

        private fun dp(value: Int): Int {
            return (value * binding.root.resources.displayMetrics.density).toInt()
        }
    }
}
