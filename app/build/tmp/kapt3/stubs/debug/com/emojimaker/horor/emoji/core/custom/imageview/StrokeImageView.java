package com.emojimaker.horor.emoji.core.custom.imageview;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/emojimaker/horor/emoji/core/custom/imageview/StrokeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "isFocusedStroke", "", "()Z", "setFocusedStroke", "(Z)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "ST295_Horror_Emoji_Maker_V1.0.1_07.28.2026_debug"})
public final class StrokeImageView extends androidx.appcompat.widget.AppCompatImageView {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
    private boolean isFocusedStroke = false;
    
    @kotlin.jvm.JvmOverloads()
    public StrokeImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public StrokeImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public final boolean isFocusedStroke() {
        return false;
    }
    
    public final void setFocusedStroke(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
}