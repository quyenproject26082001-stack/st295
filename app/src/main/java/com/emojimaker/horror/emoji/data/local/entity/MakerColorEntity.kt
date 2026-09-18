package com.emojimaker.horor.emoji.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "maker_colors",
    foreignKeys = [ForeignKey(
        entity = MakerLayerEntity::class,
        parentColumns = ["id"],
        childColumns = ["layerId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["layerId", "sortOrder"])]
)
data class MakerColorEntity(
    @PrimaryKey val id: String,
    val layerId: String,
    val color: String,
    val path: String,
    val sortOrder: Int
)
