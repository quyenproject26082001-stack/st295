package com.create.lalala.core.custom.imageview;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/create/lalala/core/custom/imageview/ShapeClipImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "maskBitmap", "Landroid/graphics/Bitmap;", "maskPaint", "value", "Landroid/graphics/drawable/Drawable;", "maskDrawable", "getMaskDrawable", "()Landroid/graphics/drawable/Drawable;", "setMaskDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onSizeChanged", "", "w", "h", "oldw", "oldh", "getMaskBitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class ShapeClipImageView extends androidx.appcompat.widget.AppCompatImageView {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Path clipPath = null;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap maskBitmap;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint maskPaint = null;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.drawable.Drawable maskDrawable;
    
    @kotlin.jvm.JvmOverloads()
    public ShapeClipImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ShapeClipImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ShapeClipImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getMaskDrawable() {
        return null;
    }
    
    public final void setMaskDrawable(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable value) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    private final android.graphics.Bitmap getMaskBitmap(int w, int h) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
}