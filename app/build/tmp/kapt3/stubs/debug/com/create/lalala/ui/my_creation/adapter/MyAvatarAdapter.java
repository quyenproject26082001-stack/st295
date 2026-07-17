package com.create.lalala.ui.my_creation.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020\u0002H\u0014J\u0018\u0010(\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020\u0002H\u0014J \u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0013H\u0014J\u001e\u0010-\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.2\u0006\u00101\u001a\u000200H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R$\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00062"}, d2 = {"Lcom/create/lalala/ui/my_creation/adapter/MyAvatarAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/MyAlbumModel;", "Lcom/create/lalala/databinding/ItemMyAlbumBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onLongClick", "", "getOnLongClick", "setOnLongClick", "onItemTick", "getOnItemTick", "setOnItemTick", "onEditClick", "getOnEditClick", "setOnEditClick", "onDeleteClick", "getOnDeleteClick", "setOnDeleteClick", "value", "", "isSelectMode", "()Z", "setSelectMode", "(Z)V", "areItemsTheSame", "oldItem", "newItem", "areContentsTheSame", "onBind", "binding", "item", "position", "findRecyclerView", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class MyAvatarAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.MyAlbumModel, com.create.lalala.databinding.ItemMyAlbumBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemTick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEditClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteClick;
    private boolean isSelectMode = false;
    
    public MyAvatarAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnLongClick() {
        return null;
    }
    
    public final void setOnLongClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnItemTick() {
        return null;
    }
    
    public final void setOnItemTick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnEditClick() {
        return null;
    }
    
    public final void setOnEditClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnDeleteClick() {
        return null;
    }
    
    public final void setOnDeleteClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    public final boolean isSelectMode() {
        return false;
    }
    
    public final void setSelectMode(boolean value) {
    }
    
    @java.lang.Override()
    protected boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel oldItem, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel oldItem, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.create.lalala.databinding.ItemMyAlbumBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel item, int position) {
    }
    
    private final kotlin.Pair<androidx.recyclerview.widget.RecyclerView, android.view.View> findRecyclerView(android.view.View view) {
        return null;
    }
}