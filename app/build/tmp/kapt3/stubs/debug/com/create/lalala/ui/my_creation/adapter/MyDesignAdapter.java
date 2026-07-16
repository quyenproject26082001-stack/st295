package com.create.lalala.ui.my_creation.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000fH\u0014J\u001e\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0002R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/create/lalala/ui/my_creation/adapter/MyDesignAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/MyAlbumModel;", "Lcom/create/lalala/databinding/ItemMyDesignBinding;", "<init>", "()V", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onLongClick", "", "getOnLongClick", "setOnLongClick", "onItemTick", "getOnItemTick", "setOnItemTick", "onDeleteClick", "getOnDeleteClick", "setOnDeleteClick", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "onBind", "binding", "item", "position", "findRecyclerView", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "ST295_Horror_Emoji_Maker_v1.0.0_07.15.2026_debug"})
public final class MyDesignAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.MyAlbumModel, com.create.lalala.databinding.ItemMyDesignBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemTick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDeleteClick;
    
    public MyDesignAdapter() {
        super(null);
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
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnDeleteClick() {
        return null;
    }
    
    public final void setOnDeleteClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
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
    com.create.lalala.databinding.ItemMyDesignBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.MyAlbumModel item, int position) {
    }
    
    private final kotlin.Pair<androidx.recyclerview.widget.RecyclerView, android.view.View> findRecyclerView(android.view.View view) {
        return null;
    }
}