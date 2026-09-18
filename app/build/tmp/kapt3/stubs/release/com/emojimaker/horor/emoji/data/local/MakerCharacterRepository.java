package com.emojimaker.horor.emoji.data.local;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0082@\u00a2\u0006\u0002\u0010\u000eJ&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001cj\b\u0012\u0004\u0012\u00020\u0012`\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J,\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@\u00a2\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/MakerCharacterRepository;", "", "<init>", "()V", "SOURCE_LOCAL", "", "SOURCE_API", "JSON_CHUNK_SIZE", "", "hasSource", "", "context", "Landroid/content/Context;", "source", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceLocalCharacters", "models", "", "Lcom/emojimaker/horor/emoji/data/model/custom/CustomizeModel;", "(Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceApiCharacters", "clearApiCharacters", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importLegacyApiIfNeeded", "fileName", "readLegacyJsonInChunks", "key", "getAllCharacters", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "replaceSource", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_release"})
public final class MakerCharacterRepository {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOURCE_LOCAL = "local";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOURCE_API = "api";
    private static final int JSON_CHUNK_SIZE = 65536;
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.data.local.MakerCharacterRepository INSTANCE = null;
    
    private MakerCharacterRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object hasSource(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object replaceLocalCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.model.custom.CustomizeModel> models, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object replaceApiCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.model.custom.CustomizeModel> models, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearApiCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importLegacyApiIfNeeded(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object readLegacyJsonInChunks(android.content.Context context, java.lang.String key, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllCharacters(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.emojimaker.horor.emoji.data.model.custom.CustomizeModel>> $completion) {
        return null;
    }
    
    private final java.lang.Object replaceSource(android.content.Context context, java.lang.String source, java.util.List<com.emojimaker.horor.emoji.data.model.custom.CustomizeModel> models, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}