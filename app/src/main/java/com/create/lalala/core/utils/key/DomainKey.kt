package com.create.lalala.core.utils.key

object DomainKey {
    const val BASE_URL = "https://lvtglobal.tech"
    const val BASE_URL_PREVENTIVE = "https://lvt-api-tech.io.vn"
    const val SUB_DOMAIN = "/public/app/ST261_CatMakerKittyLab"
    const val HTTP = "https://"
    private const val SUB_DOMAIN_BG = "/public/app/ST295_HorrorEmojiMaker"
    const val AVATAR_CHARACTER_API = "avatar.png"
    const val LAYER_EXTENSION = ".png"
    const val IMAGE_NAVIGATION = "nav.png"
    fun getAddCharacterAssetUrl(folder: String): String {
        val remoteFolder = when (folder.lowercase()) {
            AssetsKey.STICKER_ASSET -> "sticker"
            else -> folder.lowercase()
        }
        return "$BASE_URL$SUB_DOMAIN_BG/bg/$remoteFolder"
    }
}