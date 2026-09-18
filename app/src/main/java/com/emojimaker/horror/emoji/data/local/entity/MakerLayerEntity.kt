package com.emojimaker.horor.emoji.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "maker_layers",
    foreignKeys = [ForeignKey(
        entity = MakerLayerGroupEntity::class,
        parentColumns = ["id"],
        childColumns = ["layerGroupId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["layerGroupId", "sortOrder"])]
)
data class MakerLayerEntity(
    @PrimaryKey val id: String,
    val layerGroupId: String,
    val image: String,
    val isMoreColors: Boolean,
    val thumb: String,
    val sortOrder: Int
)
