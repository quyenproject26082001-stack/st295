package com.create.lalala.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.lvt.ads.util.Admob
import com.create.lalala.R
import com.create.lalala.core.base.BaseActivity
import com.create.lalala.core.extensions.rateApp
import com.create.lalala.core.extensions.setImageActionBar
import com.create.lalala.core.extensions.showInterAll
import com.create.lalala.core.extensions.startIntentRightToLeft
import com.create.lalala.core.extensions.visible
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.core.helper.MediaHelper
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.core.utils.state.RateState
import com.create.lalala.data.local.PersistenceRepository
import com.create.lalala.databinding.ActivityHomeBinding
import com.create.lalala.ui.SettingsActivity
import com.create.lalala.ui.my_creation.MyCreationActivity
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.extensions.strings
import com.create.lalala.core.helper.InternetHelper
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.dialog.YesNoDialog
import com.create.lalala.ui.cosplay.CosplayRandomActivity
import com.create.lalala.ui.emoji_copy.EmojiCopyActivity
import com.create.lalala.ui.trending.TrendingActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.system.exitProcess

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun setViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        sharePreference.setCountBack(sharePreference.getCountBack() + 1)
        deleteTempFolder()
        binding.tv1.isSelected = true
      //  binding.tv3.isSelected = true
        binding.tv2.isSelected = true
        binding.tv3.isSelected = true

        // Apply elastic bounce animation to app name
        val elasticBounce = AnimationUtils.loadAnimation(this, R.anim.elastic_bounce)
       // binding.imvAppName.startAnimation(elasticBounce)
    }

    override fun viewListener() {
        binding.apply {
            actionBar.btnActionBarRight.tap(800) { startIntentRightToLeft(SettingsActivity::class.java) }
            btnMyCreation.tap(800) { showInterAll { startIntentRightToLeft(MyCreationActivity::class.java) } }
            btnMaker.tap(800) { checkDataInternet(this@HomeActivity) {startIntentRightToLeft(com.create.lalala.ui.choose_character.ChooseCharacterActivity::class.java) }}
            btnEmojiCopy.tap(800) { showInterAll { startIntentRightToLeft(EmojiCopyActivity::class.java) } }

        }
    }
    fun checkDataInternet(context: AppCompatActivity, action:
    (() -> Unit)) {
        InternetHelper.checkInternet(context) { result ->
            if (result == HandleState.SUCCESS) {
                action.invoke()
            } else {
                val dialog = YesNoDialog(
                    context,
                    R.string.no_internet,
                    R.string.please_check_your_internet,
                    isError = true,
                )
                dialog.show()
                dialog.onYesClick = {
                    dialog.dismiss()
                }
            }
        }
    }
    override fun initText() {
        super.initText()
        //binding.actionBar.tvCenter.select()
    }

    override fun initActionBar() {
        binding.actionBar.apply {
            setImageActionBar(btnActionBarRight, R.drawable.ic_setting)
            btnActionBarRight.visible()
        }
    }

    // Enable background music for HomeActivity
    override fun shouldPlayBackgroundMusic(): Boolean = false

    @SuppressLint("MissingSuperCall", "GestureBackNavigation")
    override fun onBackPressed() {
        if (!sharePreference.getIsRate(this) && sharePreference.getCountBack() % 2 == 0) {
            rateApp(sharePreference) { state ->
                if (state != RateState.CANCEL) {
                    showToast(R.string.have_rated)
                }
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        delay(1000)
                        exitProcess(0)
                    }
                }
            }
        } else {
            exitProcess(0)
        }
    }

    private fun deleteTempFolder() {
        lifecycleScope.launch(Dispatchers.IO) {
            val dataTemp = MediaHelper.getImageInternal(this@HomeActivity, ValueKey.RANDOM_TEMP_ALBUM)
            if (dataTemp.isNotEmpty()) {
                dataTemp.forEach {
                    val file = File(it)
                    file.delete()
                }
                PersistenceRepository.deleteMediaItems(this@HomeActivity, dataTemp)
            }
        }
    }

    private fun updateText() {
        binding.apply {
            tv1.text = strings(R.string.play)
            tv2.text = strings(R.string.horror_emoji)
            tv3.text = strings(R.string.emoji_maker)
            tv4.text = strings(R.string.emoji_copy)
            tv5.text = strings(R.string.my_creation)
        }
    }

    override fun onRestart() {
        super.onRestart()
        deleteTempFolder()
        LanguageHelper.setLocale(this)
        updateText()
        //initNativeCollab()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
        //startStaggeredAnimations()

        }
    }

//    private fun startStaggeredAnimations() {
//        // Card 1: Slide from right (no delay)
//        val slideFromRight1 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_home)
//        binding.btnCosPlay.startAnimation(slideFromRight1)
//        binding.tv1.startAnimation(slideFromRight1)
//
//
//        // Card 2: Slide from left (200ms delay)
//        val slideFromLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left_home)
//        binding.btnRandom.postDelayed({
//            binding.btnRandom.startAnimation(slideFromLeft)
//            binding.tv2.startAnimation(slideFromLeft)
//        }, 200)
//
//        // Card 3: Slide from right (400ms delay)
//        val slideFromRight2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_right_home)
//        binding.btnMyCreation.postDelayed({
//            binding.btnMyCreation.startAnimation(slideFromRight2)
//            binding.tv3.startAnimation(slideFromRight2)
//        }, 400)
//    }

    fun initNativeCollab() {
        Admob.getInstance().loadNativeCollapNotBanner(this,getString(R.string.native_cl_home), binding.flNativeCollab)
    }

    override fun initAds() {
        initNativeCollab()
        Admob.getInstance().loadInterAll(this, getString(R.string.inter_all))
        Admob.getInstance().loadNativeAll(this, getString(R.string.native_all))
    }
}
