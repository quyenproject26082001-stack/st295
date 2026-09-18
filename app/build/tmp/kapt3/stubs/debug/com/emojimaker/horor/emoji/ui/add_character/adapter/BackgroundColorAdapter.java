package com.emojimaker.horor.emoji.ui.add_character.adapter;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000fH\u0014J&\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001fj\b\u0012\u0004\u0012\u00020\u0002` R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/add_character/adapter/BackgroundColorAdapter;", "Lcom/emojimaker/horor/emoji/core/base/BaseAdapter;", "Lcom/emojimaker/horor/emoji/data/model/SelectedModel;", "Lcom/emojimaker/horor/emoji/databinding/ItemBackgroundColorBinding;", "<init>", "()V", "onChooseColorClick", "Lkotlin/Function0;", "", "getOnChooseColorClick", "()Lkotlin/jvm/functions/Function0;", "setOnChooseColorClick", "(Lkotlin/jvm/functions/Function0;)V", "onBackgroundColorClick", "Lkotlin/Function2;", "", "getOnBackgroundColorClick", "()Lkotlin/jvm/functions/Function2;", "setOnBackgroundColorClick", "(Lkotlin/jvm/functions/Function2;)V", "currentSelected", "getCurrentSelected", "()I", "setCurrentSelected", "(I)V", "onBind", "binding", "item", "position", "submitItem", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
public final class BackgroundColorAdapter extends com.emojimaker.horor.emoji.core.base.BaseAdapter<com.emojimaker.horor.emoji.data.model.SelectedModel, com.emojimaker.horor.emoji.databinding.ItemBackgroundColorBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onChooseColorClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBackgroundColorClick;
    private int currentSelected = -1;
    
    public BackgroundColorAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnChooseColorClick() {
        return null;
    }
    
    public final void setOnChooseColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnBackgroundColorClick() {
        return null;
    }
    
    public final void setOnBackgroundColorClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final int getCurrentSelected() {
        return 0;
    }
    
    public final void setCurrentSelected(int p0) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.databinding.ItemBackgroundColorBinding binding, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.data.model.SelectedModel item, int position) {
    }
    
    public final void submitItem(int position, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.emojimaker.horor.emoji.data.model.SelectedModel> list) {
    }
}