package com.emojimaker.horor.emoji.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.emojimaker.horor.emoji.data.local.entity.AppSettingEntity

@Dao
interface AppSettingDao {
    @Query("SELECT value FROM app_settings WHERE `key` = :key LIMIT 1")
    suspend fun getValue(key: String): String?

    @Query("SELECT COUNT(*) FROM app_settings")
    suspend fun count(): Int

    @Upsert
    suspend fun upsert(setting: AppSettingEntity)
}
