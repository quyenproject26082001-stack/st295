package com.create.lalala.ui.customize

import com.create.lalala.core.utils.key.AssetsKey
import com.create.lalala.data.model.custom.ItemNavCustomModel

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
