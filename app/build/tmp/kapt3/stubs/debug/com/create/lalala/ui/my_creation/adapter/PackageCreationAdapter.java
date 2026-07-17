package com.create.lalala.ui.my_creation.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000eH\u0014R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lcom/create/lalala/ui/my_creation/adapter/PackageCreationAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/PackageModel;", "Lcom/create/lalala/databinding/ItemPackageCreationBinding;", "<init>", "()V", "onItemClick", "Lkotlin/Function1;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onLongClick", "", "getOnLongClick", "setOnLongClick", "onItemTick", "getOnItemTick", "setOnItemTick", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "onBind", "binding", "item", "position", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class PackageCreationAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.PackageModel, com.create.lalala.databinding.ItemPackageCreationBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.create.lalala.data.model.PackageModel, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemTick;
    
    public PackageCreationAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.create.lalala.data.model.PackageModel, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.create.lalala.data.model.PackageModel, kotlin.Unit> p0) {
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
    
    @java.lang.Override()
    protected boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.PackageModel oldItem, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.PackageModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.PackageModel oldItem, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.PackageModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.create.lalala.databinding.ItemPackageCreationBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.PackageModel item, int position) {
    }
}