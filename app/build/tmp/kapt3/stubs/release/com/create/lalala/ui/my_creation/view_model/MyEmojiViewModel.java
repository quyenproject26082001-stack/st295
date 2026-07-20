package com.create.lalala.ui.my_creation.view_model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0006j\b\u0012\u0004\u0012\u00020\u0016`\bH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0006j\b\u0012\u0004\u0012\u00020\u0016`\bJ\u0006\u0010\u001e\u001a\u00020\u000eR$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/create/lalala/ui/my_creation/view_model/MyEmojiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_myEmojiList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/ArrayList;", "Lcom/create/lalala/data/model/MyAlbumModel;", "Lkotlin/collections/ArrayList;", "myEmojiList", "Lkotlinx/coroutines/flow/StateFlow;", "getMyEmojiList", "()Lkotlinx/coroutines/flow/StateFlow;", "loadMyEmoji", "", "context", "Landroid/content/Context;", "showLongClick", "positionSelect", "", "deleteItem", "pathList", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelect", "position", "selectAll", "shouldSelect", "", "getPathSelected", "clearSelection", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class MyEmojiViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.ArrayList<com.create.lalala.data.model.MyAlbumModel>> _myEmojiList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.create.lalala.data.model.MyAlbumModel>> myEmojiList = null;
    
    public MyEmojiViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.ArrayList<com.create.lalala.data.model.MyAlbumModel>> getMyEmojiList() {
        return null;
    }
    
    public final void loadMyEmoji(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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