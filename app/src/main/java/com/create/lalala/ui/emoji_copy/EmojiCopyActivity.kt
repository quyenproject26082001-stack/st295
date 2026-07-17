package com.create.lalala.ui.emoji_copy

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.handleBackLeftToRight
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.visible
import com.create.lalala.databinding.ActivityEmojiCopyBinding

class EmojiCopyActivity : BaseActivity<ActivityEmojiCopyBinding>() {

    private val tabAdapter by lazy { EmojiCopyTabAdapter() }
    private val itemAdapter by lazy { EmojiCopyItemAdapter() }
    private val emojiCategories = createEmojiCategories()

    override fun setViewBinding(): ActivityEmojiCopyBinding {
        return ActivityEmojiCopyBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        binding.rcvTabs.apply {
            layoutManager = LinearLayoutManager(this@EmojiCopyActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = tabAdapter
        }
        binding.rcvEmoji.apply {
            layoutManager = GridLayoutManager(this@EmojiCopyActivity, 5)
            adapter = itemAdapter
        }
        tabAdapter.submitList(emojiCategories)
        showCategory(0)
    }

    override fun viewListener() {
        tabAdapter.onItemClick = { position ->
            showCategory(position)
        }
        itemAdapter.onItemClick = { emoji ->
            copyEmojiToClipboard(emoji)
        }
        binding.actionBar.btnActionBarLeft.tap(800) {
            handleBackLeftToRight()
        }
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            tvCenter.visible()
            tvCenter.text = getString(R.string.emoji_copy)
            imgCenter.gone()
            btnActionBarRight.gone()
            btnActionBarNextRight.gone()
            btnActionBarNextRight1.gone()
            btnActionBarCenter.gone()
            btnActionBarCenterLeft.gone()
            btnActionBarCenterRight.gone()
        }
    }

    private fun showCategory(position: Int) {
        if (position !in emojiCategories.indices) return
        tabAdapter.selectedPosition = position
        itemAdapter.submitList(emojiCategories[position].items)
    }

    private fun copyEmojiToClipboard(emoji: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("emoji", emoji))
        showToast(R.string.copied_to_clipboard)
    }

    private fun createEmojiCategories(): List<EmojiCopyCategory> {
        return listOf(
            EmojiCopyCategory(
                "Emoji Fashion",
                listOf("👕", "👖", "👗", "👘", "🥻", "👙", "👚", "🧥", "🥼", "🦺", "👔", "👞", "👟", "🥾", "🥿", "👠", "👡", "🩰", "🧦", "🧤", "🧣", "🎩", "🧢", "👒", "👑", "💍", "💄", "👛", "👜", "🎒", "🕶️")
            ),
            EmojiCopyCategory(
                "Emoji Food",
                listOf("🍎", "🍐", "🍊", "🍋", "🍌", "🍉", "🍇", "🍓", "🫐", "🍈", "🍒", "🍑", "🍍", "🥭", "🥝", "🍅", "🥑", "🍆", "🥕", "🌽", "🍔", "🍟", "🍕", "🌭", "🌮", "🍣", "🍰", "🍩", "🍪", "☕")
            ),
            EmojiCopyCategory(
                "Emoji Smileys",
                listOf("😀", "😃", "😄", "😁", "😆", "😂", "🤣", "🙂", "😉", "😊", "😍", "😘", "😎", "🤔", "😴", "😭", "😡", "😱", "🥳", "🤩", "😇", "😋", "😜", "🤪", "😈", "👻", "💀", "🎃", "👽", "🤖")
            ),
            EmojiCopyCategory(
                "Emoji Animals",
                listOf("🐶", "🐱", "🐭", "🐹", "🐰", "🦊", "🐻", "🐼", "🐨", "🐯", "🦁", "🐮", "🐷", "🐸", "🐵", "🐔", "🐧", "🐦", "🦄", "🐝", "🦋", "🐢", "🐙", "🐠", "🐬", "🦖", "🦕", "🦩", "🦉", "🦇")
            ),
            EmojiCopyCategory(
                "Emoji Travel",
                listOf("🚗", "🚕", "🚌", "🚎", "🏎️", "🚓", "🚑", "🚒", "🚚", "🚲", "🛵", "🏍️", "✈️", "🚀", "🚁", "🚢", "⛵", "🗽", "🗼", "🏰", "🏝️", "⛰️", "🏕️", "🌋", "🌉", "🎡", "🎢", "🏟️", "🏖️", "🛣️")
            ),
            EmojiCopyCategory(
                "Emoji Objects",
                listOf("⌚", "📱", "💻", "⌨️", "🖥️", "🖨️", "📷", "📺", "📻", "🎙️", "💡", "🔦", "🕯️", "🧸", "🎁", "📚", "✏️", "✂️", "🔒", "🔑", "🧲", "🧪", "🧬", "🔭", "🧰", "🪄", "🧿", "🪩", "🎈", "🎀")
            ),
            EmojiCopyCategory(
                "Emoji Symbols",
                listOf("❤️", "🧡", "💛", "💚", "💙", "💜", "🖤", "🤍", "🤎", "💯", "✅", "❌", "⭐", "🔥", "✨", "⚡", "☀️", "☁️", "☔", "♻️", "⚠️", "🚫", "🔔", "🔕", "🔱", "💠", "🔶", "🔷", "🔴", "🟢")
            )
        )
    }
}

data class EmojiCopyCategory(
    val name: String,
    val items: List<String>
)
