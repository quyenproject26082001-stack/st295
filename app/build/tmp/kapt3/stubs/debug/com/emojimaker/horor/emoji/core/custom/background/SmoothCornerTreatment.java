package com.emojimaker.horor.emoji.core.custom.background;

/**
 * CornerTreatment mô phỏng Corner Smoothing giống Figma.
 *
 * @param smoothing hệ số bo mượt (0f - 1f).
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/emojimaker/horor/emoji/core/custom/background/SmoothCornerTreatment;", "Lcom/google/android/material/shape/CornerTreatment;", "smoothing", "", "<init>", "(F)V", "getCornerPath", "", "shapePath", "Lcom/google/android/material/shape/ShapePath;", "angle", "interpolation", "radius", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public final class SmoothCornerTreatment extends com.google.android.material.shape.CornerTreatment {
    private final float smoothing = 0.0F;
    
    public SmoothCornerTreatment(float smoothing) {
        super();
    }
    
    @java.lang.Override()
    public void getCornerPath(@org.jetbrains.annotations.NotNull()
    com.google.android.material.shape.ShapePath shapePath, float angle, float interpolation, float radius) {
    }
    
    public SmoothCornerTreatment() {
        super();
    }
}