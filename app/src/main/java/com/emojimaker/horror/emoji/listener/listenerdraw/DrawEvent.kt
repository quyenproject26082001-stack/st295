package com.emojimaker.horor.emoji.listener.listenerdraw

import android.view.MotionEvent
import com.emojimaker.horor.emoji.core.custom.drawview.DrawView


interface DrawEvent {
    fun onActionDown(tattooView: DrawView?, event: MotionEvent?)
    fun onActionMove(tattooView: DrawView?, event: MotionEvent?)
    fun onActionUp(tattooView: DrawView?, event: MotionEvent?)
}