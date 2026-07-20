package com.create.lalala.core.custom.drawview;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0014J\u0006\u0010(\u001a\u00020%R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/create/lalala/core/custom/drawview/PreviewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "baseBitmap", "Landroid/graphics/Bitmap;", "getBaseBitmap", "()Landroid/graphics/Bitmap;", "setBaseBitmap", "(Landroid/graphics/Bitmap;)V", "userBitmap", "getUserBitmap", "setUserBitmap", "clipRadius", "", "getClipRadius", "()F", "setClipRadius", "(F)V", "userOffsetX", "getUserOffsetX", "setUserOffsetX", "userOffsetY", "getUserOffsetY", "setUserOffsetY", "overlayBitmap", "getOverlayBitmap", "setOverlayBitmap", "paint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "resetOffset", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class PreviewView extends android.view.View {
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap baseBitmap;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap userBitmap;
    private float clipRadius = 0.0F;
    private float userOffsetX = 0.0F;
    private float userOffsetY = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap overlayBitmap;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Path clipPath = null;
    
    @kotlin.jvm.JvmOverloads()
    public PreviewView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PreviewView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getBaseBitmap() {
        return null;
    }
    
    public final void setBaseBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getUserBitmap() {
        return null;
    }
    
    public final void setUserBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    public final float getClipRadius() {
        return 0.0F;
    }
    
    public final void setClipRadius(float p0) {
    }
    
    public final float getUserOffsetX() {
        return 0.0F;
    }
    
    public final void setUserOffsetX(float p0) {
    }
    
    public final float getUserOffsetY() {
        return 0.0F;
    }
    
    public final void setUserOffsetY(float p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getOverlayBitmap() {
        return null;
    }
    
    public final void setOverlayBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void resetOffset() {
    }
}