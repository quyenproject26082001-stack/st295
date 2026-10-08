package com.emojimaker.horor.emoji.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0016\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u001c\u0010\u0017\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0019\u00c0\u0006\u0003"}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/dao/MakerCharacterDao;", "", "getCharacters", "", "Lcom/emojimaker/horor/emoji/data/local/entity/MakerCharacterEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLayerGroups", "Lcom/emojimaker/horor/emoji/data/local/entity/MakerLayerGroupEntity;", "getAllLayers", "Lcom/emojimaker/horor/emoji/data/local/entity/MakerLayerEntity;", "getAllColors", "Lcom/emojimaker/horor/emoji/data/local/entity/MakerColorEntity;", "countBySource", "", "source", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCharacters", "", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLayerGroups", "insertLayers", "insertColors", "deleteBySource", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
@androidx.room.Dao()
public abstract interface MakerCharacterDao {
    
    @androidx.room.Query(value = "SELECT * FROM maker_characters ORDER BY level ASC, CASE source WHEN \'local\' THEN 0 ELSE 1 END, sortOrder ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCharacters(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM maker_layer_groups ORDER BY characterId, sortOrder")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLayerGroups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM maker_layers ORDER BY layerGroupId, sortOrder")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLayers(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM maker_colors ORDER BY layerId, sortOrder")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllColors(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM maker_characters WHERE source = :source")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCharacters(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLayerGroups(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLayers(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertColors(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM maker_characters WHERE source = :source")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBySource(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}