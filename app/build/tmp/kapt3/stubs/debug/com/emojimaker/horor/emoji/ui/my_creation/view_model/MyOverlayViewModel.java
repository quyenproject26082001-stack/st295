package com.emojimaker.horor.emoji.ui.my_creation.view_model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J.\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0006j\b\u0012\u0004\u0012\u00020\u001a`\bH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000eJ\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0006j\b\u0012\u0004\u0012\u00020\u001a`\bJ\u0006\u0010!\u001a\u00020\u0011R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/MyOverlayViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_myOverlayList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/ArrayList;", "Lcom/emojimaker/horor/emoji/data/model/MyAlbumModel;", "Lkotlin/collections/ArrayList;", "myOverlayList", "Lkotlinx/coroutines/flow/StateFlow;", "getMyOverlayList", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLastItem", "", "isLastItem", "loadMyOverlay", "", "context", "Landroid/content/Context;", "showLongClick", "positionSelect", "", "checkLastItem", "deleteItem", "pathList", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelect", "position", "selectAll", "shouldSelect", "getPathSelected", "clearSelection", "ST295_Horror_Emoji_Maker_V1.0.1_07.23.2026_debug"})
public final class MyOverlayViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> _myOverlayList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> myOverlayList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLastItem = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLastItem = null;
    
    public MyOverlayViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.emojimaker.horor.emoji.data.model.MyAlbumModel>> getMyOverlayList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLastItem() {
        return null;
    }
    
    public final void loadMyOverlay(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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