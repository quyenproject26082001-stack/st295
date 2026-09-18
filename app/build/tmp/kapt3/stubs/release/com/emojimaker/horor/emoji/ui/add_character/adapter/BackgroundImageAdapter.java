package com.emojimaker.horor.emoji.ui.add_character.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0010H\u0014J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0002J&\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00102\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/add_character/adapter/BackgroundImageAdapter;", "Lcom/emojimaker/horor/emoji/core/base/BaseAdapter;", "Lcom/emojimaker/horor/emoji/data/model/SelectedModel;", "Lcom/emojimaker/horor/emoji/databinding/ItemBackgroundImageBinding;", "<init>", "()V", "onAddImageClick", "Lkotlin/Function0;", "", "getOnAddImageClick", "()Lkotlin/jvm/functions/Function0;", "setOnAddImageClick", "(Lkotlin/jvm/functions/Function0;)V", "onBackgroundImageClick", "Lkotlin/Function2;", "", "", "getOnBackgroundImageClick", "()Lkotlin/jvm/functions/Function2;", "setOnBackgroundImageClick", "(Lkotlin/jvm/functions/Function2;)V", "currentSelected", "getCurrentSelected", "()I", "setCurrentSelected", "(I)V", "submitList", "list", "", "onBind", "binding", "item", "position", "dp", "value", "submitItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_release"})
public final class BackgroundImageAdapter extends com.emojimaker.horor.emoji.core.base.BaseAdapter<com.emojimaker.horor.emoji.data.model.SelectedModel, com.emojimaker.horor.emoji.databinding.ItemBackgroundImageBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onAddImageClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onBackgroundImageClick;
    private int currentSelected = -1;
    
    public BackgroundImageAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnAddImageClick() {
        return null;
    }
    
    public final void setOnAddImageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> getOnBackgroundImageClick() {
        return null;
    }
    
    public final void setOnBackgroundImageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final int getCurrentSelected() {
        return 0;
    }
    
    public final void setCurrentSelected(int p0) {
    }
    
    @java.lang.Override()
    public void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.model.SelectedModel> list) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.databinding.ItemBackgroundImageBinding binding, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.SelectedModel item, int position) {
    }
    
    private final int dp(int value) {
        return 0;
    }
    
    public final void submitItem(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.emojimaker.horor.emoji.data.model.SelectedModel> list) {
    }
}