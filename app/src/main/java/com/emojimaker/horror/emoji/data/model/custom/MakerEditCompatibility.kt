package com.emojimaker.horor.emoji.data.model.custom

import com.emojimaker.horor.emoji.core.utils.key.AssetsKey
import java.security.MessageDigest

enum class MakerEditCompatibility {
    COMPATIBLE,
    DATA_UNAVAILABLE,
    CREATION_NOT_FOUND,
    CHARACTER_NOT_FOUND,
    DATA_CHANGED,
    INVALID_SAVED_DATA,
}

object MakerEditCompatibilityChecker {
    fun fingerprint(model: CustomizeModel): String {
        val source = buildString {
            appendToken(model.dataName)
            appendToken(model.avatar)
            appendToken(model.level.toString())
            appendToken(model.isFromAPI.toString())
            model.layerList.forEach { group ->
                appendToken(group.positionCustom.toString())
                appendToken(group.positionNavigation.toString())
                appendToken(group.imageNavigation)
                appendToken(group.type.toString())
                group.layer.forEach { layer ->
                    appendToken(layer.image)
                    appendToken(layer.isMoreColors.toString())
                    appendToken(layer.thumb)
                    layer.listColor.forEach { color ->
                        appendToken(color.color)
                        appendToken(color.path)
                    }
                }
            }
        }
        return MessageDigest.getInstance("SHA-256")
            .digest(source.toByteArray(Charsets.UTF_8))
            .joinToString("") { byte -> "%02x".format(byte) }
    }

    fun check(saved: SuggestionModel, current: CustomizeModel): MakerEditCompatibility {
        if (saved.sourceDataFingerprint.orEmpty().isNotBlank()) {
            return if (saved.sourceDataFingerprint == fingerprint(current)) {
                MakerEditCompatibility.COMPATIBLE
            } else {
                MakerEditCompatibility.DATA_CHANGED
            }
        }
        return if (isLegacySnapshotCompatible(saved, current)) {
            MakerEditCompatibility.COMPATIBLE
        } else {
            MakerEditCompatibility.DATA_CHANGED
        }
    }

    private fun isLegacySnapshotCompatible(saved: SuggestionModel, current: CustomizeModel): Boolean {
        val layerCount = current.layerList.size
        if (layerCount == 0) return false
        val stateSizes = listOf(
            saved.positionColorItemList.size,
            saved.itemNavList.size,
            saved.colorItemNavList.size,
            saved.isSelectedItemList.size,
            saved.keySelectedItemList.size,
            saved.isShowColorList.size,
            saved.pathSelectedList.size,
        )
        if (stateSizes.any { it != layerCount }) return false
        if (saved.layerTransformList.isNotEmpty() && saved.layerTransformList.size != layerCount) return false

        val validPositions = (0 until layerCount).toSet()
        if (current.layerList.map { it.positionNavigation }.toSet() != validPositions) return false
        if (current.layerList.map { it.positionCustom }.toSet() != validPositions) return false

        current.layerList.forEach { group ->
            val navPosition = group.positionNavigation
            val customPosition = group.positionCustom
            val savedItems = saved.itemNavList[navPosition]
            if (savedItems.isEmpty()) return false
            if (savedItems.any {
                    it.positionNavigation != navPosition || it.positionCustom != customPosition
                }) return false

            val realItems = savedItems.filterNot {
                it.path == AssetsKey.NONE_LAYER || it.path == AssetsKey.RANDOM_LAYER
            }
            if (realItems.any { savedItem -> group.layer.none { savedItem.matches(it) } }) return false

            val currentPaths = group.layer.flatMap { layer ->
                buildList {
                    add(layer.image)
                    addAll(layer.listColor.map { it.path })
                }
            }.toSet()
            val selectedPath = saved.pathSelectedList[customPosition]
            if (selectedPath.isNotBlank() && selectedPath !in currentPaths) return false
            val selectedKey = saved.keySelectedItemList[navPosition]
            if (selectedKey.isNotBlank() && selectedKey !in currentPaths) return false

            val currentColors = group.layer.flatMap { layer -> layer.listColor.map { it.color } }.toSet()
            if (saved.colorItemNavList[navPosition].any { it.color !in currentColors }) return false
            val colorPosition = saved.positionColorItemList[navPosition]
            val savedColors = saved.colorItemNavList[navPosition]
            if (savedColors.isNotEmpty() && colorPosition !in savedColors.indices) return false
        }
        return true
    }

    private fun ItemNavCustomModel.matches(current: LayerModel): Boolean {
        if (listImageColor.isEmpty()) {
            return !current.isMoreColors && path == current.image && thumb == current.thumb
        }
        val currentColors = current.listColor.map { it.color to it.path }.toSet()
        val savedColors = listImageColor.map { it.color to it.path }.toSet()
        val pathMatches = path == current.image || current.listColor.any { it.path == path }
        return current.isMoreColors && thumb == current.thumb && pathMatches && currentColors.containsAll(savedColors)
    }

    private fun StringBuilder.appendToken(value: String) {
        append(value.length).append(':').append(value).append('|')
    }
}
