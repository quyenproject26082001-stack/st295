package com.create.lalala.ui.customize

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.create.lalala.R
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.utils.key.AssetsKey
import com.create.lalala.data.model.custom.ItemNavCustomModel
import com.create.lalala.databinding.ItemCustomizeBinding
import com.bumptech.glide.Glide

class LayerCustomizeAdapter(val context: Context) : ListAdapter<ItemNavCustomModel, LayerCustomizeAdapter.CustomizeViewHolder>(DiffCallback) {

    var onItemClick: ((ItemNavCustomModel, Int) -> Unit) = { _, _ -> }
    var onNoneClick: ((Int) -> Unit) = {}
    var onRandomClick: (() -> Unit) = {}

    fun getLockedGifItems(): List<String> {
        return GifUnlockStore.getLockedItems(currentList)
    }

    fun getLockedGifItems(items: List<ItemNavCustomModel>): List<String> {
        return GifUnlockStore.getLockedItems(items)
    }

    fun getFirstLockedGifItem(items: List<ItemNavCustomModel>): String? {
        return GifUnlockStore.getFirstLockedItem(items)
    }

    fun getUnlockedGifPositions(items: List<ItemNavCustomModel>): List<Int> {
        return GifUnlockStore.getUnlockedPositions(items)
    }

    fun unlockGifItems(paths: List<String>) {
        GifUnlockStore.unlockItems(paths)
        notifyDataSetChanged()
    }

    inner class CustomizeViewHolder(val binding: ItemCustomizeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemNavCustomModel, position: Int) {
            binding.apply {
                val cornerRadiusPx = (16f * context.resources.displayMetrics.density).toInt()
                val isGifLocked = isGifLocked(item, position)

                val itemType = when (item.path) {
                    AssetsKey.NONE_LAYER -> "NONE"
                    AssetsKey.RANDOM_LAYER -> "RANDOM"
                    else -> "IMAGE"
                }
                android.util.Log.d(
                    "ItemCustomizeState",
                    "[$position] type=$itemType | isSelected=${item.isSelected} | path=${item.path} | colors=${item.listImageColor.size}"
                )

                if (item.isSelected) {
                    // Bring selected item to front with elevation
                    root.translationZ = 16f
                    root.scaleX = 1.0f
                    root.scaleY = 1.0f
                    vFocus.gone()

                    cardLayerItem.setBackgroundResource(R.drawable.layer_slt)
                    // vFocus.setBackgroundResource(R.drawable.bg_10_stroke_yellow)
                } else {
                    // Reset to normal state
                    root.translationZ = 0f
                    root.scaleX = 1f
                    root.scaleY = 1f
                    vFocus.gone()
                    cardLayerItem.setBackgroundResource(R.drawable.layer_uslt)


                }

                when (item.path) {
                    AssetsKey.NONE_LAYER -> {
                        btnNone.visible()
                        btnRandom.gone()
                        imvImage.gone()
                        vGifLock.gone()
                        sflShimmer.stopShimmer()
                        sflShimmer.gone()
                    }
                    AssetsKey.RANDOM_LAYER -> {
                        btnNone.gone()
                        btnRandom.visible()
                        imvImage.gone()
                        vGifLock.gone()
                        sflShimmer.stopShimmer()
                        sflShimmer.gone()
                    }
                    else -> {
                        btnNone.gone()
                        imvImage.visible()
                        btnRandom.gone()
                        if (isGifLocked) vGifLock.visible() else vGifLock.gone()
                        sflShimmer.visible()
                        sflShimmer.startShimmer()
                        Glide.with(root)
                            .load(item.thumb.ifEmpty { item.path })
                            .transform(RoundedCorners(cornerRadiusPx))
                            .listener(object : RequestListener<Drawable> {
                                override fun onResourceReady(r: Drawable, m: Any, t: Target<Drawable?>?, d: DataSource, f: Boolean): Boolean {
                                    sflShimmer.stopShimmer()
                                    sflShimmer.gone()
                                    return false
                                }
                                override fun onLoadFailed(e: GlideException?, m: Any?, t: Target<Drawable?>, f: Boolean): Boolean {
                                    return false
                                }
                            })
                            .into(imvImage)
                    }
                }

                binding.imvImage.tap(100) {
                    if (isGifLocked(item, position)) return@tap
                    onItemClick.invoke(item, position)
                }

                binding.btnRandom.tap {
                    android.util.Log.d("RandomLayer", "Adapter random clicked at adapterPosition=$bindingAdapterPosition")
                    onRandomClick.invoke()
                }

                binding.btnNone.tap { onNoneClick.invoke(position) }
            }

        }

        private fun isGifLocked(item: ItemNavCustomModel, position: Int): Boolean {
            return isGifLocked(item, position, currentList)
        }
    }

    private fun isGifLocked(item: ItemNavCustomModel, position: Int, items: List<ItemNavCustomModel>): Boolean {
        return GifUnlockStore.isLocked(item, position, items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomizeViewHolder {
        return CustomizeViewHolder(ItemCustomizeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomizeViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<ItemNavCustomModel>(){
            override fun areItemsTheSame(oldItem: ItemNavCustomModel, newItem: ItemNavCustomModel): Boolean {
                return oldItem.path == newItem.path
            }

            override fun areContentsTheSame(oldItem: ItemNavCustomModel, newItem: ItemNavCustomModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
