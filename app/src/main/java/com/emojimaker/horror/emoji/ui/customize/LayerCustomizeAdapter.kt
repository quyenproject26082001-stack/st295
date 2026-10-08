package com.emojimaker.horor.emoji.ui.customize

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
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.utils.key.AssetsKey
import com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel
import com.emojimaker.horor.emoji.databinding.ItemCustomizeBinding
import com.bumptech.glide.Glide

class LayerCustomizeAdapter(val context: Context) : ListAdapter<ItemNavCustomModel, LayerCustomizeAdapter.CustomizeViewHolder>(DiffCallback) {

    var onItemClick: ((ItemNavCustomModel, Int) -> Unit) = { _, _ -> }
    var onNoneClick: ((Int) -> Unit) = {}
    var onRandomClick: (() -> Unit) = {}

    fun getUnlockedGifPositions(items: List<ItemNavCustomModel>): List<Int> {
        return GifUnlockStore.getUnlockedPositions(items)
    }

    inner class CustomizeViewHolder(val binding: ItemCustomizeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemNavCustomModel, position: Int) {
            binding.apply {
                val cornerRadiusPx = context.resources.getDimensionPixelSize(R.dimen.dp_16)
                val itemType = when (item.path) {
                    AssetsKey.NONE_LAYER -> "NONE"
                    AssetsKey.RANDOM_LAYER -> "RANDOM"
                    else -> "IMAGE"
                }
                android.util.Log.d(
                    "ItemCustomizeState",
                    "[$position] type=$itemType | isSelected=${item.isSelected} | path=${item.path} | colors=${item.listImageColor.size}"
                )

                bindSelection(item.isSelected)

                when (item.path) {
                    AssetsKey.NONE_LAYER -> {
                        btnNone.visible()
                        btnRandom.gone()
                        imvImage.gone()
                        sflShimmer.stopShimmer()
                        sflShimmer.gone()
                    }
                    AssetsKey.RANDOM_LAYER -> {
                        btnNone.gone()
                        btnRandom.visible()
                        imvImage.gone()
                        sflShimmer.stopShimmer()
                        sflShimmer.gone()
                    }
                    else -> {
                        btnNone.gone()
                        imvImage.visible()
                        btnRandom.gone()
                        sflShimmer.visible()
                        sflShimmer.startShimmer()
                        val imagePath = item.path
                        val thumbPath = item.thumb.ifEmpty { imagePath }
                        Glide.with(root)
                            .load(thumbPath)
                            .transform(RoundedCorners(cornerRadiusPx))
                            .error(
                                Glide.with(root)
                                    .load(imagePath)
                                    .transform(RoundedCorners(cornerRadiusPx))
                                    .listener(object : RequestListener<Drawable> {
                                        override fun onResourceReady(r: Drawable, m: Any, t: Target<Drawable?>?, d: DataSource, f: Boolean): Boolean {
                                            sflShimmer.stopShimmer()
                                            sflShimmer.gone()
                                            return false
                                        }

                                        override fun onLoadFailed(e: GlideException?, m: Any?, t: Target<Drawable?>, f: Boolean): Boolean {
                                            sflShimmer.stopShimmer()
                                            sflShimmer.gone()
                                            android.util.Log.e(
                                                "ItemCustomizeImage",
                                                "path fallback failed | thumb=$thumbPath | path=$imagePath | error=${e?.message}"
                                            )
                                            return false
                                        }
                                    })
                            )
                            .listener(object : RequestListener<Drawable> {
                                override fun onResourceReady(r: Drawable, m: Any, t: Target<Drawable?>?, d: DataSource, f: Boolean): Boolean {
                                    sflShimmer.stopShimmer()
                                    sflShimmer.gone()
                                    return false
                                }
                                override fun onLoadFailed(e: GlideException?, m: Any?, t: Target<Drawable?>, f: Boolean): Boolean {
                                    android.util.Log.e(
                                        "ItemCustomizeImage",
                                        "thumb failed and path fallback failed | thumb=$thumbPath | path=$imagePath | error=${e?.message}"
                                    )
                                    return false
                                }
                            })
                            .into(imvImage)
                    }
                }

                binding.imvImage.tap(100) {
                    val currentPosition = bindingAdapterPosition
                    if (currentPosition == RecyclerView.NO_POSITION) return@tap
                    val currentItem = getItem(currentPosition)
                    android.util.Log.d(
                        "ItemCustomizeClick",
                        "position=$currentPosition | adapterPosition=$bindingAdapterPosition | path=${currentItem.path} | thumb=${currentItem.thumb} | positionCustom=${currentItem.positionCustom} | positionNavigation=${currentItem.positionNavigation} | isSelected=${currentItem.isSelected} | colorCount=${currentItem.listImageColor.size}"
                    )
                    onItemClick.invoke(currentItem, currentPosition)
                }

                binding.btnRandom.tap {
                    android.util.Log.d("RandomLayer", "Adapter random clicked at adapterPosition=$bindingAdapterPosition")
                    onRandomClick.invoke()
                }

                binding.btnNone.tap {
                    val currentPosition = bindingAdapterPosition
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        onNoneClick.invoke(currentPosition)
                    }
                }
            }

        }

        fun bindSelection(isSelected: Boolean) {
            binding.apply {
                root.translationZ = if (isSelected) 16f else 0f
                root.scaleX = 1f
                root.scaleY = 1f
                vFocus.gone()
                cardLayerItem.setBackgroundResource(
                    if (isSelected) R.drawable.layer_slt else R.drawable.layer_uslt
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomizeViewHolder {
        return CustomizeViewHolder(ItemCustomizeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomizeViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
    override fun onBindViewHolder(
        holder: CustomizeViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads.all { it == SELECTION_PAYLOAD }) {
            holder.bindSelection(getItem(position).isSelected)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    companion object {
        private const val SELECTION_PAYLOAD = "selection"

        val DiffCallback = object : DiffUtil.ItemCallback<ItemNavCustomModel>(){
            override fun areItemsTheSame(oldItem: ItemNavCustomModel, newItem: ItemNavCustomModel): Boolean {
                return oldItem.path == newItem.path
            }

            override fun areContentsTheSame(oldItem: ItemNavCustomModel, newItem: ItemNavCustomModel): Boolean {
                return oldItem == newItem
            }

            override fun getChangePayload(oldItem: ItemNavCustomModel, newItem: ItemNavCustomModel): Any? {
                return if (oldItem.isSelected != newItem.isSelected &&
                    oldItem.copy(isSelected = newItem.isSelected) == newItem
                ) {
                    SELECTION_PAYLOAD
                } else {
                    null
                }
            }
        }
    }
}
