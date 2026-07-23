package com.emojimaker.horor.emoji.ui.customize

import com.emojimaker.horor.emoji.R
import com.lvt.ads.util.Admob


class NormalEmojiActivity : CustomizeEmojiActivity() {
    override val defaultMode: String = MODE_NORMAL


    override fun initAds() {
        super.initAds()
        Admob.getInstance().loadNativeCollapNotBanner(this, getString(R.string.native_collap_createEmoji), binding.flNativeCollab)
    }

    override fun onRestart() {
        super.onRestart()
        initAds()
    }
}
