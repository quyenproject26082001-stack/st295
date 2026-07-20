package com.create.lalala.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015\u00c0\u0006\u0003"}, d2 = {"Lcom/create/lalala/data/local/dao/MediaItemDao;", "", "getByAlbum", "", "Lcom/create/lalala/data/local/entity/MediaItemEntity;", "album", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countAlbum", "", "upsert", "", "item", "(Lcom/create/lalala/data/local/entity/MediaItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertAll", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByPaths", "paths", "deleteAlbumPaths", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
@androidx.room.Dao()
public abstract interface MediaItemDao {
    
    @androidx.room.Query(value = "SELECT * FROM media_items WHERE album = :album ORDER BY createdAt DESC, updatedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String album, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.create.lalala.data.local.entity.MediaItemEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM media_items WHERE album = :album")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countAlbum(@org.jetbrains.annotations.NotNull()
    java.lang.String album, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.local.entity.MediaItemEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.create.lalala.data.local.entity.MediaItemEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM media_items WHERE path IN (:paths)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByPaths(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> paths, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM media_items WHERE album = :album AND path IN (:paths)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAlbumPaths(@org.jetbrains.annotations.NotNull()
    java.lang.String album, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> paths, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}