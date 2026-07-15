package com.create.lalala.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.create.lalala.data.local.dao.AppSettingDao
import com.create.lalala.data.local.dao.JsonCacheDao
import com.create.lalala.data.local.dao.MediaItemDao
import com.create.lalala.data.local.dao.SavedAvatarDao
import com.create.lalala.data.local.entity.AppSettingEntity
import com.create.lalala.data.local.entity.JsonCacheEntity
import com.create.lalala.data.local.entity.MediaItemEntity
import com.create.lalala.data.local.entity.SavedAvatarEntity

@Database(
    entities = [
        AppSettingEntity::class,
        JsonCacheEntity::class,
        SavedAvatarEntity::class,
        MediaItemEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appSettingDao(): AppSettingDao
    abstract fun jsonCacheDao(): JsonCacheDao
    abstract fun savedAvatarDao(): SavedAvatarDao
    abstract fun mediaItemDao(): MediaItemDao
}
