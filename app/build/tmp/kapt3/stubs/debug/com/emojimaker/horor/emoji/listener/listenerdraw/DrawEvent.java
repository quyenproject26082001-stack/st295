package com.emojimaker.horor.emoji.listener.listenerdraw;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\n\u00c0\u0006\u0003"}, d2 = {"Lcom/emojimaker/horor/emoji/listener/listenerdraw/DrawEvent;", "", "onActionDown", "", "tattooView", "Lcom/emojimaker/horor/emoji/core/custom/drawview/DrawView;", "event", "Landroid/view/MotionEvent;", "onActionMove", "onActionUp", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public abstract interface DrawEvent {
    
    public abstract void onActionDown(@org.jetbrains.annotations.Nullable()
    com.emojimaker.horor.emoji.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
    
    public abstract void onActionMove(@org.jetbrains.annotations.Nullable()
    com.emojimaker.horor.emoji.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
    
    public abstract void onActionUp(@org.jetbrains.annotations.Nullable()
    com.emojimaker.horor.emoji.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event);
}