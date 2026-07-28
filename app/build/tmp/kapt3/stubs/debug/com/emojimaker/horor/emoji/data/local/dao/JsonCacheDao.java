package com.emojimaker.horor.emoji.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u000e\u00c0\u0006\u0003"}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/dao/JsonCacheDao;", "", "getJson", "", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countKey", "", "upsert", "", "cache", "Lcom/emojimaker/horor/emoji/data/local/entity/JsonCacheEntity;", "(Lcom/emojimaker/horor/emoji/data/local/entity/JsonCacheEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByKey", "ST295_Horror_Emoji_Maker_V1.0.1_07.28.2026_debug"})
@androidx.room.Dao()
public abstract interface JsonCacheDao {
    
    @androidx.room.Query(value = "SELECT json FROM json_cache WHERE `key` = :key LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getJson(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM json_cache WHERE `key` = :key")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Upsert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.local.entity.JsonCacheEntity cache, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM json_cache WHERE `key` = :key")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}