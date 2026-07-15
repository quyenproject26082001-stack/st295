package com.create.lalala.core.helper

import android.content.Context
import com.create.lalala.core.utils.key.PermissionKey.CAMERA_KEY
import com.create.lalala.core.utils.key.PermissionKey.NOTIFICATION_KEY
import com.create.lalala.core.utils.key.PermissionKey.QUANTITY_UNZIPPED
import com.create.lalala.core.utils.key.PermissionKey.STORAGE_KEY
import com.create.lalala.core.utils.key.SharePreferenceKey.COUNT_BACK_KEY
import com.create.lalala.core.utils.key.SharePreferenceKey.FIRST_LANG_KEY
import com.create.lalala.core.utils.key.SharePreferenceKey.FIRST_PERMISSION_KEY
import com.create.lalala.core.utils.key.SharePreferenceKey.KEY_LANGUAGE
import com.create.lalala.core.utils.key.SharePreferenceKey.MUSIC_KEY
import com.create.lalala.core.utils.key.SharePreferenceKey.PRIDE_CUSTOM_FLAGS
import com.create.lalala.core.utils.key.SharePreferenceKey.RATE_KEY
import com.create.lalala.data.local.PersistenceRepository
import com.create.lalala.data.model.pride.CustomFlagModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharePreferenceHelper(val context: Context) {

    // Language
    fun getPreLanguage(): String {
        return PersistenceRepository.getStringSetting(context, KEY_LANGUAGE, "")
    }

    fun setPreLanguage(language: String) {
        PersistenceRepository.setStringSetting(context, KEY_LANGUAGE, language)
    }

    // First Language
    fun getIsFirstLang(): Boolean {
        return PersistenceRepository.getBooleanSetting(context, FIRST_LANG_KEY, true)
    }

    fun setIsFirstLang(isFirstAccess: Boolean) {
        PersistenceRepository.setBooleanSetting(context, FIRST_LANG_KEY, isFirstAccess)
    }

    // Permission
    fun getIsFirstPermission(): Boolean {
        return PersistenceRepository.getBooleanSetting(context, FIRST_PERMISSION_KEY, true)
    }

    fun setIsFirstPermission(isFirstAccess: Boolean) {
        PersistenceRepository.setBooleanSetting(context, FIRST_PERMISSION_KEY, isFirstAccess)
    }

    // Rate
    fun getIsRate(context: Context): Boolean {
        return PersistenceRepository.getBooleanSetting(this.context, RATE_KEY, false)
    }

    fun setIsRate(isFirstAccess: Boolean) {
        PersistenceRepository.setBooleanSetting(context, RATE_KEY, isFirstAccess)
    }

    // Back
    fun setCountBack(countBack: Int) {
        PersistenceRepository.setIntSetting(context, COUNT_BACK_KEY, countBack)
    }

    fun getCountBack(): Int {
        return PersistenceRepository.getIntSetting(context, COUNT_BACK_KEY, 0)
    }

    // Storage Permission
    fun getStoragePermission(): Int {
        return PersistenceRepository.getIntSetting(context, STORAGE_KEY, 0)
    }

    fun setStoragePermission(count: Int) {
        PersistenceRepository.setIntSetting(context, STORAGE_KEY, count)
    }

    // Notification Permission
    fun getNotificationPermission(): Int {
        return PersistenceRepository.getIntSetting(context, NOTIFICATION_KEY, 0)
    }

    fun setNotificationPermission(count: Int) {
        PersistenceRepository.setIntSetting(context, NOTIFICATION_KEY, count)
    }

    // Camera Permission
    fun getCameraPermission(): Int {
        return PersistenceRepository.getIntSetting(context, CAMERA_KEY, 0)
    }

    fun setCameraPermission(count: Int) {
        PersistenceRepository.setIntSetting(context, CAMERA_KEY, count)
    }

    // Data asset
    fun getQuantityUnzipped(): MutableSet<Int> {
        val json = PersistenceRepository.getStringSetting(context, QUANTITY_UNZIPPED, "[]")
        val type = object : TypeToken<MutableSet<Int>>(){}.type
        return Gson().fromJson(json, type)
    }

    fun setQuantityUnzipped(count: MutableSet<Int>) {
        val json = Gson().toJson(count)
        PersistenceRepository.setStringSetting(context, QUANTITY_UNZIPPED, json)
    }

    // Pride Custom Flags
    fun getCustomFlags(): MutableList<CustomFlagModel> {
        val json = PersistenceRepository.getStringSetting(context, PRIDE_CUSTOM_FLAGS, "[]")
        val type = object : TypeToken<MutableList<CustomFlagModel>>() {}.type
        return Gson().fromJson(json, type) ?: mutableListOf()
    }

    fun setCustomFlags(flags: List<CustomFlagModel>) {
        PersistenceRepository.setStringSetting(context, PRIDE_CUSTOM_FLAGS, Gson().toJson(flags))
    }

    // Music
    fun isMusicEnabled(): Boolean {
        return PersistenceRepository.getBooleanSetting(context, MUSIC_KEY, true)
    }

    fun setMusicEnabled(enabled: Boolean) {
        PersistenceRepository.setBooleanSetting(context, MUSIC_KEY, enabled)
    }
}
