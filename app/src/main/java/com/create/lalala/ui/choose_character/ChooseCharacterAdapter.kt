package com.create.lalala.ui.choose_character

import android.graphics.drawable.Drawable
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.create.lalala.core.base.BaseAdapter
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.tap
import com.create.lalala.data.model.custom.CustomizeModel
import com.create.lalala.databinding.ItemChooseAvatarBinding
import java.io.File

class ChooseCharacterAdapter : BaseAdapter<CustomizeModel, ItemChooseAvatarBinding>(ItemChooseAvatarBinding::inflate) {
    var onItemClick: ((position: Int) -> Unit) = {}


    override fun onBind(binding: ItemChooseAvatarBinding, item: CustomizeModel, position: Int) {
        binding.apply {
            //binding.imvImage.maskDrawable = ContextCompat.getDrawable(binding.root.context, R.drawable.mask_hexagon)

            val avatarPath = item.avatar
            val localFile = avatarPath.takeIf { it.isNotBlank() && !it.startsWith("http") }
                ?.let { File(it) }
            Log.d(
                "ChooseCharacterAvatar",
                "bind[$position] name='${item.dataName}' level=${item.level} isFromAPI=${item.isFromAPI} avatar='$avatarPath' localExists=${localFile?.exists()} localSize=${localFile?.length()}"
            )

            Glide.with(root)
                .load(avatarPath)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable?>,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e(
                            "ChooseCharacterAvatar",
                            "loadFailed[$position] name='${item.dataName}' model='$model' avatar='$avatarPath' causes=${e?.causes?.joinToString { it.message ?: it::class.simpleName.orEmpty() }}",
                            e
                        )
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable?>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d(
                            "ChooseCharacterAvatar",
                            "loadSuccess[$position] name='${item.dataName}' model='$model' source=$dataSource intrinsic=${resource.intrinsicWidth}x${resource.intrinsicHeight}"
                        )
                        sflShimmer.stopShimmer()
                        sflShimmer.gone()
                        return false
                    }
                })
                .into(imvImage)
            root.tap { onItemClick.invoke(position) }
        }
    }
}
