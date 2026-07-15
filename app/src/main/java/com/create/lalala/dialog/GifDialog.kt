package com.create.lalala.dialog

import android.R.attr.gravity
import android.R.attr.maxHeight
import android.R.attr.maxWidth
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.view.Window
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.graphics.drawable.toDrawable
import com.create.lalala.R
import com.create.lalala.core.extensions.hideNavigation
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.databinding.DialogGifBinding
import com.bumptech.glide.Glide

class GifDialog(
    val context: Activity,
    private val rewardPaths: List<String>,
    private val hasPendingFreeSpin: Boolean = false
) : Dialog(context) {

    var onCloseClick: (() -> Unit) = {}
    var onCollectClick: ((List<String>) -> Unit) = {}
    var onAutoCollectClick: ((List<String>) -> Unit) = {}
    var onCooldownStart: ((Int) -> Unit) = {}
    var onFreeUsed: (() -> Unit) = {}
    private lateinit var binding : DialogGifBinding
    private val slotAnimators = linkedMapOf<Int, ValueAnimator>()
    private val slotColumns = arrayListOf<SlotColumn>()
    private val spinPool = arrayListOf<String>()
    private var activeRewards: List<String> = rewardPaths
    private var finishRunnable: Runnable? = null
    private val finishColumnRunnables = arrayListOf<Runnable>()
    private val settlingColumns = linkedSetOf<Int>()
    private var isSpinning = false
    private var hasSpun = false
    private var hasCollected = false
    private val countdownHandler = Handler(Looper.getMainLooper())
    private var countdownRunnable: Runnable? = null
    private var countdownSecondsLeft = COUNTDOWN_SECONDS
    private var isFreeCooldownRunning = false
    private var hasPreparedSlotLayout = false


    private data class SlotColumn(
        val container: FrameLayout,
        val strip: LinearLayout,
        val cells: List<FrameLayout>,
        val imageViews: List<ImageView>,
        val movesDown: Boolean,
        val items: MutableList<String>
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageHelper.setLocale(context)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogGifBinding.inflate(LayoutInflater.from(context))
        binding.root.alpha = 0f
        setContentView(binding.root)

        window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            applyImmersiveMode()
        }

        setCancelable(false)
        setCanceledOnTouchOutside(false)
        setRewardRowVisible(false)
        setShowTextVisible(false)
        binding.slotRow.removeAllViews()
        prepareSlotLayoutWhenMeasured()
        binding.tvCountDown.visibility = View.INVISIBLE
        setCollectEnabled(false)
        binding.btnCollect.visibility = View.INVISIBLE
        binding.btnFree.tap {
            if (isFreeCooldownRunning) return@tap
            if (hasSpun && !isSpinning) {
                showAdvertisementNotReadyDialog()
            } else {
                startSpin()
            }
        }
        binding.btnCollect.tap {
            if (hasCollected && !isSpinning) {
                dismiss()
            } else {
                collectRewardIfReady(
                    showCloseAfterCollect = false,
                    hideCollectAfterCollect = true,
                    startCooldown = false,
                    onCollected = onCollectClick
                )
            }
        }
        binding.btnClose.visibility = View.VISIBLE
        binding.btnClose.tap {
            if (hasCollected) dismiss() else onCloseClick.invoke()
        }
        if (hasPendingFreeSpin) {
            applyPendingFreeState()
        }

    }

    override fun show() {
        super.show()
        applyImmersiveMode()
        binding.root.post { applyImmersiveMode() }
    }

    private fun prepareSlotLayoutWhenMeasured() {
        binding.slotRow.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                if (binding.slotRow.width <= 0) return true

                binding.slotRow.viewTreeObserver.removeOnPreDrawListener(this)
                if (hasPreparedSlotLayout) return true

                hasPreparedSlotLayout = true
                setupSlotColumns()
                bindSlotImages()
                logSlotVisibleRows("onCreate")
                binding.root.animate()
                    .alpha(1f)
                    .setDuration(DIALOG_FADE_IN_MS)
                    .start()
                return true
            }
        })
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            applyImmersiveMode()
        }
    }

    private fun applyImmersiveMode() {
        context.hideNavigation()
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }

    private fun bindRewards() {
        val rewardViews = listOf(
            binding.imgReward1,
            binding.imgReward2,
            binding.imgReward3,
            binding.imgReward4,
            binding.imgReward5
        )
        val itemSizePx = getSlotItemSizePx()
        binding.rewardRow.layoutParams = binding.rewardRow.layoutParams.apply {
            height = itemSizePx
        }
        rewardViews.forEachIndexed { index, imageView ->
            imageView.layoutParams = imageView.layoutParams.apply {
                width = itemSizePx
                height = itemSizePx
            }
            loadReward(imageView, activeRewards.getOrNull(index))
        }
    }

    private fun bindSlotImages() {
        slotColumns.forEachIndexed { index, _ ->
            bindColumn(index)
        }
    }

    private fun startSpin() {
        if (isSpinning || rewardPaths.isEmpty()) return
        isSpinning = true
        hasSpun = false
        updateActiveRewards()
        setRewardRowVisible(false)
        setShowTextVisible(false)
        setMainHighlightVisible(false)
        binding.btnClose.visibility = View.VISIBLE
        binding.btnCollect.visibility = View.INVISIBLE
        binding.tvCountDown.visibility = View.INVISIBLE
        binding.btnSpin.alpha = 1f
        resetColumnItems()
        bindSlotImages()
        logSlotVisibleRows("startSpin")
        setCollectEnabled(false)
        binding.btnFree.isEnabled = false
        binding.btnFree.alpha = 0.6f

        clearFinishCallbacks()
        settlingColumns.clear()
        stopSlotAnimations(resetPosition = true)
        slotColumns.forEachIndexed { index, _ ->
            startColumnCycle(index, delayMs = index * 45L)
        }

        finishRunnable = Runnable { finishSpinColumnsOneByOne() }
        binding.root.postDelayed(finishRunnable, 2_500L)
    }

    private fun finishSpinColumnsOneByOne() {
        if (!isShowing) return
        finishColumnRunnables.clear()
        slotColumns.indices.forEachIndexed { order, columnIndex ->
            val runnable = Runnable {
                settleColumn(columnIndex)
                if (order == slotColumns.lastIndex) {
                    completeSpin()
                }
            }
            finishColumnRunnables.add(runnable)
            binding.root.postDelayed(runnable, order * COLUMN_STOP_DELAY_MS)
        }
    }

    private fun settleColumn(columnIndex: Int) {
        if (columnIndex !in slotColumns.indices) return
        settlingColumns.add(columnIndex)
        slotAnimators.remove(columnIndex)?.cancel()
        setupFinalColumnItem(columnIndex)
        bindColumn(columnIndex)
    }

    private fun completeSpin() {
        if (!isShowing) return
        isSpinning = false
        settlingColumns.clear()
        setMainHighlightVisible(true)
        bindRewards()
        setRewardRowVisible(true)
        binding.btnFree.setText(R.string.free)
        binding.imgAds.visibility = View.VISIBLE
        setShowTextVisible(true)
        hasSpun = true
        binding.btnFree.isEnabled = true
        binding.btnFree.alpha = 1f
        binding.btnCollect.visibility = View.VISIBLE
        setCollectEnabled(true)
        binding.btnClose.visibility = View.INVISIBLE
        logSlotVisibleRows("finishSpin")
        collectRewardIfReady(
            showCloseAfterCollect = false,
            hideCollectAfterCollect = false,
            startCooldown = false,
            onCollected = onAutoCollectClick
        )
    }

    private fun collectRewardIfReady(
        showCloseAfterCollect: Boolean,
        hideCollectAfterCollect: Boolean,
        startCooldown: Boolean,
        onCollected: (List<String>) -> Unit
    ) {
        if (!hasSpun || isSpinning || hasCollected) return

        hasCollected = true
        binding.btnCollect.visibility = if (hideCollectAfterCollect) View.INVISIBLE else View.VISIBLE
        setCollectEnabled(!hideCollectAfterCollect)
        binding.btnClose.visibility = if (showCloseAfterCollect) View.VISIBLE else View.INVISIBLE
        if (startCooldown) onCooldownStart.invoke(COUNTDOWN_SECONDS)
        onCollected.invoke(activeRewards)
    }

    private fun showAdvertisementNotReadyDialog() {
        val dialog = YesNoDialog(
            context,
            R.string.notification,
            R.string.advertisement_not_ready,
            true,
            true
        )
        dialog.onYesClick = {
            dialog.dismiss()
            startFreeCooldown()
        }
        dialog.show()
    }

    private fun startFreeCooldown() {
        countdownRunnable?.let { countdownHandler.removeCallbacks(it) }
        countdownSecondsLeft = COUNTDOWN_SECONDS
        isFreeCooldownRunning = true
        onFreeUsed.invoke()
        onCooldownStart.invoke(countdownSecondsLeft)
        hasSpun = false
        setRewardRowVisible(false)
        setShowTextVisible(false)
        binding.btnCollect.visibility = View.INVISIBLE
        setCollectEnabled(false)
        binding.btnClose.visibility = View.VISIBLE
        binding.btnFree.setText(R.string.spin)
        binding.btnFree.isEnabled = false
        binding.btnFree.alpha = 1f
        binding.imgAds.visibility = View.GONE
        binding.btnSpin.alpha = 0.8f
        binding.tvCountDown.visibility = View.VISIBLE
        updateCountdownText()
        countdownRunnable = object : Runnable {
            override fun run() {
                countdownSecondsLeft--
                updateCountdownText()
                if (countdownSecondsLeft > 0) {
                    countdownHandler.postDelayed(this, 1_000L)
                } else {
                    finishFreeCooldown()
                }
            }
        }
        countdownHandler.postDelayed(countdownRunnable!!, 1_000L)
    }

    private fun applyPendingFreeState() {
        hasSpun = true
        hasCollected = true
        isSpinning = false
        setRewardRowVisible(false)
        setShowTextVisible(false)
        binding.btnCollect.visibility = View.INVISIBLE
        setCollectEnabled(false)
        binding.btnClose.visibility = View.VISIBLE
        binding.btnFree.setText(R.string.free)
        binding.btnFree.isEnabled = true
        binding.btnFree.alpha = 1f
        binding.imgAds.visibility = View.VISIBLE
        binding.tvCountDown.visibility = View.INVISIBLE
    }

    private fun finishFreeCooldown() {
        isFreeCooldownRunning = false
        binding.btnSpin.alpha = 1f
        binding.tvCountDown.visibility = View.INVISIBLE
        binding.btnFree.isEnabled = true
        countdownRunnable = null
    }


    private fun updateCountdownText() {
        val hours = countdownSecondsLeft / 3600
        val minutes = (countdownSecondsLeft % 3600) / 60
        val seconds = countdownSecondsLeft % 60
        binding.tvCountDown.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    private fun stopSlotAnimations(resetPosition: Boolean) {
        val animators = slotAnimators.values.toList()
        slotAnimators.clear()
        animators.forEach { it.cancel() }
        if (resetPosition) {
            slotColumns.forEach { column ->
                column.strip.translationY = getSlotStartTranslation()
            }
        }
    }

    private fun setCollectEnabled(enabled: Boolean) {
        binding.btnCollect.isEnabled = enabled
        binding.btnCollect.alpha = if (enabled) 1f else 0.45f
    }

    private fun setRewardRowVisible(visible: Boolean) {
        binding.rewardRow.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    private fun setShowTextVisible(visible: Boolean) {
        binding.btnShowText.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    private fun setMainHighlightVisible(visible: Boolean) {
        slotColumns.forEach { column ->
            column.cells.forEachIndexed { index, cell ->
                val isCenterCell = index == 2
                cell.setBackgroundResource(
                    if (visible && isCenterCell) R.drawable.bg_gif_slot_main else R.drawable.bg_gif_slot_side
                )
            }
        }
    }

    private fun updateActiveRewards() {
        val uniqueRewards = rewardPaths.distinct()
        activeRewards = uniqueRewards.shuffled().take(SLOT_COLUMN_COUNT)
        if (activeRewards.isEmpty()) activeRewards = uniqueRewards
    }

    private fun setupSlotColumns() {
        binding.slotRow.removeAllViews()
        binding.slotRow.layoutParams = binding.slotRow.layoutParams.apply {
            height = (getSlotStepPx() * VISIBLE_SLOT_WINDOW_ROWS).toInt() +
                    binding.slotRow.paddingTop +
                    binding.slotRow.paddingBottom
        }
        slotColumns.clear()
        repeat(SLOT_COLUMN_COUNT) { index ->
            val movesDown = index % 2 == 0
            val column = createSlotColumn(movesDown)
            slotColumns.add(column)
            binding.slotRow.addView(
                column.container,
                LinearLayout.LayoutParams(0, (getSlotStepPx() * VISIBLE_SLOT_WINDOW_ROWS).toInt(), 1f).apply {
                    leftMargin = if (index == 0) 0 else dp(SLOT_COLUMN_GAP_DP / 2f)
                    rightMargin = if (index == SLOT_COLUMN_COUNT - 1) 0 else dp(SLOT_COLUMN_GAP_DP / 2f)
                }
            )
        }
        resetColumnItems()
    }

    private fun resetColumnItems() {
        spinPool.clear()
        spinPool.addAll(rewardPaths.distinct().shuffled().ifEmpty { activeRewards })
        slotColumns.forEachIndexed { columnIndex, column ->
            column.items.clear()
            repeat(TOTAL_SLOT_ROWS) { rowIndex ->
                column.items.add(getSpinPath(columnIndex + rowIndex))
            }
            column.strip.translationY = getSlotStartTranslation()
        }
    }

    private fun setupFinalColumnItems() {
        val rewards = activeRewards.ifEmpty { rewardPaths }
        slotColumns.forEachIndexed { columnIndex, column ->
            setupFinalColumnItem(columnIndex)
        }
    }

    private fun setupFinalColumnItem(columnIndex: Int) {
        val rewards = activeRewards.ifEmpty { rewardPaths }
        val column = slotColumns.getOrNull(columnIndex) ?: return
        if (rewards.isEmpty()) return
        val center = rewards[columnIndex % rewards.size]
        val top = rewards[(columnIndex + rewards.size - 1) % rewards.size]
        val bottom = rewards[(columnIndex + 1) % rewards.size]
        column.items.clear()
        column.items.add(getSpinPath(columnIndex + 4))
        column.items.add(top)
        column.items.add(center)
        column.items.add(bottom)
        column.items.add(getSpinPath(columnIndex + 3))
        column.strip.translationY = getSlotStartTranslation()
    }

    private fun startColumnCycle(columnIndex: Int, delayMs: Long = 0L) {
        if (!isSpinning || columnIndex !in slotColumns.indices) return
        val column = slotColumns[columnIndex]
        val step = getSlotStepPx()
        val start = getSlotStartTranslation()
        val end = if (column.movesDown) start + step else start - step
        val animator = ValueAnimator.ofFloat(start, end).apply {
            duration = 180L
            startDelay = delayMs
            interpolator = LinearInterpolator()
            addUpdateListener { animation ->
                column.strip.translationY = animation.animatedValue as Float
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    slotAnimators.remove(columnIndex)
                    if (!isSpinning || !isShowing || columnIndex in settlingColumns) return
                    rotateColumn(columnIndex)
                    bindColumn(columnIndex)
                    column.strip.translationY = start
                    startColumnCycle(columnIndex)
                }
            })
            start()
        }
        slotAnimators[columnIndex] = animator
    }

    private fun rotateColumn(columnIndex: Int) {
        val column = slotColumns.getOrNull(columnIndex) ?: return
        val items = column.items
        if (items.isEmpty()) return
        if (column.movesDown) {
            val last = items.removeAt(items.lastIndex)
            items.add(0, last)
            items[0] = getSpinPath(columnIndex + System.nanoTime().toInt())
        } else {
            val first = items.removeAt(0)
            items.add(first)
            items[items.lastIndex] = getSpinPath(columnIndex + System.nanoTime().toInt())
        }
    }

    private fun bindColumn(columnIndex: Int) {
        val column = slotColumns.getOrNull(columnIndex) ?: return
        column.imageViews.forEachIndexed { rowIndex, imageView ->
            loadReward(imageView, column.items.getOrNull(rowIndex))
        }
    }

    private fun getSpinPath(seed: Int): String {
        val pool = spinPool.ifEmpty { activeRewards.ifEmpty { rewardPaths } }
        if (pool.isEmpty()) return ""
        return pool[kotlin.math.abs(seed) % pool.size]
    }

    private fun getSlotStepPx(): Float {
        return (getSlotItemSizePx() + dp(SLOT_ROW_GAP_DP)).toFloat()
    }

    private fun getSlotItemSizePx(): Int {
        val fallbackSize = dp(SLOT_ITEM_SIZE_DP)
        val contentWidth = binding.slotRow.width - binding.slotRow.paddingLeft - binding.slotRow.paddingRight
        if (contentWidth <= 0) return fallbackSize

        val totalGap = dp(SLOT_COLUMN_GAP_DP) * (SLOT_COLUMN_COUNT - 1)
        return ((contentWidth - totalGap) / SLOT_COLUMN_COUNT).coerceAtMost(fallbackSize)
    }

    private fun getSlotStartTranslation(): Float {
        return -getSlotStepPx() * SLOT_START_OFFSET_ROWS
    }

    private fun logSlotVisibleRows(from: String) {
        val stepPx = getSlotStepPx()
        val contentHeight = binding.slotRow.height - binding.slotRow.paddingTop - binding.slotRow.paddingBottom
        val visibleByMath = if (stepPx > 0f) contentHeight / stepPx else 0f
        val firstColumn = slotColumns.firstOrNull()
        val visibleChildIndexes = firstColumn?.let { column ->
            (0 until column.strip.childCount).filter { index ->
                val child = column.strip.getChildAt(index)
                val top = child.top + column.strip.translationY
                val bottom = child.bottom + column.strip.translationY
                bottom > 0f && top < contentHeight
            }
        }.orEmpty()
        Log.d(
            "GifDialogRows",
            "$from slotRowHeight=${binding.slotRow.height} contentHeight=$contentHeight stepPx=$stepPx visibleRows=$visibleByMath " +
                    "stripTranslationY=${firstColumn?.strip?.translationY} visibleChildIndexes=$visibleChildIndexes " +
                    "stripChildCount=${firstColumn?.strip?.childCount} childBounds=${getFirstColumnChildBounds()}"
        )
    }

    private fun getFirstColumnChildBounds(): String {
        val firstColumn = slotColumns.firstOrNull() ?: return "[]"
        return (0 until firstColumn.strip.childCount).joinToString(
            prefix = "[",
            postfix = "]"
        ) { index ->
            val child = firstColumn.strip.getChildAt(index)
            val top = child.top + firstColumn.strip.translationY
            val bottom = child.bottom + firstColumn.strip.translationY
            "$index:${top.toInt()}-${bottom.toInt()}"
        }
    }

    private fun createSlotColumn(movesDown: Boolean): SlotColumn {
        val stepPx = getSlotStepPx().toInt()
        val itemSizePx = getSlotItemSizePx()
        val container = FrameLayout(context).apply {
            clipChildren = true
            clipToPadding = true
        }
        val strip = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            translationY = getSlotStartTranslation()
        }
        val cells = arrayListOf<FrameLayout>()
        val imageViews = (0 until TOTAL_SLOT_ROWS).map {
            val holder = FrameLayout(context).apply {
                strip.addView(
                    this,
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, stepPx)
                )
            }
            val cell = FrameLayout(context).apply {
                setBackgroundResource(R.drawable.bg_gif_slot_side)
                holder.addView(
                    this,
                    FrameLayout.LayoutParams(itemSizePx, itemSizePx, android.view.Gravity.CENTER)
                )
            }
            val imageView = ImageView(context).apply {
                scaleType = ImageView.ScaleType.FIT_CENTER
                setPadding(dp(5), dp(5), dp(5), dp(5))
                cell.addView(
                    this,
                    FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
                )
            }
            cells.add(cell)
            imageView
        }
        container.addView(
            strip,
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, stepPx * TOTAL_SLOT_ROWS)
        )
        return SlotColumn(container, strip, cells, imageViews, movesDown, mutableListOf())
    }

    private fun dp(value: Int): Int {
        return (value * context.resources.displayMetrics.density).toInt()
    }

    private fun dp(value: Float): Int {
        return (value * context.resources.displayMetrics.density).toInt()
    }

    private fun loadReward(imageView: ImageView, path: String?) {
        if (path.isNullOrEmpty()) {
            imageView.setImageDrawable(null)
            return
        }
        Glide.with(imageView)
            .load(path)
            .into(imageView)
    }

    override fun dismiss() {
        stopSlotAnimations(resetPosition = false)
        clearFinishCallbacks()
        countdownRunnable?.let { countdownHandler.removeCallbacks(it) }
        super.dismiss()
    }

    private fun clearFinishCallbacks() {
        finishRunnable?.let { binding.root.removeCallbacks(it) }
        finishRunnable = null
        finishColumnRunnables.forEach { binding.root.removeCallbacks(it) }
        finishColumnRunnables.clear()
    }

    companion object {
        // Visible viewport height measured in row steps. 2f means half top + full center + half bottom.
        private const val VISIBLE_SLOT_WINDOW_ROWS = 2f
        // Initial strip offset in row steps. 1.5f centers the full middle row in the clipped viewport.
        private const val SLOT_START_OFFSET_ROWS = 1.5f
        // Size of each slot item square.
        private const val SLOT_ITEM_SIZE_DP = 55
        // Vertical space between slot item rows. Increase/decrease this to tune row distance.
        private const val SLOT_ROW_GAP_DP = 6
        // Horizontal space between slot columns. Increase/decrease this to tune column distance.
        private const val SLOT_COLUMN_GAP_DP = 6
        // Number of visible spinning columns.
        private const val SLOT_COLUMN_COUNT = 5
        // Number of holder rows per spinning column. Keep extra rows above/below for smooth looping.
        private const val TOTAL_SLOT_ROWS = 5
        // Gift cooldown duration after collect/free flow.
        private const val COUNTDOWN_SECONDS = 1800
        // Delay between each column stopping, so columns finish one by one.
        private const val COLUMN_STOP_DELAY_MS = 220L
        private const val DIALOG_FADE_IN_MS = 140L
    }

}
