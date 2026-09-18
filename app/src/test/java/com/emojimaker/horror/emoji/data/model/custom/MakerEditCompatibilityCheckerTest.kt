package com.emojimaker.horor.emoji.data.model.custom

import com.emojimaker.horor.emoji.core.utils.key.AssetsKey
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class MakerEditCompatibilityCheckerTest {
    @Test
    fun fingerprintRejectsChangedSourceData() {
        val original = character()
        val originalFingerprint = MakerEditCompatibilityChecker.fingerprint(original)
        val group = original.layerList.single()
        val firstLayer = group.layer.first()
        val changes = listOf(
            original.copy(avatar = "new_avatar.png"),
            original.copy(dataName = "data2"),
            original.copy(level = 2),
            original.copy(layerList = arrayListOf(group.copy(positionCustom = 1))),
            original.copy(layerList = arrayListOf(group.copy(layer = arrayListOf(firstLayer.copy(image = "new.png"))))),
            original.copy(layerList = arrayListOf(group.copy(layer = ArrayList(group.layer).apply {
                add(LayerModel(image = "added.png", thumb = "added_thumb.png"))
            })))
        )
        changes.forEach { changed ->
            assertNotEquals(originalFingerprint, MakerEditCompatibilityChecker.fingerprint(changed))
            assertEquals(
                MakerEditCompatibility.DATA_CHANGED,
                MakerEditCompatibilityChecker.check(
                    suggestion(original).copy(sourceDataFingerprint = originalFingerprint),
                    changed
                )
            )
        }
    }

    @Test
    fun unchangedDataRemainsEditable() {
        val original = character()
        val saved = suggestion(original).copy(
            sourceDataFingerprint = MakerEditCompatibilityChecker.fingerprint(original)
        )
        assertEquals(MakerEditCompatibility.COMPATIBLE, MakerEditCompatibilityChecker.check(saved, original))
    }

    @Test
    fun legacySnapshotRejectsRemovedItemAndChangedPosition() {
        val original = character()
        val saved = suggestion(original)
        val group = original.layerList.single()
        assertEquals(
            MakerEditCompatibility.DATA_CHANGED,
            MakerEditCompatibilityChecker.check(saved, original.copy(
                layerList = arrayListOf(group.copy(layer = arrayListOf(group.layer.first())))
            ))
        )
        assertEquals(
            MakerEditCompatibility.DATA_CHANGED,
            MakerEditCompatibilityChecker.check(saved, original.copy(
                layerList = arrayListOf(group.copy(positionNavigation = 1))
            ))
        )
    }

    @Test
    fun legacySnapshotAllowsAdditionalItemWhenOldItemsRemain() {
        val original = character()
        val group = original.layerList.single()
        val changed = original.copy(layerList = arrayListOf(group.copy(
            layer = ArrayList(group.layer).apply { add(LayerModel("new.png", thumb = "new_thumb.png")) }
        )))
        assertEquals(
            MakerEditCompatibility.COMPATIBLE,
            MakerEditCompatibilityChecker.check(suggestion(original), changed)
        )
    }

    @Test
    fun oldJsonWithoutNewFieldsUsesLegacyValidation() {
        val original = character()
        val oldJson = Gson().toJson(suggestion(original))
            .replace(Regex(",?\\\"sourceData(Name|Fingerprint)\\\":\\\"[^\\\"]*\\\""), "")
        val saved = Gson().fromJson(oldJson, SuggestionModel::class.java)
        assertEquals(MakerEditCompatibility.COMPATIBLE, MakerEditCompatibilityChecker.check(saved, original))
    }

    private fun character() = CustomizeModel(
        dataName = "data1",
        avatar = "avatar.png",
        layerList = arrayListOf(LayerListModel(
            positionCustom = 0,
            positionNavigation = 0,
            imageNavigation = "navigation.png",
            layer = arrayListOf(
                LayerModel("body.png", thumb = "body_thumb.png"),
                LayerModel("eyes.png", thumb = "eyes_thumb.png")
            )
        )),
        isFromAPI = true
    )

    private fun suggestion(model: CustomizeModel) = SuggestionModel(
        avatarPath = model.avatar,
        positionColorItemList = arrayListOf(0),
        itemNavList = arrayListOf(arrayListOf(
            ItemNavCustomModel(AssetsKey.RANDOM_LAYER, 0, 0),
            ItemNavCustomModel("body.png", 0, 0, thumb = "body_thumb.png"),
            ItemNavCustomModel("eyes.png", 0, 0, thumb = "eyes_thumb.png")
        )),
        colorItemNavList = arrayListOf(arrayListOf()),
        isSelectedItemList = arrayListOf(true),
        keySelectedItemList = arrayListOf("body.png"),
        isShowColorList = arrayListOf(true),
        pathSelectedList = arrayListOf("body.png")
    )
}
