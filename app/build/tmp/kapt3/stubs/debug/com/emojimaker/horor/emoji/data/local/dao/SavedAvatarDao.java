package com.emojimaker.horor.emoji.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0097@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0017\u00c0\u0006\u0003"}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/dao/SavedAvatarDao;", "", "getAll", "", "Lcom/emojimaker/horor/emoji/data/local/entity/SavedAvatarEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "", "getByPath", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", "deleteByPaths", "paths", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "items", "upsert", "item", "(Lcom/emojimaker/horor/emoji/data/local/entity/SavedAvatarEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceAll", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
@androidx.room.Dao()
public abstract interface SavedAvatarDao {
    
    @androidx.room.Query(value = "SELECT * FROM saved_avatars ORDER BY createdAt DESC, id DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM saved_avatars")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object count(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM saved_avatars WHERE pathInternalEdit = :path LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByPath(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity> $completion);
    
    @androidx.room.Query(value = "DELETE FROM saved_avatars")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clear(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM saved_avatars WHERE pathInternalEdit IN (:paths)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByPaths(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> paths, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public default java.lang.Object replaceAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        @java.lang.Deprecated()
        public static java.lang.Object replaceAll(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.data.local.dao.SavedAvatarDao $this, @org.jetbrains.annotations.NotNull()
        java.util.List<com.emojimaker.horor.emoji.data.local.entity.SavedAvatarEntity> items, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}