package com.emojimaker.horor.emoji.ui.customize

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.custom.seekbar.TaperedSeekBarDrawable
import com.emojimaker.horor.emoji.core.extensions.checkDataInternet
import com.emojimaker.horor.emoji.core.extensions.invisible
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.hideNavigation
import com.emojimaker.horor.emoji.core.extensions.setImageActionBar
import com.emojimaker.horor.emoji.core.extensions.setFont
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.showInterAll
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.core.helper.BitmapHelper
import com.emojimaker.horor.emoji.core.helper.LanguageHelper
import com.emojimaker.horor.emoji.core.helper.MediaHelper
import com.emojimaker.horor.emoji.core.service.RetrofitClient
import com.emojimaker.horor.emoji.core.utils.DataLocal
import com.emojimaker.horor.emoji.core.utils.key.DomainKey
import com.emojimaker.horor.emoji.core.utils.key.IntentKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.state.SaveState
import com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel
import com.emojimaker.horor.emoji.data.model.custom.NavigationModel
import com.emojimaker.horor.emoji.data.model.draw.Draw
import com.emojimaker.horor.emoji.data.model.draw.DrawableDraw
import com.emojimaker.horor.emoji.data.model.emoji.EmojiCategoryModel
import com.emojimaker.horor.emoji.databinding.ActivityCustomizeEmojiBinding
import com.emojimaker.horor.emoji.dialog.ChooseColorDialog
import com.emojimaker.horor.emoji.dialog.YesNoDialog
import com.emojimaker.horor.emoji.listener.listenerdraw.OnDrawListener
import com.emojimaker.horor.emoji.ui.success.SuccessActivity
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class CustomizeEmojiActivity : BaseActivity<ActivityCustomizeEmojiBinding>() {

    companion object {
        const val MODE_NORMAL = "emoji_normal"
        const val MODE_HORROR = "emoji_horror"
        private const val ASSET_SUB_DOMAIN = "/public/app/ST295_HorrorEmojiMaker/emoji"
    }

    protected open val defaultMode: String = MODE_NORMAL

    private val mode: String by lazy {
        intent.getStringExtra(IntentKey.INTENT_KEY).takeUnless { it.isNullOrBlank() } ?: defaultMode
    }
    private val layerAdapter by lazy { LayerCustomizeAdapter(this) }
    private val navigationAdapter by lazy { BottomNavigationCustomizeAdapter(this) }
    private val drawColorAdapter by lazy { DrawColorAdapter() }
    private val textColorAdapter by lazy { TextColorEmojiAdapter() }
    private val textFontAdapter by lazy { TextFontEmojiAdapter() }
    private val emojiLayerAdapter by lazy {
        EmojiLayerAdapter(binding.drawView) { draw, _ ->
            if (!draw.isHide) binding.drawView.selectCurrentDraw(draw)
        }
    }

    private var categories: List<EmojiCategoryModel> = emptyList()
    private var selectedCategoryIndex = 0
    private var currentState = EditorState.STATE_1
    private val textColorList by lazy {
        DataLocal.getTextColorDefault(this).apply {
            forEachIndexed { index, item -> item.isSelected = index == 1 }
        }
    }
    private val textFontList by lazy {
        DataLocal.getTextFontDefault().apply {
            forEachIndexed { index, item -> item.isSelected = index == 0 }
        }
    }
    private var selectedTextColor = Color.WHITE
    private var selectedTextFont = R.font.roboto_regular
    private var isTextColorToolSelected = true
    private lateinit var layerTouchHelper: ItemTouchHelper
    private var isLayerDragging = false
    private var pendingLayerSync = false
    private var textColorToolCard: MaterialCardView? = null
    private var textFontToolCard: MaterialCardView? = null

    override fun setViewBinding(): ActivityCustomizeEmojiBinding {
        return ActivityCustomizeEmojiBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        binding.seekbarSize.progressDrawable =
            TaperedSeekBarDrawable(resources.displayMetrics.density)
        initDrawView()
        initRecyclerViews()
        setupKeyboardAwareTextPanels()
        showItemsState()
        lifecycleScope.launch {
            showLoading()
            loadEmojiData()
        }
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            btnActionBarRight.visible()
            btnActionBarRight.setImageResource(R.drawable.ic_save_bg)
            btnActionBarCenterRight.visible()
            btnActionBarCenterLeft.visible()
            setImageActionBar(btnActionBarLeft, R.drawable.ic_back)
            btnActionBarCenterLeft.setImageResource(R.drawable.ic_undo_disable)
            btnActionBarCenterRight.setImageResource(R.drawable.ic_redo_disable)
            setCenterActionButtonSpacing()
            setupTextToolSelectionCards()
            tvRightText.text = getString(R.string.done)
            tvRightText.select()
            tvRightText.setTextColor(
                ContextCompat.getColor(
                    this@CustomizeEmojiActivity,
                    R.color.app
                )
            )
            btnActionBarRightText.setBackgroundResource(R.drawable.bg_done_customize_emoji)
            btnActionBarRightText.layoutParams =
                (btnActionBarRightText.layoutParams as ConstraintLayout.LayoutParams).apply {
                    width = (80 * resources.displayMetrics.density).toInt()
                    height = (36 * resources.displayMetrics.density).toInt()
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.UNSET
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomMargin = (10 * resources.displayMetrics.density).toInt()
                    marginEnd = (16 * resources.displayMetrics.density).toInt()
                }
        }
        updateUndoRedoButtons()
    }

    private fun setCenterActionButtonSpacing() {
        val gap = (16 * resources.displayMetrics.density).toInt()
        binding.actionBar.btnActionBarCenterLeft.layoutParams =
            (binding.actionBar.btnActionBarCenterLeft.layoutParams as ConstraintLayout.LayoutParams).apply {
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                startToEnd = ConstraintLayout.LayoutParams.UNSET
                endToStart = binding.actionBar.btnActionBarCenterRight.id
                endToEnd = ConstraintLayout.LayoutParams.UNSET
                marginEnd = gap
                horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED
                horizontalBias = 0.5f
            }
        binding.actionBar.btnActionBarCenterRight.layoutParams =
            (binding.actionBar.btnActionBarCenterRight.layoutParams as ConstraintLayout.LayoutParams).apply {
                startToEnd = binding.actionBar.btnActionBarCenterLeft.id
                startToStart = ConstraintLayout.LayoutParams.UNSET
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                endToStart = ConstraintLayout.LayoutParams.UNSET
                marginStart = 0
                horizontalBias = 0.5f
            }
    }

    private fun setupTextToolSelectionCards() {
        textColorToolCard = createTextToolSelectionCard(
            binding.actionBar.btnActionBarCenterLeft,
            R.drawable.ic_choose_color_text_emoji
        ) {
            selectTextTool(isColor = true)
        }
        textFontToolCard = createTextToolSelectionCard(
            binding.actionBar.btnActionBarCenterRight,
            R.drawable.ic_choose_text_font_emoji
        ) {
            selectTextTool(isColor = false)
        }
    }

    private fun createTextToolSelectionCard(
        target: View,
        iconRes: Int,
        onClick: () -> Unit
    ): MaterialCardView {
        val size = (36 * resources.displayMetrics.density).toInt()
        val card = MaterialCardView(this).apply {
            id = View.generateViewId()
            visibility = View.GONE
            isClickable = true
            isFocusable = true
            radius = size / 2f
            cardElevation = 0f
            preventCornerOverlap = false
            useCompatPadding = false
            setCardBackgroundColor(Color.WHITE)
            strokeWidth = 0
            strokeColor = ContextCompat.getColor(this@CustomizeEmojiActivity, R.color.app)
            setOnClickListener { onClick.invoke() }
            addView(
                ImageView(this@CustomizeEmojiActivity).apply {
                    setImageResource(iconRes)
                    scaleType = ImageView.ScaleType.CENTER_INSIDE
                },
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        val parent = binding.actionBar.root as ConstraintLayout
        val targetIndex = (parent.indexOfChild(target) + 1).coerceAtLeast(0)
        parent.addView(
            card,
            targetIndex,
            ConstraintLayout.LayoutParams(size, size).apply {
                startToStart = target.id
                endToEnd = target.id
                topToTop = target.id
                bottomToBottom = target.id
            }
        )
        return card
    }

    override fun viewListener() {
        binding.main.tap {
            binding.drawView.hideSelect()
        }
        binding.actionBar.btnActionBarLeft.setOnClickListener {
            handleBackAction()
        }
        binding.actionBar.btnActionBarCenterLeft.tap {
            checkDataInternet(this@CustomizeEmojiActivity) {
                when (currentState) {
                    EditorState.STATE_3 -> selectTextTool(isColor = true)
                    EditorState.STATE_2 -> {
                        if (binding.paintDrawView.undo()) updateUndoRedoButtons()
                    }
                    else -> {
                    if (binding.drawView.undo()) {
                        updateUndoRedoButtons()
                        refreshLayerListIfNeeded()
                    }
                    }
                }
            }
        }
        binding.actionBar.btnActionBarCenterRight.tap {
            checkDataInternet(this@CustomizeEmojiActivity) {
                when (currentState) {
                    EditorState.STATE_3 -> selectTextTool(isColor = false)
                    EditorState.STATE_2 -> {
                        if (binding.paintDrawView.redo()) updateUndoRedoButtons()
                    }
                    else -> {
                    if (binding.drawView.redo()) {
                        updateUndoRedoButtons()
                        refreshLayerListIfNeeded()
                    }
                    }
                }
            }
        }
        binding.actionBar.btnActionBarRightText.tap {
            when (currentState) {
                EditorState.STATE_2 -> saveDrawMode()
                EditorState.STATE_3 -> saveTextMode()
                else -> Unit
            }
        }
        binding.actionBar.btnActionBarRight.tap {
            saveEmojiProject() }

        binding.btnDrawLayer.tap { showDrawState() }
        binding.btnTextLayer.tap { showTextState() }
        binding.btnLayer.tap {
            if (currentState == EditorState.STATE_4) {
                showItemsState()
            } else if (binding.drawView.getDraws().isEmpty()) {
                showToast(R.string.no_item_here)
            } else {
                showLayerState()
            }
        }
        binding.tabDraw.tap { setPaintMode() }
        binding.tabEraser.tap { setEraserMode() }
        binding.seekbarSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val strokeWidth = (progress.coerceAtLeast(1) * 2).coerceAtLeast(10)
                binding.paintDrawView.setStrokeWidth(strokeWidth)
                binding.paintDrawView.setStrokeWidthEraser(strokeWidth)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        binding.paintDrawView.onHistoryChanged = {
            if (currentState == EditorState.STATE_2) updateUndoRedoButtons()
        }
        layerAdapter.onItemClick = { item, position ->
            checkDataInternet(this@CustomizeEmojiActivity) {
                addEmojiToDrawView(item.path)
            }
        }
        navigationAdapter.onItemClick = { position ->
            checkDataInternet(this@CustomizeEmojiActivity) {
                if (position in categories.indices) {
                    selectedCategoryIndex = position
                    submitNavigation()
                    submitItems(categories[position])
                }
            }
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        handleBackAction()
    }
    private fun confirmExit() {
        val dialog =
            YesNoDialog(this, R.string.exit, R.string.do_you_want_to_exit)
        LanguageHelper.setLocale(this)
        dialog.show()
        dialog.onYesClick = {
            dialog.dismiss()
            showInterAll { finish() }
        }
        dialog.onNoClick = {
            dialog.dismiss()
            hideNavigation()
        }
    }

    private fun handleBackAction() {
        when (currentState) {
            EditorState.STATE_1 -> confirmExit()
            EditorState.STATE_2 -> {
                binding.paintDrawView.clearAll()
                showItemsState()
            }
            EditorState.STATE_3,
            EditorState.STATE_4 -> showItemsState()
        }
    }

    private fun updateLeftActionIcon() {
        setImageActionBar(
            binding.actionBar.btnActionBarLeft,
            if (currentState == EditorState.STATE_1) R.drawable.ic_back else R.drawable.ic_close_1
        )
    }

    private fun initDrawView() {
        binding.drawView.apply {
            setConstrained(true)
            setLocked(false)
            setOnDrawListener(object : OnDrawListener {
                override fun onAddedDraw(draw: Draw) {}
                override fun onClickedDraw(draw: Draw) {}
                override fun onDeletedDraw(draw: Draw) {
                    updateUndoRedoButtons()
                    refreshLayerListIfNeeded()
                }

                override fun onDragFinishedDraw(draw: Draw) {
                    updateUndoRedoButtons()
                }

                override fun onTouchedDownDraw(draw: Draw) {}
                override fun onZoomFinishedDraw(draw: Draw) {
                    updateUndoRedoButtons()
                }

                override fun onFlippedDraw(draw: Draw) {
                    updateUndoRedoButtons()
                }

                override fun onDoubleTappedDraw(draw: Draw) {}
                override fun onHideOptionIconDraw() {}
                override fun onUndoDeleteDraw(draw: List<Draw?>) {
                    updateUndoRedoButtons()
                    refreshLayerListIfNeeded()
                }

                override fun onUndoUpdateDraw(draw: List<Draw?>) {
                    updateUndoRedoButtons()
                    refreshLayerListIfNeeded()
                }

                override fun onUndoDeleteAll() {
                    updateUndoRedoButtons()
                    refreshLayerListIfNeeded()
                }

                override fun onRedoAll() {
                    updateUndoRedoButtons()
                    refreshLayerListIfNeeded()
                }

                override fun onReplaceDraw(draw: Draw) {}
                override fun onEditText(draw: DrawableDraw) {}
                override fun onReplace(draw: Draw) {}
            })
        }
    }

    private fun initRecyclerViews() {
        binding.rcvLayer.apply {
            adapter = layerAdapter
            itemAnimator = null
        }
        binding.rcvNavigation.apply {
            adapter = navigationAdapter
            itemAnimator = null
        }
        binding.rcvLayerColor.apply {
            adapter = drawColorAdapter
            itemAnimator = null
        }
        binding.rcvTextColor.apply {
            adapter = textColorAdapter
            itemAnimator = null
        }
        binding.rcvTextFont.apply {
            adapter = textFontAdapter
            itemAnimator = null
        }
        binding.rcvLayerLayer.apply {
            adapter = emojiLayerAdapter
            itemAnimator = null
        }
        drawColorAdapter.onAddColorClick = { showChooseDrawColorDialog() }
        drawColorAdapter.onColorClick = { color ->
            binding.paintDrawView.setColor(color)
        }
        textColorAdapter.onTextColorClick = { color, position ->
            selectedTextColor = color
            binding.edtEmojiText.setTextColor(color)
            textColorAdapter.submitItem(position, textColorList)
        }
        textFontAdapter.onTextFontClick = { font, position ->
            selectedTextFont = font
            binding.edtEmojiText.setFont(font)
            textFontAdapter.submitItem(position, textFontList)
        }
        emojiLayerAdapter.onItemCountChanged = { count ->
            updateLayerEmptyState(count)
        }
        setupLayerDragAndSwipe()
    }

    private fun showItemsState() {
        currentState = EditorState.STATE_1
        disableTextKeyboardResize()
        binding.apply {
            drawView.setLocked(false)
            layoutCustomLayer.setBackgroundColor(Color.TRANSPARENT)
            stateBlackCover.invisible()
            paintDrawView.setBackgroundColor(Color.TRANSPARENT)
            paintDrawView.invisible()
            edtEmojiText.invisible()
            rcvTextColor.invisible()
            rcvTextFont.invisible()
            rcvLayer.visible()
            flBottomNav.visible()
            btnLayer.visible()
            btnTextLayer.visible()
            btnDrawLayer.visible()
            flNavDrawAndEraser.invisible()
            containerSeekbar.invisible()
            rcvLayerColor.invisible()
            rcvLayerLayer.invisible()
            tvNoLayerItem.invisible()
            actionBar.btnActionBarRight.visible()
            actionBar.btnActionBarRightText.invisible()
            resetActionBarCenterButtonsForUndoRedo()
        }
        updateLeftActionIcon()
        updateTextPanelBottomMargin(0)
        hideKeyboard()
    }

    private fun showDrawState() {
        currentState = EditorState.STATE_2
        disableTextKeyboardResize()
        binding.apply {
            drawView.setLocked(true)
            layoutCustomLayer.setBackgroundColor(Color.TRANSPARENT)
            stateBlackCover.visible()
            paintDrawView.setBackgroundColor(Color.TRANSPARENT)
            paintDrawView.visible()
            rcvLayer.invisible()
            flBottomNav.invisible()
            btnLayer.invisible()
            btnTextLayer.invisible()
            btnDrawLayer.invisible()
            flNavDrawAndEraser.visible()
            containerSeekbar.visible()
            rcvLayerColor.visible()
            rcvLayerLayer.invisible()
            tvNoLayerItem.invisible()
            actionBar.btnActionBarRight.invisible()
            actionBar.btnActionBarRightText.visible()
            rcvTextColor.invisible()
            rcvTextFont.invisible()
            edtEmojiText.invisible()
            seekbarSize.progress = 10
            paintDrawView.setColor(drawColorAdapter.selectedColor())
            paintDrawView.setStrokeWidth(20)
            paintDrawView.setStrokeWidthEraser(20)
            resetActionBarCenterButtonsForUndoRedo()
        }
        updateLeftActionIcon()
        updateTextPanelBottomMargin(0)
        hideKeyboard()
        setPaintMode()
    }

    private fun showTextState() {
        currentState = EditorState.STATE_3
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        enableTextKeyboardResize()
        binding.apply {
            drawView.setLocked(true)
            layoutCustomLayer.setBackgroundColor(Color.TRANSPARENT)
            stateBlackCover.visible()
            paintDrawView.setBackgroundColor(Color.TRANSPARENT)
            paintDrawView.invisible()
            rcvLayer.invisible()
            flBottomNav.invisible()
            btnLayer.invisible()
            btnTextLayer.invisible()
            btnDrawLayer.invisible()
            flNavDrawAndEraser.invisible()
            containerSeekbar.invisible()
            rcvLayerColor.invisible()
            rcvLayerLayer.invisible()
            tvNoLayerItem.invisible()
            rcvTextColor.invisible()
            rcvTextFont.visible()
            actionBar.btnActionBarRight.invisible()
            actionBar.btnActionBarRightText.visible()
            edtEmojiText.visible()
            edtEmojiText.setText("")
            edtEmojiText.setTextColor(selectedTextColor)
            edtEmojiText.setFont(selectedTextFont)
            edtEmojiText.requestFocus()
            actionBar.btnActionBarCenterLeft.visible()
            actionBar.btnActionBarCenterRight.visible()
            actionBar.btnActionBarCenterLeft.setImageResource(R.drawable.ic_choose_color_text_emoji)
            actionBar.btnActionBarCenterRight.setImageResource(R.drawable.ic_choose_text_font_emoji)
            actionBar.btnActionBarCenterLeft.isEnabled = true
            actionBar.btnActionBarCenterRight.isEnabled = true
        }
        updateLeftActionIcon()
        textColorAdapter.submitItem(1, textColorList)
        textFontAdapter.submitItem(0, textFontList)
        selectTextTool(isColor = false)
        ViewCompat.requestApplyInsets(binding.root)
        showKeyboard()
    }

    private fun showLayerState() {
        currentState = EditorState.STATE_4
        disableTextKeyboardResize()
        binding.apply {
            drawView.setLocked(false)
            layoutCustomLayer.setBackgroundColor(Color.TRANSPARENT)
            stateBlackCover.invisible()
            paintDrawView.setBackgroundColor(Color.TRANSPARENT)
            paintDrawView.invisible()
            edtEmojiText.invisible()
            rcvLayer.invisible()
            flBottomNav.invisible()
            btnLayer.visible()
            btnTextLayer.invisible()
            btnDrawLayer.invisible()
            flNavDrawAndEraser.invisible()
            containerSeekbar.invisible()
            rcvLayerColor.invisible()
            rcvTextColor.invisible()
            rcvTextFont.invisible()
            rcvLayerLayer.visible()
            tvNoLayerItem.invisible()
            actionBar.btnActionBarRight.visible()
            actionBar.btnActionBarRightText.invisible()
            resetActionBarCenterButtonsForUndoRedo()
        }
        updateLeftActionIcon()
        updateTextPanelBottomMargin(0)
        hideKeyboard()
        refreshLayerList()
    }

    private fun setPaintMode() {
        binding.paintDrawView.eraser(false)
        binding.tabDraw.setBackgroundResource(R.drawable.ic_tab_emoji_slt)
        binding.tabDraw.setImageResource(R.drawable.ic_draw_tab_slt)
        binding.tabEraser.setBackgroundResource(R.drawable.ic_tab_emoji_uslt)
        binding.tabEraser.setImageResource(R.drawable.ic_tab_eraser_uslt)
        binding.rcvLayerColor.visible()
    }

    private fun setEraserMode() {
        binding.paintDrawView.eraser(true)
        binding.tabDraw.setBackgroundResource(R.drawable.ic_tab_emoji_uslt)
        binding.tabDraw.setImageResource(R.drawable.ic_draw_tab_uslt)
        binding.tabEraser.setBackgroundResource(R.drawable.ic_tab_emoji_slt)
        binding.tabEraser.setImageResource(R.drawable.ic_tab_eraser_slt)
        binding.rcvLayerColor.invisible()
    }

    private fun showChooseDrawColorDialog() {
        val dialog = ChooseColorDialog(this)
        dialog.show()

        fun dismissDialog() {
            dialog.dismiss()
            hideNavigation()
        }

        dialog.onCloseEvent = { dismissDialog() }
        dialog.onDoneEvent = { color ->
            dismissDialog()
            drawColorAdapter.addColor(color)
            binding.paintDrawView.setColor(color)
        }
    }

    private fun saveDrawMode() {
        val bitmap = binding.paintDrawView.save()
        if (bitmap == null || !hasVisiblePixel(bitmap)) {
            showToast(R.string.please_draw_something)
            return
        }

        val draw = DrawableDraw(
            BitmapDrawable(resources, bitmap),
            "freehand_${System.currentTimeMillis()}.png"
        )
        binding.drawView.addDraw(draw)
        binding.paintDrawView.clearAll()
        showItemsState()
        updateUndoRedoButtons()
    }

    private fun saveTextMode() {
        val text = binding.edtEmojiText.text.toString().trim()
        if (text.isEmpty()) {
            showToast(R.string.null_edt)
            return
        }
        binding.tvEmojiTextPreview.apply {
            setText(text)
            setTextColor(selectedTextColor)
            setFont(selectedTextFont)
            visibility = View.VISIBLE
        }
        binding.tvEmojiTextPreview.post {
            val bitmap = BitmapHelper.getBitmapFromEditText(binding.tvEmojiTextPreview)
            binding.tvEmojiTextPreview.visibility = View.INVISIBLE
            val draw = DrawableDraw(
                BitmapDrawable(resources, bitmap),
                "text_${System.currentTimeMillis()}.png"
            ).apply {
                isText = true
            }
            binding.drawView.addDraw(draw)
            binding.edtEmojiText.setText("")
            showItemsState()
            updateUndoRedoButtons()
        }
    }

    private fun saveEmojiProject() {
        if (currentState != EditorState.STATE_1 && currentState != EditorState.STATE_4) return
        if (binding.drawView.getDraws().isEmpty()) {
            showToast(R.string.no_item_here)
            return
        }
        lifecycleScope.launch {
            val bitmap = withContext(Dispatchers.Main) {
                binding.drawView.hideSelect()
                BitmapHelper.createBimapFromView(binding.layoutCustomLayer)
            }
            MediaHelper.saveBitmapToInternalStorageZip(
                this@CustomizeEmojiActivity,
                ValueKey.EMOJI_ALBUM,
                bitmap
            ).collect { state ->
                when (state) {
                    SaveState.Loading -> showLoading()
                    is SaveState.Error -> {
                        dismissLoading()
                        showToast(R.string.save_failed_please_try_again)
                    }

                    is SaveState.Success -> {
                        dismissLoading()
                        val intent =
                            Intent(this@CustomizeEmojiActivity, SuccessActivity::class.java).apply {
                                putExtra(IntentKey.INTENT_KEY, state.path)
                                putExtra(IntentKey.STATUS_KEY, ValueKey.EMOJI_TYPE)
                            }
                        showInterAll { startActivity(intent) }
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    }
                }
            }
        }
    }

    private fun hasVisiblePixel(bitmap: Bitmap): Boolean {
        for (y in 0 until bitmap.height step 20) {
            for (x in 0 until bitmap.width step 20) {
                val alpha = Color.alpha(bitmap.getPixel(x, y))
                if (alpha > 0) return true
            }
        }
        return false
    }

    private suspend fun loadEmojiData() {
        try {
            val response = withContext(Dispatchers.IO) {
                RetrofitClient.api.getEmojiData()
            }
            val body = response.body()
            if (response.isSuccessful && body != null) {
                applyEmojiCategories(if (mode == MODE_HORROR) body.emoji_horror else body.emoji_normal)
            } else {
                applyFallbackEmojiCategories()
            }
        } catch (e: Exception) {
            Log.e("CustomizeEmoji", "loadEmojiData failed: ${e.message}", e)
            applyFallbackEmojiCategories()
        } finally {
            dismissLoading()
            hideNavigation()
        }
    }

    private fun applyEmojiCategories(items: List<EmojiCategoryModel>) {
        categories = items.sortedBy { it.level }
        selectedCategoryIndex = 0
        submitNavigation()
        categories.firstOrNull()?.let { submitItems(it) }
    }

    private fun applyFallbackEmojiCategories() {
        val fallbackCategories = if (mode == MODE_HORROR) {
            fallbackHorrorEmojiCategories()
        } else {
            fallbackNormalEmojiCategories()
        }
        applyEmojiCategories(fallbackCategories)
    }

    private fun fallbackNormalEmojiCategories(): List<EmojiCategoryModel> {
        return listOf(
            EmojiCategoryModel("Beard", 45, 12),
            EmojiCategoryModel("Eyebrows", 47, 6),
            EmojiCategoryModel("Eyes", 161, 4),
            EmojiCategoryModel("Eyes_Big", 293, 5),
            EmojiCategoryModel("Glasses", 188, 11),
            EmojiCategoryModel("Hair", 140, 10),
            EmojiCategoryModel("Hands", 169, 10),
            EmojiCategoryModel("Happy_Mouth", 193, 8),
            EmojiCategoryModel("Hats", 291, 12),
            EmojiCategoryModel("Mask", 98, 99),
            EmojiCategoryModel("Misc", 118, 100),
            EmojiCategoryModel("More_Shape", 48, 2),
            EmojiCategoryModel("Nose", 24, 7),
            EmojiCategoryModel("Pattern_Shape", 7, 3),
            EmojiCategoryModel("Sad_Mouth", 203, 9),
            EmojiCategoryModel("Shape", 68, 1),
            EmojiCategoryModel("Stache", 42, 11)
        )
    }

    private fun fallbackHorrorEmojiCategories(): List<EmojiCategoryModel> {
        return listOf(
            EmojiCategoryModel("Eye Shadows", 88, 3),
            EmojiCategoryModel("Eyes", 50, 2),
            EmojiCategoryModel("Hairs", 40, 6),
            EmojiCategoryModel("Mask", 58, 1),
            EmojiCategoryModel("More", 20, 7),
            EmojiCategoryModel("Mouth", 55, 4),
            EmojiCategoryModel("Nose", 20, 5),
            EmojiCategoryModel("Scars", 40, 8),
            EmojiCategoryModel("Teeth", 48, 6),
            EmojiCategoryModel("Badge", 11, 99),
            EmojiCategoryModel("Candy", 50, 99),
            EmojiCategoryModel("Ghost", 50, 99),
            EmojiCategoryModel("Halloween", 50, 99),
            EmojiCategoryModel("Monster", 50, 99),
            EmojiCategoryModel("Pumpkin", 50, 99),
            EmojiCategoryModel("Scary", 50, 99),
            EmojiCategoryModel("Zombie", 52, 99)
        )
    }

    private fun submitNavigation() {
        val navigation = categories.mapIndexed { index, category ->
            NavigationModel(
                imageNavigation = emojiUrl(category.category, 1),
                isSelected = index == selectedCategoryIndex,
                layerIndex = index
            )
        }
        navigationAdapter.submitList(navigation)
    }

    private fun submitItems(category: EmojiCategoryModel) {
        val items = (1..category.quantity).map { index ->
            val path = emojiUrl(category.category, index)
            ItemNavCustomModel(
                path = path,
                positionCustom = 0,
                positionNavigation = selectedCategoryIndex,
                isSelected = false,
                thumb = path
            )
        }
        layerAdapter.submitList(items)
    }

    private fun addEmojiToDrawView(path: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val bitmap = Glide.with(this@CustomizeEmojiActivity)
                    .asBitmap()
                    .load(path)
                    .override(512, 512)
                    .submit()
                    .get()
                val draw = bitmap.toDrawable(resources).let { drawable ->
                    DrawableDraw(drawable, path)
                }
                withContext(Dispatchers.Main) {
                    binding.drawView.addDraw(draw)
                    updateUndoRedoButtons()
                }
            } catch (e: Exception) {
                Log.e("CustomizeEmoji", "addEmojiToDrawView failed: $path | ${e.message}", e)
                withContext(Dispatchers.Main) {
                    showToast(R.string.save_failed_please_try_again)
                }
            }
        }
    }

    private fun emojiUrl(category: String, index: Int): String {
        return "${DomainKey.BASE_URL}$ASSET_SUB_DOMAIN/$mode/${Uri.encode(category)}/$index.png"
    }

    private fun updateUndoRedoButtons() {
        val canUndo = if (currentState == EditorState.STATE_2) {
            binding.paintDrawView.canUndo()
        } else {
            binding.drawView.canUndo()
        }
        val canRedo = if (currentState == EditorState.STATE_2) {
            binding.paintDrawView.canRedo()
        } else {
            binding.drawView.canRedo()
        }
        binding.actionBar.btnActionBarCenterLeft.apply {
            isEnabled = canUndo
            setImageResource(if (isEnabled) R.drawable.ic_undo else R.drawable.ic_undo_disable)
        }
        binding.actionBar.btnActionBarCenterRight.apply {
            isEnabled = canRedo
            setImageResource(if (isEnabled) R.drawable.ic_redo else R.drawable.ic_redo_disable)
        }
    }

    private fun resetActionBarCenterButtonsForUndoRedo() {
        textColorToolCard?.visibility = View.GONE
        textFontToolCard?.visibility = View.GONE
        binding.actionBar.btnActionBarCenterLeft.visibility = View.VISIBLE
        binding.actionBar.btnActionBarCenterRight.visibility = View.VISIBLE
        updateUndoRedoButtons()
    }

    private fun selectTextTool(isColor: Boolean) {
        isTextColorToolSelected = isColor
        binding.rcvTextColor.visibility = if (isColor) View.VISIBLE else View.GONE
        binding.rcvTextFont.visibility = if (isColor) View.GONE else View.VISIBLE
        binding.actionBar.btnActionBarCenterLeft.visibility = View.INVISIBLE
        binding.actionBar.btnActionBarCenterRight.visibility = View.INVISIBLE
        textColorToolCard?.apply {
            visibility = View.VISIBLE
            strokeWidth = if (isColor) (3 * resources.displayMetrics.density).toInt() else 0
        }
        textFontToolCard?.apply {
            visibility = View.VISIBLE
            strokeWidth = if (!isColor) (3 * resources.displayMetrics.density).toInt() else 0
        }
    }

    private fun setupKeyboardAwareTextPanels() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val imeBottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            updateTextPanelBottomMargin(if (currentState == EditorState.STATE_3) imeBottom else 0)
            insets
        }
    }

    private fun updateTextPanelBottomMargin(bottomMargin: Int) {
        listOf(binding.rcvTextColor, binding.rcvTextFont).forEach { recyclerView ->
            val params = recyclerView.layoutParams as ConstraintLayout.LayoutParams
            if (params.bottomMargin != bottomMargin) {
                params.bottomMargin = bottomMargin
                recyclerView.layoutParams = params
            }
        }
    }

    private fun showKeyboard() {
        binding.edtEmojiText.post {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.edtEmojiText, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
        ViewCompat.requestApplyInsets(binding.root)
    }

    private fun enableTextKeyboardResize() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun disableTextKeyboardResize() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }

    private fun refreshLayerList() {
        emojiLayerAdapter.submitDraws(binding.drawView.getDraws())
    }

    private fun refreshLayerListIfNeeded() {
        if (currentState != EditorState.STATE_4) return
        if (isLayerDragging) {
            pendingLayerSync = true
            return
        }
        refreshLayerList()
    }

    private fun updateLayerEmptyState(itemCount: Int) {
        if (currentState != EditorState.STATE_4) return
        binding.rcvLayerLayer.visible()
        if (itemCount == 0) {
            binding.tvNoLayerItem.visible()
        } else {
            binding.tvNoLayerItem.invisible()
        }
    }

    private fun setupLayerDragAndSwipe() {
        emojiLayerAdapter.onStartDrag = { holder -> layerTouchHelper.startDrag(holder) }
        val deletePaint = Paint().apply { color = Color.parseColor("#FF3434") }
        val deleteIcon = ContextCompat.getDrawable(this, R.drawable.ic_delete_layer)
        val deleteIconSize = (24 * resources.displayMetrics.density).toInt()
        layerTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return emojiLayerAdapter.onItemMove(
                    viewHolder.bindingAdapterPosition,
                    target.bindingAdapterPosition
                )
            }

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    isLayerDragging = true
                    pendingLayerSync = false
                }
            }

            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                if (isLayerDragging) {
                    isLayerDragging = false
                    if (pendingLayerSync) {
                        pendingLayerSync = false
                        refreshLayerListIfNeeded()
                    }
                }
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    emojiLayerAdapter.onItemDismiss(position)
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemView = viewHolder.itemView
                if (dX < 0f) {
                    c.drawRect(
                        itemView.right + dX,
                        itemView.top.toFloat(),
                        itemView.right.toFloat(),
                        itemView.bottom.toFloat(),
                        deletePaint
                    )
                    deleteIcon?.let { icon ->
                        val revealWidth = -dX
                        val iconLeft =
                            itemView.right - ((revealWidth + deleteIconSize) / 2f).toInt()
                        val iconTop = itemView.top + (itemView.height - deleteIconSize) / 2
                        icon.setBounds(
                            iconLeft,
                            iconTop,
                            iconLeft + deleteIconSize,
                            iconTop + deleteIconSize
                        )
                        icon.draw(c)
                    }
                }
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
        })
        layerTouchHelper.attachToRecyclerView(binding.rcvLayerLayer)
    }

    private enum class EditorState {
        STATE_1,
        STATE_2,
        STATE_3,
        STATE_4
    }
}
