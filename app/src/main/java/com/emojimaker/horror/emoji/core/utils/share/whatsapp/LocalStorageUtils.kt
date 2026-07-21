package com.emojimaker.horor.emoji.core.utils.share.whatsapp

import android.content.Context
import com.emojimaker.horor.emoji.data.local.PersistenceRepository

object LocalStorageUtils {

    fun readData(context: Context, key: String): Any? {
        return PersistenceRepository.getStringSetting(context, key, "")
            .takeIf { it.isNotEmpty() }
    }
}
