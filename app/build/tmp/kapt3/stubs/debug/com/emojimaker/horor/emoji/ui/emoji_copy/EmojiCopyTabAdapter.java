package com.emojimaker.horor.emoji.ui.emoji_copy;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0014R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/emoji_copy/EmojiCopyTabAdapter;", "Lcom/emojimaker/horor/emoji/core/base/BaseAdapter;", "Lcom/emojimaker/horor/emoji/ui/emoji_copy/EmojiCopyCategory;", "Lcom/emojimaker/horor/emoji/databinding/ItemEmojiCopyTabBinding;", "<init>", "()V", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "value", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "onBind", "binding", "item", "position", "ST295_Horror_Emoji_Maker_V1.0.1_07.23.2026_debug"})
public final class EmojiCopyTabAdapter extends com.emojimaker.horor.emoji.core.base.BaseAdapter<com.emojimaker.horor.emoji.ui.emoji_copy.EmojiCopyCategory, com.emojimaker.horor.emoji.databinding.ItemEmojiCopyTabBinding> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClick;
    private int selectedPosition = 0;
    
    public EmojiCopyTabAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int value) {
    }
    
    @java.lang.Override()
    protected void onBind(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.databinding.ItemEmojiCopyTabBinding binding, @org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.ui.emoji_copy.EmojiCopyCategory item, int position) {
    }
}