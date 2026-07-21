package com.emojimaker.horor.emoji.data.model.custom

import com.emojimaker.horor.emoji.data.model.custom.ColorModel

data class LayerModel(
    val image: String,
    val isMoreColors: Boolean = false,
    var listColor: ArrayList<ColorModel> = arrayListOf(),
    val thumb: String = ""
)