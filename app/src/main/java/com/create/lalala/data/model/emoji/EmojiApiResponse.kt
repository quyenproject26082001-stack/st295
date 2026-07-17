package com.create.lalala.data.model.emoji

data class EmojiApiResponse(
    val emoji_normal: List<EmojiCategoryModel> = emptyList(),
    val emoji_horror: List<EmojiCategoryModel> = emptyList()
)

data class EmojiCategoryModel(
    val category: String = "",
    val quantity: Int = 0,
    val level: Int = 100
)
