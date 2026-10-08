package com.emojimaker.horor.emoji.ui.my_creation.view_model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J.\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\u0006j\b\u0012\u0004\u0012\u00020 `\bH\u0086@\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eJ\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020 0\u0006j\b\u0012\u0004\u0012\u00020 `\bJ\u0006\u0010\'\u001a\u00020\u0016R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/MyDesignViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_myDesignList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/ArrayList;", "Lcom/emojimaker/horor/emoji/data/model/MyAlbumModel;", "Lkotlin/collections/ArrayList;", "myDesignList", "Lkotlinx/coroutines/flow/StateFlow;", "getMyDesignList", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLastItem", "", "isLastItem", "loadJob", "Lkotlinx/coroutines/Job;", "loadedRevision", "", "loadingRevision", "loadMyDesign", "", "context", "Landroid/content/Context;", "force", "showLongClick", "positionSelect", "", "checkLastItem", "deleteItem", "pathList", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelect", "position", "selectAll", "shouldSelect", "getPathSelected", "clearSelection", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public final class MyDesignViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> _myDesignList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> myDesignList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLastItem = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLastItem = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job loadJob;
    private long loadedRevision = -1L;
    private long loadingRevision = -1L;
    
    public MyDesignViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> getMyDesignList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLastItem() {
        return null;
    }
    
    public final void loadMyDesign(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean force) {
    }
    
    public final void showLongClick(int positionSelect) {
    }
    
    private final void checkLastItem() {
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