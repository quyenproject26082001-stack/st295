package com.emojimaker.horor.emoji.data.model

data class PackageModel(
    val id: String,
    val name: String,
    val previewPath: String = "",
    val items: ArrayList<String> = arrayListOf(),
    var isShowSelection: Boolean = false,
    var isSelected: Boolean = false
)
