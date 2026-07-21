package com.emojimaker.horor.emoji.core.custom.seekbar

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.RectF
import android.graphics.drawable.Drawable
import kotlin.math.max
import kotlin.math.min

class TaperedSeekBarDrawable(
    private val density: Float
) : Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val arcRect = RectF()
    private val minHeight = 4f * density
    private val maxHeight = 14f * density

    override fun draw(canvas: Canvas) {
        drawTaper(canvas, Color.parseColor("#4DFFFFFF"), 1f)
        drawTaper(canvas, Color.WHITE, level / 10000f)
    }

    private fun drawTaper(canvas: Canvas, color: Int, progress: Float) {
        val fraction = progress.coerceIn(0f, 1f)
        if (fraction <= 0f || bounds.width() <= 0 || bounds.height() <= 0) return

        val centerY = bounds.exactCenterY()
        val startRadius = minHeight / 2f
        val currentHeight = minHeight + (maxHeight - minHeight) * fraction
        val endRadius = currentHeight / 2f
        val startCenterX = bounds.left + startRadius
        val endCenterX = max(startCenterX, bounds.left + bounds.width() * fraction - endRadius)

        paint.color = color
        path.reset()

        if (endCenterX <= startCenterX + 1f) {
            canvas.drawCircle(startCenterX, centerY, startRadius, paint)
            return
        }

        path.moveTo(startCenterX, centerY - startRadius)
        path.lineTo(endCenterX, centerY - endRadius)
        arcRect.set(endCenterX - endRadius, centerY - endRadius, endCenterX + endRadius, centerY + endRadius)
        path.arcTo(arcRect, -90f, 180f)
        path.lineTo(startCenterX, centerY + startRadius)
        arcRect.set(startCenterX - startRadius, centerY - startRadius, startCenterX + startRadius, centerY + startRadius)
        path.arcTo(arcRect, 90f, 180f)
        path.close()

        canvas.drawPath(path, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    override fun getIntrinsicHeight(): Int = maxHeight.toInt()
}
