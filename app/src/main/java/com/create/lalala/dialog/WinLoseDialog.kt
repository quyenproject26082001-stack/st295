package com.create.lalala.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.create.lalala.R
import com.create.lalala.core.extensions.select
import com.create.lalala.core.extensions.tap
import com.create.lalala.core.helper.LanguageHelper
import com.create.lalala.databinding.DialogStateCosplayBinding

class WinLoseDialog(
    val context: Activity,
    val title: Int,
    val description: Int,
    val isWin: Boolean
) : Dialog(context) {

    private lateinit var binding: DialogStateCosplayBinding
    var onNextClick: (() -> Unit) = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageHelper.setLocale(context)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogStateCosplayBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
        }

        setCancelable(false)
        setCanceledOnTouchOutside(false)

        binding.tvTitle.setText(title)
        binding.tvDescription.setText(description)
        binding.tvTitle.select()
        binding.tvDescription.select()
        if(!isWin) {
            binding.win1.visibility = View.GONE
            binding.win2.visibility = View.GONE
            binding.BgTitle.setBackgroundResource(R.drawable.title_lose)

        }else{
            binding.win1.visibility = View.VISIBLE
            binding.win2.visibility = View.VISIBLE
            binding.BgTitle.setBackgroundResource(R.drawable.title_win)

        }
        binding.ImgWin.setImageResource(if (isWin) R.drawable.img_win else R.drawable.img_lose)
        binding.btnNext.tap {
            onNextClick.invoke()
        }
    }

}
