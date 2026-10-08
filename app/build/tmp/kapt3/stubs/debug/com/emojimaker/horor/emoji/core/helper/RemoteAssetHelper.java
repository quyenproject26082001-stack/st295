package com.emojimaker.horor.emoji.core.helper;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0014j\b\u0012\u0004\u0012\u00020\u0005`\u00152\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0018J4\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0014j\b\u0012\u0004\u0012\u00020\u0005`\u00152\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0018J(\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/emojimaker/horor/emoji/core/helper/RemoteAssetHelper;", "", "<init>", "()V", "TAG", "", "BATCH_SIZE", "", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "cacheMutex", "Lkotlinx/coroutines/sync/Mutex;", "memoryCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getSequentialRemoteAssets", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "baseUrl", "extensions", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "probeSequentialRemoteAssets", "resolveRemoteUrl", "index", "probeRemoteAsset", "Lcom/emojimaker/horor/emoji/core/helper/RemoteAssetHelper$ProbeResult;", "url", "probeRemoteAssetWithRangeGet", "", "ProbeResult", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public final class RemoteAssetHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "RemoteAssetHelper";
    private static final int BATCH_SIZE = 10;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy client$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.sync.Mutex cacheMutex = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<java.lang.String>> memoryCache = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.core.helper.RemoteAssetHelper INSTANCE = null;
    
    private RemoteAssetHelper() {
        super();
    }
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSequentialRemoteAssets(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> extensions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<java.lang.String>> $completion) {
        return null;
    }
    
    private final java.lang.Object probeSequentialRemoteAssets(java.lang.String baseUrl, java.util.List<java.lang.String> extensions, kotlin.coroutines.Continuation<? super java.util.ArrayList<java.lang.String>> $completion) {
        return null;
    }
    
    private final java.lang.String resolveRemoteUrl(java.lang.String baseUrl, int index, java.util.List<java.lang.String> extensions) {
        return null;
    }
    
    private final com.emojimaker.horor.emoji.core.helper.RemoteAssetHelper.ProbeResult probeRemoteAsset(java.lang.String url) {
        return null;
    }
    
    private final boolean probeRemoteAssetWithRangeGet(java.lang.String url) {
        return false;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/emojimaker/horor/emoji/core/helper/RemoteAssetHelper$ProbeResult;", "", "<init>", "(Ljava/lang/String;I)V", "FOUND", "MISSING", "RETRY_WITH_GET", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
    static enum ProbeResult {
        /*public static final*/ FOUND /* = new FOUND() */,
        /*public static final*/ MISSING /* = new MISSING() */,
        /*public static final*/ RETRY_WITH_GET /* = new RETRY_WITH_GET() */;
        
        ProbeResult() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.emojimaker.horor.emoji.core.helper.RemoteAssetHelper.ProbeResult> getEntries() {
            return null;
        }
    }
}