package com.emojimaker.horor.emoji.ui.customize

import com.emojimaker.horor.emoji.R
import com.lvt.ads.util.Admob

class HorrorEmojiActivity : CustomizeEmojiActivity() {
    override val defaultMode: String = MODE_HORROR

    override fun initAds() {
        super.initAds()
        Admob.getInstance().loadNativeCollapNotBanner(this, getString(R.string.native_collap_createHorror), binding.flNativeCollab)
    }

    override fun onRestart() {
        super.onRestart()
        initAds()
    }
}
