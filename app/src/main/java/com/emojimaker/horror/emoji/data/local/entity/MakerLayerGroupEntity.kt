package com.emojimaker.horor.emoji.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "maker_layer_groups",
    foreignKeys = [ForeignKey(
        entity = MakerCharacterEntity::class,
        parentColumns = ["id"],
        childColumns = ["characterId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["characterId", "sortOrder"])]
)
data class MakerLayerGroupEntity(
    @PrimaryKey val id: String,
    val characterId: String,
    val positionCustom: Int,
    val positionNavigation: Int,
    val imageNavigation: String,
    val type: Int,
    val sortOrder: Int
)
