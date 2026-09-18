package com.emojimaker.horor.emoji.data.local;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "appSettingDao", "Lcom/emojimaker/horor/emoji/data/local/dao/AppSettingDao;", "jsonCacheDao", "Lcom/emojimaker/horor/emoji/data/local/dao/JsonCacheDao;", "makerCharacterDao", "Lcom/emojimaker/horor/emoji/data/local/dao/MakerCharacterDao;", "savedAvatarDao", "Lcom/emojimaker/horor/emoji/data/local/dao/SavedAvatarDao;", "mediaItemDao", "Lcom/emojimaker/horor/emoji/data/local/dao/MediaItemDao;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_release"})
@androidx.room.Database(entities = {com.emojimaker.horor.emoji.data.local.entity.AppSettingEntity.class, com.emojimaker.horor.emoji.data.local.entity.JsonCacheEntity.class, com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity.class, com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity.class, com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity.class, com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity.class, com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity.class, com.emojimaker.horor.emoji.data.local.entity.MediaItemEntity.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emojimaker.horor.emoji.data.local.dao.AppSettingDao appSettingDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emojimaker.horor.emoji.data.local.dao.JsonCacheDao jsonCacheDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emojimaker.horor.emoji.data.local.dao.MakerCharacterDao makerCharacterDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emojimaker.horor.emoji.data.local.dao.SavedAvatarDao savedAvatarDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.emojimaker.horor.emoji.data.local.dao.MediaItemDao mediaItemDao();
}