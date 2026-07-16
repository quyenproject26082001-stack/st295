package com.create.lalala.ui.language;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR5\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/create/lalala/ui/language/LanguageAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/LanguageModel;", "Lcom/create/lalala/databinding/ItemLanguageBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "isFirstLanguage", "", "()Z", "setFirstLanguage", "(Z)V", "submitList", "list", "", "onBind", "binding", "item", "position", "", "ST295_Horror_Emoji_Maker_v1.0.0_07.15.2026_debug"})
public final class LanguageAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.LanguageModel, com.create.lalala.databinding.ItemLanguageBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onItemClick;
    private boolean isFirstLanguage = false;
    
    public LanguageAdapter(@org.jetbrains.annotations.NotNull()
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
    
    public final boolean isFirstLanguage() {
        return false;
    }
    
    public final void setFirstLanguage(boolean p0) {
    }
    
    @java.lang.Override()
    public void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.create.lalala.data.model.LanguageModel> list) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.create.lalala.databinding.ItemLanguageBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.LanguageModel item, int position) {
    }
}