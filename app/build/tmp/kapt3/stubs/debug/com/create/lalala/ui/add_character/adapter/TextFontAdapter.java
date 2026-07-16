package com.create.lalala.ui.add_character.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\fH\u0014J&\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001aJ \u0010\u001b\u001a\u00020\r2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001aH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/create/lalala/ui/add_character/adapter/TextFontAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/SelectedModel;", "Lcom/create/lalala/databinding/ItemFontBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onTextFontClick", "Lkotlin/Function2;", "", "", "getOnTextFontClick", "()Lkotlin/jvm/functions/Function2;", "setOnTextFontClick", "(Lkotlin/jvm/functions/Function2;)V", "currentSelected", "onBind", "binding", "item", "position", "submitItem", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "submitListReset", "ST295_Horror_Emoji_Maker_v1.0.0_07.15.2026_debug"})
public final class TextFontAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.SelectedModel, com.create.lalala.databinding.ItemFontBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onTextFontClick;
    private int currentSelected = 0;
    
    public TextFontAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnTextFontClick() {
        return null;
    }
    
    public final void setOnTextFontClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.create.lalala.databinding.ItemFontBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.SelectedModel item, int position) {
    }
    
    public final void submitItem(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.create.lalala.data.model.SelectedModel> list) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void submitListReset(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.create.lalala.data.model.SelectedModel> list) {
    }
}