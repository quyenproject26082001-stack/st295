package com.create.lalala.core.custom.paintview;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u00011B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0017H\u0014J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\'H\u0017J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0007J\b\u0010/\u001a\u0004\u0018\u00010\u0015J\u0006\u00100\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/create/lalala/core/custom/paintview/PaintDrawView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentPath", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "currentColor", "currentStrokeWidth", "", "currentStrokeWidthEraser", "isEraser", "", "bitmap", "Landroid/graphics/Bitmap;", "bitmapCanvas", "Landroid/graphics/Canvas;", "currentX", "currentY", "pathList", "Ljava/util/Stack;", "Lcom/create/lalala/core/custom/paintview/DrawModel;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "eraser", "state", "setStrokeWidthEraser", "width", "setColor", "color", "setStrokeWidth", "save", "clearAll", "Companion", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class PaintDrawView extends android.view.View {
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Path currentPath;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
    private int currentColor = android.graphics.Color.BLACK;
    private float currentStrokeWidth = 20.0F;
    private float currentStrokeWidthEraser = 20.0F;
    private boolean isEraser = false;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap bitmap;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Canvas bitmapCanvas;
    private float currentX = 0.0F;
    private float currentY = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Stack<com.create.lalala.core.custom.paintview.DrawModel> pathList = null;
    private static final int LIMIT_DISTANCE = 5;
    @org.jetbrains.annotations.NotNull()
    public static final com.create.lalala.core.custom.paintview.PaintDrawView.Companion Companion = null;
    
    @kotlin.jvm.JvmOverloads()
    public PaintDrawView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PaintDrawView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PaintDrawView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    public final void eraser(boolean state) {
    }
    
    public final void setStrokeWidthEraser(int width) {
    }
    
    public final void setColor(int color) {
    }
    
    public final void setStrokeWidth(int width) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap save() {
        return null;
    }
    
    public final void clearAll() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/create/lalala/core/custom/paintview/PaintDrawView$Companion;", "", "<init>", "()V", "LIMIT_DISTANCE", "", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}