package com.emojimaker.horor.emoji.ui.customize

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.custom.drawview.DrawView
import com.emojimaker.horor.emoji.data.model.draw.DrawableDraw
import com.emojimaker.horor.emoji.databinding.ItemLayerDrawBinding
import java.util.Collections

class EmojiLayerAdapter(
    private val drawView: DrawView,
    private val onItemClick: (DrawableDraw, Int) -> Unit
) : RecyclerView.Adapter<EmojiLayerAdapter.LayerViewHolder>() {

    var onStartDrag: ((RecyclerView.ViewHolder) -> Unit) = {}
    var onItemCountChanged: ((Int) -> Unit) = {}
    private val items = arrayListOf<DrawableDraw>()
    private var deleteVisiblePosition = RecyclerView.NO_POSITION

    fun submitDraws(draws: List<DrawableDraw>) {
        items.clear()
        items.addAll(draws)
        deleteVisiblePosition = RecyclerView.NO_POSITION
        notifyDataSetChanged()
        onItemCountChanged.invoke(items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayerViewHolder {
        return LayerViewHolder(ItemLayerDrawBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LayerViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size

    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition !in items.indices || toPosition !in items.indices) return false
        drawView.exchangeLayers(fromPosition, toPosition)
        Collections.swap(items, fromPosition, toPosition)
        if (deleteVisiblePosition == fromPosition) {
            deleteVisiblePosition = toPosition
        } else if (deleteVisiblePosition == toPosition) {
            deleteVisiblePosition = fromPosition
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun onItemDismiss(position: Int) {
        val draw = items.getOrNull(position) ?: return
        items.removeAt(position)
        deleteVisiblePosition = RecyclerView.NO_POSITION
        notifyItemRemoved(position)
        onItemCountChanged.invoke(items.size)
        drawView.remove(draw)
    }

    fun revealDelete(position: Int) {
        if (position !in items.indices) return
        val previousPosition = deleteVisiblePosition
        deleteVisiblePosition = position
        if (previousPosition != RecyclerView.NO_POSITION && previousPosition != position) {
            notifyItemChanged(previousPosition)
        }
        notifyItemChanged(position)
    }

    private fun hideDelete() {
        val previousPosition = deleteVisiblePosition
        deleteVisiblePosition = RecyclerView.NO_POSITION
        if (previousPosition != RecyclerView.NO_POSITION) notifyItemChanged(previousPosition)
    }

    inner class LayerViewHolder(private val binding: ItemLayerDrawBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(draw: DrawableDraw, position: Int) = with(binding) {
            btnShowLayer.setImageResource(if (draw.isHide) R.drawable.ic_unshow_emoji else R.drawable.ic_show_emoji)
            btnDelete.isVisible = position == deleteVisiblePosition
            Glide.with(root).load(draw.drawable).into(imvLayer)
            btnShowLayer.setOnClickListener {
                val adapterPosition = bindingAdapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    hideDelete()
                    val current = items[adapterPosition]
                    drawView.showOrHideDraw(current, adapterPosition)
                    notifyItemChanged(adapterPosition)
                }
            }
            btnDelete.setOnClickListener {
                val adapterPosition = bindingAdapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION) onItemDismiss(adapterPosition)
            }
            root.setOnClickListener {
                val adapterPosition = bindingAdapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    hideDelete()
                    onItemClick(items[adapterPosition], adapterPosition)
                }
            }
            root.setOnLongClickListener {
                onStartDrag.invoke(this@LayerViewHolder)
                true
            }
        }
    }
}
