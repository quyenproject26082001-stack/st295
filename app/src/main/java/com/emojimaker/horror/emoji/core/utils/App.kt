package com.emojimaker.horor.emoji.core.utils

import android.content.Context
import com.lvt.ads.util.AdsApplication
import com.lvt.ads.util.AppOpenManager
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.ui.splash.SplashActivity
import kotlin.jvm.java

class App : AdsApplication() {


    override fun onCreate() {
        super.onCreate()
        AppOpenManager.getInstance().disableAppResumeWithActivity(SplashActivity::class.java)
    }

    override fun enableAdsResume(): Boolean {
        return true
    }

    override fun getListTestDeviceId(): MutableList<String>? {
        return null
    }

    override fun getResumeAdId(): String {
        return getString(R.string.appopen_resume)
    }

    override fun buildDebug(): Boolean {
        return true
    }

}