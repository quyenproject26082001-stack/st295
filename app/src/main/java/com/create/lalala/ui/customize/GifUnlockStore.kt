package com.create.lalala.ui.customize

import com.create.lalala.core.utils.key.AssetsKey
import com.create.lalala.data.model.custom.ItemNavCustomModel

object GifUnlockStore {
    private val unlockedGifItems = linkedSetOf<String>()

    fun unlockItems(paths: List<String>) {
        unlockedGifItems.addAll(paths)
    }

    fun getLockedItems(items: List<ItemNavCustomModel>): List<String> {
        return items
            .filterIndexed { index, item ->
                !isSpecialItem(item) &&
                        !isInitiallyUnlocked(index, items) &&
                        item.path !in unlockedGifItems &&
                        item.thumb !in unlockedGifItems
            }
            .map { item -> item.thumb.ifEmpty { item.path } }
    }

    fun getFirstLockedItem(items: List<ItemNavCustomModel>): String? {
        return getLockedItems(items).firstOrNull()
    }

    fun getUnlockedPositions(items: List<ItemNavCustomModel>): List<Int> {
        return items.mapIndexedNotNull { index, item ->
            if (!isSpecialItem(item) && !isLocked(item, index, items)) index else null
        }
    }

    fun isLocked(item: ItemNavCustomModel, position: Int, items: List<ItemNavCustomModel>): Boolean {
        if (isSpecialItem(item)) return false
        if (isInitiallyUnlocked(position, items)) return false
        return item.path !in unlockedGifItems && item.thumb !in unlockedGifItems
    }

    private fun isInitiallyUnlocked(position: Int, items: List<ItemNavCustomModel>): Boolean {
        val realItemIndex = items
            .take(position + 1)
            .count { !isSpecialItem(it) } - 1
        if (realItemIndex < 0) return false
        return realItemIndex < getInitialUnlockedRealCount(items)
    }

    private fun getInitialUnlockedRealCount(items: List<ItemNavCustomModel>): Int {
        val realItemCount = items.count { !isSpecialItem(it) }
        return maxOf(MIN_INITIAL_UNLOCKED_ITEMS, realItemCount / 2).coerceAtMost(realItemCount)
    }

    private fun isSpecialItem(item: ItemNavCustomModel): Boolean {
        return item.path == AssetsKey.NONE_LAYER || item.path == AssetsKey.RANDOM_LAYER
    }

    private const val MIN_INITIAL_UNLOCKED_ITEMS = 2
}
