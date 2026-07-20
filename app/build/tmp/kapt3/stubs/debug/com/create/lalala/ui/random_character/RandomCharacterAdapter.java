package com.create.lalala.ui.random_character;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J \u0010\u001a\u001a\u00020\f2\u0016\u0010\u001b\u001a\u00120\u001cR\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0016J\u0006\u0010\u001d\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/create/lalala/ui/random_character/RandomCharacterAdapter;", "Lcom/create/lalala/core/base/BaseAdapter;", "Lcom/create/lalala/data/model/custom/SuggestionModel;", "Lcom/create/lalala/databinding/ItemRandomCharacterBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onItemClick", "Lkotlin/Function1;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "activeJobs", "", "Landroid/view/View;", "Lkotlinx/coroutines/Job;", "onBind", "binding", "item", "position", "", "onViewRecycled", "holder", "Lcom/create/lalala/core/base/BaseAdapter$BaseViewHolder;", "cancelAllJobs", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_debug"})
public final class RandomCharacterAdapter extends com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.custom.SuggestionModel, com.create.lalala.databinding.ItemRandomCharacterBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.create.lalala.data.model.custom.SuggestionModel, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<android.view.View, kotlinx.coroutines.Job> activeJobs = null;
    
    public RandomCharacterAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.create.lalala.data.model.custom.SuggestionModel, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.create.lalala.data.model.custom.SuggestionModel, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.create.lalala.databinding.ItemRandomCharacterBinding binding, @org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.custom.SuggestionModel item, int position) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.base.BaseAdapter<com.create.lalala.data.model.custom.SuggestionModel, com.create.lalala.databinding.ItemRandomCharacterBinding>.BaseViewHolder holder) {
    }
    
    public final void cancelAllJobs() {
    }
}