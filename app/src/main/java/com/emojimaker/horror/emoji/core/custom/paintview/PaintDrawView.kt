package com.emojimaker.horor.emoji.core.custom.paintview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.Stack
import kotlin.math.abs

class PaintDrawView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var currentPath = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
    }
    private var currentColor = Color.BLACK
    private var currentStrokeWidth = 20f
    private var currentStrokeWidthEraser = 20f
    private var isEraser = false
    private var bitmap: Bitmap? = null
    private var bitmapCanvas: Canvas? = null
    private var currentX = 0f
    private var currentY = 0f
    private val pathList = Stack<DrawModel>()
    private val redoList = Stack<DrawModel>()
    var onHistoryChanged: (() -> Unit)? = null

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (w > 0 && h > 0) {
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            bitmapCanvas = Canvas(bitmap!!)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val targetBitmap = bitmap ?: return
        val targetCanvas = bitmapCanvas ?: return

        targetBitmap.eraseColor(Color.TRANSPARENT)
        for (item in pathList) {
            if (item.isEraser) {
                paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            } else {
                paint.xfermode = null
                paint.color = item.color
            }
            paint.strokeWidth = item.strokeWidth
            targetCanvas.drawPath(item.path, paint)
        }
        paint.xfermode = null
        canvas.drawBitmap(targetBitmap, 0f, 0f, null)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val targetX = event.x
        val targetY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentPath = Path().apply {
                    reset()
                    moveTo(targetX, targetY)
                }
                val strokeWidth = if (isEraser) currentStrokeWidthEraser else currentStrokeWidth
                pathList.push(DrawModel(currentPath, currentColor, strokeWidth, isEraser))
                redoList.clear()
                onHistoryChanged?.invoke()
                currentX = targetX
                currentY = targetY
            }

            MotionEvent.ACTION_MOVE -> {
                if (abs(targetX - currentX) >= LIMIT_DISTANCE || abs(targetY - currentY) >= LIMIT_DISTANCE) {
                    currentPath.quadTo(currentX, currentY, (targetX + currentX) / 2f, (targetY + currentY) / 2f)
                    currentX = targetX
                    currentY = targetY
                }
            }

            MotionEvent.ACTION_UP -> {
                currentPath.lineTo(currentX, currentY)
                onHistoryChanged?.invoke()
            }
            else -> return false
        }

        invalidate()
        return true
    }

    fun eraser(state: Boolean) {
        isEraser = state
    }

    fun setStrokeWidthEraser(width: Int) {
        currentStrokeWidthEraser = width.toFloat()
    }

    fun setColor(color: Int) {
        currentColor = color
    }

    fun setStrokeWidth(width: Int) {
        currentStrokeWidth = width.toFloat()
    }

    fun save(): Bitmap? {
        val source = bitmap ?: return null
        if (pathList.isEmpty()) return null
        return source.copy(Bitmap.Config.ARGB_8888, false)
    }

    fun canUndo(): Boolean = pathList.isNotEmpty()

    fun canRedo(): Boolean = redoList.isNotEmpty()

    fun undo(): Boolean {
        if (!canUndo()) return false
        redoList.push(pathList.pop())
        invalidate()
        onHistoryChanged?.invoke()
        return true
    }

    fun redo(): Boolean {
        if (!canRedo()) return false
        pathList.push(redoList.pop())
        invalidate()
        onHistoryChanged?.invoke()
        return true
    }

    fun clearAll() {
        pathList.clear()
        redoList.clear()
        bitmap?.eraseColor(Color.TRANSPARENT)
        invalidate()
        onHistoryChanged?.invoke()
    }

    companion object {
        private const val LIMIT_DISTANCE = 5
    }
}
