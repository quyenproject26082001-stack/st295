package com.create.lalala.data.local;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/create/lalala/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "appSettingDao", "Lcom/create/lalala/data/local/dao/AppSettingDao;", "jsonCacheDao", "Lcom/create/lalala/data/local/dao/JsonCacheDao;", "savedAvatarDao", "Lcom/create/lalala/data/local/dao/SavedAvatarDao;", "mediaItemDao", "Lcom/create/lalala/data/local/dao/MediaItemDao;", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
@androidx.room.Database(entities = {com.create.lalala.data.local.entity.AppSettingEntity.class, com.create.lalala.data.local.entity.JsonCacheEntity.class, com.create.lalala.data.local.entity.SavedAvatarEntity.class, com.create.lalala.data.local.entity.MediaItemEntity.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.create.lalala.data.local.dao.AppSettingDao appSettingDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.create.lalala.data.local.dao.JsonCacheDao jsonCacheDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.create.lalala.data.local.dao.SavedAvatarDao savedAvatarDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.create.lalala.data.local.dao.MediaItemDao mediaItemDao();
}