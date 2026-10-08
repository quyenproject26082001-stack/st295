package com.emojimaker.horor.emoji.ui.my_creation.view_model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ.\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0006j\b\u0012\u0004\u0012\u00020\u001d`\bH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0017J\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0006j\b\u0012\u0004\u0012\u00020\u001d`\bJ\u0006\u0010$\u001a\u00020\u0013R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/MyEmojiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_myEmojiList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/ArrayList;", "Lcom/emojimaker/horor/emoji/data/model/MyAlbumModel;", "Lkotlin/collections/ArrayList;", "myEmojiList", "Lkotlinx/coroutines/flow/StateFlow;", "getMyEmojiList", "()Lkotlinx/coroutines/flow/StateFlow;", "loadJob", "Lkotlinx/coroutines/Job;", "loadedRevision", "", "loadingRevision", "loadMyEmoji", "", "context", "Landroid/content/Context;", "force", "", "showLongClick", "positionSelect", "", "deleteItem", "pathList", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelect", "position", "selectAll", "shouldSelect", "getPathSelected", "clearSelection", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public final class MyEmojiViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> _myEmojiList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> myEmojiList = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job loadJob;
    private long loadedRevision = -1L;
    private long loadingRevision = -1L;
    
    public MyEmojiViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> getMyEmojiList() {
        return null;
    }
    
    public final void loadMyEmoji(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean force) {
    }
    
    public final void showLongClick(int positionSelect) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteItem(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> pathList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void toggleSelect(int position) {
    }
    
    public final void selectAll(boolean shouldSelect) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getPathSelected() {
        return null;
    }
    
    public final void clearSelection() {
    }
}