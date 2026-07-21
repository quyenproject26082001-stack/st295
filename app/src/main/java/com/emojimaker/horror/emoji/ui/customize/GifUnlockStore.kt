package com.emojimaker.horor.emoji.ui.customize

import com.emojimaker.horor.emoji.core.utils.key.AssetsKey
import com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel

object GifUnlockStore {
    fun getUnlockedPositions(items: List<ItemNavCustomModel>): List<Int> {
        return items.mapIndexedNotNull { index, item ->
            if (!isSpecialItem(item)) index else null
        }
    }

    private fun isSpecialItem(item: ItemNavCustomModel): Boolean {
        return item.path == AssetsKey.NONE_LAYER || item.path == AssetsKey.RANDOM_LAYER
    }
}
