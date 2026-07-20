package com.create.lalala.listener.listenerdraw;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001-B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010\'\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006."}, d2 = {"Lcom/create/lalala/listener/listenerdraw/BitmapDrawIcon;", "Lcom/create/lalala/data/model/draw/DrawableDraw;", "Lcom/create/lalala/listener/listenerdraw/DrawEvent;", "drawable", "Landroid/graphics/drawable/Drawable;", "gravity", "", "<init>", "(Landroid/graphics/drawable/Drawable;I)V", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "x", "getX", "setX", "y", "getY", "setY", "positionDefault", "getPositionDefault$annotations", "()V", "getPositionDefault", "()I", "setPositionDefault", "(I)V", "event", "getEvent", "()Lcom/create/lalala/listener/listenerdraw/DrawEvent;", "setEvent", "(Lcom/create/lalala/listener/listenerdraw/DrawEvent;)V", "onActionDown", "", "tattooView", "Lcom/create/lalala/core/custom/drawview/DrawView;", "Landroid/view/MotionEvent;", "onActionMove", "onActionUp", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "Gravity", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class BitmapDrawIcon extends com.create.lalala.data.model.draw.DrawableDraw implements com.create.lalala.listener.listenerdraw.DrawEvent {
    private float radius = 35.0F;
    private float x = 0.0F;
    private float y = 0.0F;
    private int positionDefault = 0;
    @org.jetbrains.annotations.Nullable()
    private com.create.lalala.listener.listenerdraw.DrawEvent event;
    
    public BitmapDrawIcon(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable drawable, @com.create.lalala.listener.listenerdraw.BitmapDrawIcon.Gravity()
    int gravity) {
        super(null, null);
    }
    
    public final float getRadius() {
        return 0.0F;
    }
    
    public final void setRadius(float p0) {
    }
    
    public final float getX() {
        return 0.0F;
    }
    
    public final void setX(float p0) {
    }
    
    public final float getY() {
        return 0.0F;
    }
    
    public final void setY(float p0) {
    }
    
    @com.create.lalala.listener.listenerdraw.BitmapDrawIcon.Gravity()
    public final int getPositionDefault() {
        return 0;
    }
    
    @com.create.lalala.listener.listenerdraw.BitmapDrawIcon.Gravity()
    @java.lang.Deprecated()
    public static void getPositionDefault$annotations() {
    }
    
    public final void setPositionDefault(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.create.lalala.listener.listenerdraw.DrawEvent getEvent() {
        return null;
    }
    
    public final void setEvent(@org.jetbrains.annotations.Nullable()
    com.create.lalala.listener.listenerdraw.DrawEvent p0) {
    }
    
    @java.lang.Override()
    public void onActionDown(@org.jetbrains.annotations.Nullable()
    com.create.lalala.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
    }
    
    @java.lang.Override()
    public void onActionMove(@org.jetbrains.annotations.Nullable()
    com.create.lalala.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
    }
    
    @java.lang.Override()
    public void onActionUp(@org.jetbrains.annotations.Nullable()
    com.create.lalala.core.custom.drawview.DrawView tattooView, @org.jetbrains.annotations.Nullable()
    android.view.MotionEvent event) {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas, @org.jetbrains.annotations.NotNull()
    android.graphics.Paint paint) {
    }
    
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/create/lalala/listener/listenerdraw/BitmapDrawIcon$Gravity;", "", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
    @androidx.annotation.IntDef(value = {0, 1, 2, 3})
    public static abstract @interface Gravity {
    }
}