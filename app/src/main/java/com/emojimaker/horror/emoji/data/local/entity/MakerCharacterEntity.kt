package com.emojimaker.horor.emoji.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "maker_characters",
    indices = [
        Index(value = ["source"]),
        Index(value = ["level", "sortOrder"]),
        Index(value = ["source", "dataName"], unique = true)
    ]
)
data class MakerCharacterEntity(
    @PrimaryKey val id: String,
    val source: String,
    val dataName: String,
    val avatar: String,
    val level: Int,
    val isFromApi: Boolean,
    val sortOrder: Int,
    val updatedAt: Long = System.currentTimeMillis()
)
