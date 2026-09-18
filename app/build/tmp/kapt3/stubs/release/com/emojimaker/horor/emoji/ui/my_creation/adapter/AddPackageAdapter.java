package com.emojimaker.horor.emoji.ui.my_creation.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/my_creation/adapter/AddPackageAdapter;", "Lcom/emojimaker/horor/emoji/core/base/BaseAdapter;", "Lcom/emojimaker/horor/emoji/data/model/PackageModel;", "Lcom/emojimaker/horor/emoji/databinding/ItemAddPackageBinding;", "<init>", "()V", "selectedPackageId", "", "getSelectedPackageId", "()Ljava/lang/String;", "setSelectedPackageId", "(Ljava/lang/String;)V", "onAddClick", "Lkotlin/Function0;", "", "getOnAddClick", "()Lkotlin/jvm/functions/Function0;", "setOnAddClick", "(Lkotlin/jvm/functions/Function0;)V", "onPackageClick", "Lkotlin/Function1;", "getOnPackageClick", "()Lkotlin/jvm/functions/Function1;", "setOnPackageClick", "(Lkotlin/jvm/functions/Function1;)V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "onBind", "binding", "item", "position", "", "dp", "value", "", "Companion", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_release"})
public final class AddPackageAdapter extends com.emojimaker.horor.emoji.core.base.BaseAdapter<com.emojimaker.horor.emoji.data.model.PackageModel, com.emojimaker.horor.emoji.databinding.ItemAddPackageBinding> {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ADD_ID = "add_package_item";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedPackageId = "";
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onAddClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.emojimaker.horor.emoji.data.model.PackageModel, kotlin.Unit> onPackageClick;
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.ui.my_creation.adapter.AddPackageAdapter.Companion Companion = null;
    
    public AddPackageAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedPackageId() {
        return null;
    }
    
    public final void setSelectedPackageId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnAddClick() {
        return null;
    }
    
    public final void setOnAddClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.emojimaker.horor.emoji.data.model.PackageModel, kotlin.Unit> getOnPackageClick() {
        return null;
    }
    
    public final void setOnPackageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.emojimaker.horor.emoji.data.model.PackageModel, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.PackageModel oldItem, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.PackageModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.PackageModel oldItem, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.PackageModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.databinding.ItemAddPackageBinding binding, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.PackageModel item, int position) {
    }
    
    private final int dp(float value) {
        return 0;
    }
    
    private final int dp(int value) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/my_creation/adapter/AddPackageAdapter$Companion;", "", "<init>", "()V", "ADD_ID", "", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}