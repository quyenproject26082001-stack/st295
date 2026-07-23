package com.emojimaker.horor.emoji.ui.emoji_copy

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.extensions.gone
import com.emojimaker.horor.emoji.core.extensions.handleBackLeftToRight
import com.emojimaker.horor.emoji.core.extensions.select
import com.emojimaker.horor.emoji.core.extensions.tap
import com.emojimaker.horor.emoji.core.extensions.visible
import com.emojimaker.horor.emoji.databinding.ActivityEmojiCopyBinding
import com.lvt.ads.util.Admob

class EmojiCopyActivity : BaseActivity<ActivityEmojiCopyBinding>() {

    private val tabAdapter by lazy { EmojiCopyTabAdapter() }
    private val itemAdapter by lazy { EmojiCopyItemAdapter() }
    private val emojiCategories by lazy { createEmojiCategories() }

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

    fun initNativeCollab() {
        Admob.getInstance().loadNativeCollapNotBanner(this,getString(R.string.native_collap_category_emoji), binding.flNativeCollab)
    }

    override fun initAds() {
        initNativeCollab()
        Admob.getInstance().loadNativeAd(
            this,
            getString(R.string.native_emojiCoppy),
            binding.nativeAds,
            R.layout.ads_native_banner1
        )
    }

    override fun onRestart() {
        super.onRestart()
        initNativeCollab()
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            btnActionBarLeft.visible()
            tvCenter.visible()
            tvCenter.text = getString(R.string.emoji_copy)
            tvCenter.select()
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
                getString(R.string.emoji_smileys),
                listOf("😀", "😃", "😄", "😁", "😆", "😂", "🤣", "🙂", "🙃", "😉", "😊", "😇", "😍", "🥰", "😘", "😗", "😚", "😙", "😋", "😛", "😜", "🤪", "😝", "🤑", "🤗", "🤭", "🫢", "🫣", "🤫", "🤔", "🫡", "🤐", "🤨", "😐", "😑", "😶", "🫥", "😏", "😒", "🙄", "😬", "😮‍💨", "🤥", "😌", "😔", "😪", "🤤", "😴", "😭", "😡", "😱", "🥳", "🤩", "😎", "🤓", "🧐", "😈", "👻", "💀", "🎃", "👽", "🤖")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_fashion),
                listOf("👕", "👖", "👗", "👘", "🥻", "👙", "👚", "🧥", "🥼", "🦺", "👔", "👞", "👟", "🥾", "🥿", "👠", "👡", "🩰", "🧦", "🧤", "🧣", "🎩", "🧢", "👒", "🎓", "⛑️", "🪖", "👑", "💍", "💄", "💋", "👛", "👜", "👝", "🛍️", "🎒", "🕶️", "🥽", "🌂", "💎")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_food),
                listOf("🍎", "🍐", "🍊", "🍋", "🍌", "🍉", "🍇", "🍓", "🫐", "🍈", "🍒", "🍑", "🍍", "🥭", "🥝", "🍅", "🥑", "🍆", "🥕", "🌽", "🥔", "🍠", "🥐", "🥯", "🍞", "🥖", "🧀", "🥚", "🍳", "🥞", "🧇", "🥓", "🍗", "🍖", "🍔", "🍟", "🍕", "🌭", "🥪", "🌮", "🌯", "🫔", "🥙", "🧆", "🍣", "🍱", "🍜", "🍰", "🧁", "🍩", "🍪", "🍫", "🍬", "🍭", "☕", "🧋", "🥤")
            ),

            EmojiCopyCategory(
                getString(R.string.emoji_animals),
                listOf("🐶", "🐱", "🐭", "🐹", "🐰", "🦊", "🐻", "🐼", "🐨", "🐯", "🦁", "🐮", "🐷", "🐸", "🐵", "🐔", "🐧", "🐦", "🐤", "🦆", "🦅", "🦉", "🦇", "🐺", "🐗", "🐴", "🦄", "🐝", "🪲", "🦋", "🐛", "🐌", "🐞", "🐜", "🕷️", "🦂", "🐢", "🐍", "🦎", "🐙", "🦑", "🦀", "🐠", "🐟", "🐬", "🦈", "🐳", "🦖", "🦕", "🦩")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_travel),
                listOf("🚗", "🚕", "🚙", "🚌", "🚎", "🏎️", "🚓", "🚑", "🚒", "🚚", "🚛", "🚜", "🛺", "🚲", "🛵", "🏍️", "🛴", "🚂", "🚆", "🚇", "🚊", "🚝", "🚄", "✈️", "🛫", "🛬", "🚀", "🛸", "🚁", "🚢", "⛵", "🛥️", "🛳️", "🗽", "🗼", "🏰", "🏯", "🏟️", "🎡", "🎢", "🎠", "🏝️", "🏖️", "⛰️", "🏔️", "🏕️", "🌋", "🌉", "🛣️", "🛤️")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_objects),
                listOf("⌚", "📱", "📲", "💻", "⌨️", "🖥️", "🖨️", "🖱️", "💾", "💿", "📷", "📸", "📹", "📺", "📻", "🎙️", "🎧", "🎮", "🕹️", "💡", "🔦", "🕯️", "🧸", "🎁", "📦", "📚", "📖", "✏️", "🖊️", "🖌️", "✂️", "📌", "📎", "🔒", "🔓", "🔑", "🧲", "🧪", "🧬", "🔬", "🔭", "🧰", "🪛", "🔧", "🔨", "🪄", "🧿", "🪩", "🎈", "🎀")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_symbols),
                listOf("❤️", "🧡", "💛", "💚", "💙", "💜", "🖤", "🤍", "🤎", "💔", "❣️", "💕", "💞", "💓", "💗", "💖", "💘", "💝", "💟", "💯", "✅", "☑️", "✔️", "❌", "❎", "➕", "➖", "➗", "✖️", "⭐", "🌟", "🔥", "✨", "⚡", "💥", "☀️", "☁️", "☔", "❄️", "♻️", "⚠️", "🚫", "🔔", "🔕", "🔱", "💠", "🔶", "🔷", "🔴", "🟠", "🟡", "🟢", "🔵", "🟣")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_horror),
                listOf("😨", "😰", "😱", "😵", "😵‍💫", "🥶", "😈", "👿", "👹", "👺", "🤡", "💀", "☠️", "👻", "🎃", "🧛", "🧟", "🧙", "🕷️", "🕸️", "🦇", "🩸", "🪦", "⚰️", "🪓", "🔪", "⛓️", "🕯️", "🌕", "🌑", "🌫️", "⚡", "🔥", "🧪", "🧿", "🚪", "🗝️", "🏚️", "🌲", "🪞")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_nature),
                listOf("🌱", "🌿", "☘️", "🍀", "🎍", "🪴", "🌵", "🌴", "🌳", "🌲", "🍁", "🍂", "🍃", "🌾", "💐", "🌷", "🌹", "🥀", "🌺", "🌸", "🌼", "🌻", "🌞", "🌝", "🌛", "🌜", "🌚", "🌕", "🌖", "🌗", "🌘", "🌑", "🌒", "🌓", "🌔", "🌙", "🌎", "🌍", "🌏", "🪐", "💫", "⭐", "🌟", "☄️", "🌈", "☁️", "⛅", "⛈️", "🌧️", "❄️")
            ),
            EmojiCopyCategory(
                getString(R.string.emoji_activities),
                listOf("⚽", "🏀", "🏈", "⚾", "🥎", "🎾", "🏐", "🏉", "🥏", "🎱", "🪀", "🏓", "🏸", "🏒", "🏑", "🥍", "🏏", "🪃", "🥅", "⛳", "🪁", "🏹", "🎣", "🤿", "🥊", "🥋", "🎽", "🛹", "🛼", "🛷", "⛸️", "🥌", "🎿", "⛷️", "🏂", "🎤", "🎧", "🎼", "🎹", "🥁", "🎷", "🎺", "🎸", "🪕", "🎻", "🎲", "♟️", "🎯", "🎳", "🎮")
            )
        )
    }
}

data class EmojiCopyCategory(
    val name: String,
    val items: List<String>
)
