package com.emojimaker.horor.emoji.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emojimaker.horor.emoji.data.local.dao.AppSettingDao
import com.emojimaker.horor.emoji.data.local.dao.JsonCacheDao
import com.emojimaker.horor.emoji.data.local.dao.MakerCharacterDao
import com.emojimaker.horor.emoji.data.local.dao.MediaItemDao
import com.emojimaker.horor.emoji.data.local.dao.SavedAvatarDao
import com.emojimaker.horor.emoji.data.local.entity.AppSettingEntity
import com.emojimaker.horor.emoji.data.local.entity.JsonCacheEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity
import com.emojimaker.horor.emoji.data.local.entity.MediaItemEntity
import com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity

@Database(
    entities = [
        AppSettingEntity::class,
        JsonCacheEntity::class,
        MakerCharacterEntity::class,
        MakerLayerGroupEntity::class,
        MakerLayerEntity::class,
        MakerColorEntity::class,
        SavedAvatarEntity::class,
        MediaItemEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appSettingDao(): AppSettingDao
    abstract fun jsonCacheDao(): JsonCacheDao
    abstract fun makerCharacterDao(): MakerCharacterDao
    abstract fun savedAvatarDao(): SavedAvatarDao
    abstract fun mediaItemDao(): MediaItemDao
}
