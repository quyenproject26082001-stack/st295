package com.create.lalala.ui

import android.view.LayoutInflater
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.gone
import com.create.lalala.core.extensions.handleBackLeftToRight
import com.create.lalala.core.extensions.policy
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.setImageActionBar
import com.create.lalala.core.extensions.setTextActionBar
import com.create.lalala.core.extensions.shareApp
import com.create.lalala.core.extensions.startIntentRightToLeft
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.utils.key.IntentKey
import com.create.lalala.core.utils.state.RateState
import com.create.lalala.databinding.ActivitySettingsBinding
import com.create.lalala.ui.language.LanguageActivity
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.helper.MusicHelper
import com.create.lalala.core.helper.RateHelper
import kotlin.jvm.java

class SettingsActivity : BaseActivity<ActivitySettingsBinding>() {
    override fun setViewBinding(): ActivitySettingsBinding {
        return ActivitySettingsBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
       // binding.tvMusic.select()
        initRate()
        initMusic()
        binding.actionBar.tvCenter.select()
    }

    private fun initMusic() {
        updateMusicUI(sharePreference.isMusicEnabled())
    }

    private fun updateMusicUI(isEnabled: Boolean) {
      //  binding.btnMusic.setImageResource(
//            if (isEnabled) R.drawable.ic_sw_on else R.drawable.ic_sw_off_ms
//        )
    }

    private fun toggleMusic() {
        val isEnabled = !sharePreference.isMusicEnabled()
        sharePreference.setMusicEnabled(isEnabled)
        updateMusicUI(isEnabled)
        if (isEnabled) {
            MusicHelper.play()
        } else {
            MusicHelper.pause()
        }
    }

    override fun viewListener() {
        binding.apply {
           actionBar.btnActionBarLeft.tap { handleBackLeftToRight() }
        //    layoutMusic.tap { toggleMusic() }
            btnLang.tap { startIntentRightToLeft(LanguageActivity::class.java, IntentKey.INTENT_KEY) }
            btnShareApp.tap(1500) { shareApp() }
            btnRate.tap {
                RateHelper.showRateDialog(this@SettingsActivity, sharePreference){ state ->
                    if (state != RateState.CANCEL){
                        btnRate.gone()
                        showToast(R.string.have_rated)
                    }
                }
            }
            btnPolicy.tap(1500) { policy() }
        }
    }

    override fun initText() {
        binding.actionBar.tvCenter.select()
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            setImageActionBar(btnActionBarLeft, R.drawable.ic_back)
            setTextActionBar(tvCenter, getString(R.string.settings))
            btnActionBarLeft.visible()
            tvCenter.visible()
        }
    }

    private fun initRate() {
        if (sharePreference.getIsRate(this)) {
            binding.btnRate.gone()
        } else {
            binding.btnRate.visible()
        }
    }
}
