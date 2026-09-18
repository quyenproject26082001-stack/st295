package com.emojimaker.horor.emoji.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emojimaker.horor.emoji.core.helper.AssetHelper
import com.emojimaker.horor.emoji.core.helper.InternetHelper
import com.emojimaker.horor.emoji.core.service.RetrofitClient
import com.emojimaker.horor.emoji.core.service.RetrofitPreventive
import com.emojimaker.horor.emoji.core.utils.DataLocal.isFailBaseURL
import com.emojimaker.horor.emoji.core.utils.key.DomainKey
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import com.emojimaker.horor.emoji.data.local.MakerCharacterRepository
import com.emojimaker.horor.emoji.data.model.DataAPI
import com.emojimaker.horor.emoji.data.model.PartAPI
import com.emojimaker.horor.emoji.data.model.custom.ColorModel
import com.emojimaker.horor.emoji.data.model.custom.CustomizeModel
import com.emojimaker.horor.emoji.data.model.custom.LayerListModel
import com.emojimaker.horor.emoji.data.model.custom.LayerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.collections.forEachIndexed

class DataViewModel() : ViewModel() {

    companion object{
        private val _shareData = MutableStateFlow<ArrayList<CustomizeModel>>(arrayListOf())
    }

    private val _allData get() = _shareData

    val allData: StateFlow<ArrayList<CustomizeModel>> = _shareData.asStateFlow()

    private val _dataLoadFinished = MutableStateFlow(false)

    val dataLoadFinished: StateFlow<Boolean> = _dataLoadFinished.asStateFlow()

    private val _getDataAPI = MutableLiveData<List<PartAPI>>()
    val getDataAPI: LiveData<List<PartAPI>> get() = _getDataAPI

    fun saveAndReadData(context: Context) {
        viewModelScope.launch {
            val timeStart = System.currentTimeMillis()
            Log.d("TIMING_TRENDING", "saveAndReadData() START")
            val list = withContext(Dispatchers.IO) {
                // Import local assets once; Maker data is stored in normalized Room tables.
                val assetStart = System.currentTimeMillis()
                val isFirstRun = !MakerCharacterRepository.hasSource(context, MakerCharacterRepository.SOURCE_LOCAL)
                if (isFirstRun) {
                    val localAssets = AssetHelper.getDataFromAsset(context)
                    MakerCharacterRepository.replaceLocalCharacters(context, localAssets)
                    Log.d("TIMING_TRENDING", "  [Asset] import vào Room: ${System.currentTimeMillis() - assetStart}ms")
                    Log.d("nbhieu", "=== FIRST LAUNCH ===")
                    Log.d("nbhieu", "Device: ${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL} (Android ${android.os.Build.VERSION.RELEASE}, SDK ${android.os.Build.VERSION.SDK_INT})")
                    try {
                        val pm = context.packageManager
                        val pi = pm.getPackageInfo(context.packageName, 0)
                        Log.d("nbhieu", "App: ${pi.packageName} v${pi.versionName} (${pi.longVersionCode})")
                    } catch (e: Exception) {
                        Log.e("nbhieu", "Could not read package info: ${e.message}")
                    }
                    Log.d("nbhieu", "Locale: ${java.util.Locale.getDefault()}")
                    Log.d("nbhieu", "Timestamp: ${java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(java.util.Date())}")
                }

                val localStart = System.currentTimeMillis()
                MakerCharacterRepository.importLegacyApiIfNeeded(context, ValueKey.DATA_FILE_API_INTERNAL)
                var roomData = MakerCharacterRepository.getAllCharacters(context)
                val localData = roomData.filter { !it.isFromAPI }
                Log.d("TIMING_TRENDING", "  [Local] đọc Room: ${System.currentTimeMillis() - localStart}ms | items=${localData.size}")
                if (isFirstRun) {
                    Log.d("nbhieu", "Init asset data: ${localData.size} characters loaded")
                }

                val apiCacheStart = System.currentTimeMillis()
                var dataApi = roomData.filter { it.isFromAPI }
                Log.d("TIMING_TRENDING", "  [API] đọc Room cache: ${System.currentTimeMillis() - apiCacheStart}ms | items=${dataApi.size}")
                if (hasStaleApiAssetDomain(dataApi)) {
                    Log.w(
                        "TIMING_TRENDING",
                        "  [API] cache domain cũ, clear API Room/cache để rebuild bằng ${DomainKey.SUB_DOMAIN}"
                    )
                    MakerCharacterRepository.clearApiCharacters(context)
                    PersistenceRepository.clearInternalData(context, ValueKey.DATA_FILE_API_INTERNAL)
                    dataApi = emptyList()
                }

                if (InternetHelper.checkInternet(context)) {
                    Log.d("TIMING_TRENDING", "  [API] có mạng → gọi API để sync data mới nhất...")
                    val apiCallStart = System.currentTimeMillis()
                    getAllParts(context).collect { state ->
                        when (state) {
                            HandleState.LOADING -> {}
                            HandleState.SUCCESS -> {
                                Log.d("TIMING_TRENDING", "  [API] response + parse + lưu Room: ${System.currentTimeMillis() - apiCallStart}ms")
                                roomData = MakerCharacterRepository.getAllCharacters(context)
                                dataApi = roomData.filter { it.isFromAPI }
                                Log.d("TIMING_TRENDING", "  [API] đọc lại Room sau lưu: items=${dataApi.size}")
                            }
                            else -> {
                                Log.d("TIMING_TRENDING", "  [API] FAIL sau ${System.currentTimeMillis() - apiCallStart}ms")
                            }
                        }
                    }
                } else {
                    Log.d("TIMING_TRENDING", "  [API] bỏ qua vì không có mạng, dùng cache hiện tại")
                }

                MakerCharacterRepository.getAllCharacters(context)
            }
            _allData.value = list
            _dataLoadFinished.value = true
            val timeEnd = System.currentTimeMillis()
            Log.d("TIMING_TRENDING", "saveAndReadData() DONE | tổng: ${timeEnd - timeStart}ms | allData.size=${list.size}")
            Log.d("nbhieu", "time load data: ${timeEnd - timeStart}")
        }
    }

    private fun hasStaleApiAssetDomain(dataApi: List<CustomizeModel>): Boolean {
        if (dataApi.isEmpty()) return false

        fun String.hasWrongRemoteDomain(): Boolean {
            return startsWith(DomainKey.BASE_URL) && !contains(DomainKey.SUB_DOMAIN)
        }

        return dataApi.any { item ->
            item.avatar.hasWrongRemoteDomain() ||
                item.layerList.any { layerList ->
                    layerList.imageNavigation.hasWrongRemoteDomain() ||
                        layerList.layer.any { layer ->
                            layer.image.hasWrongRemoteDomain() || layer.thumb.hasWrongRemoteDomain()
                        }
                }
        }
    }

    fun ensureData(context: Context) {
        if (_allData.value.isEmpty()) {
            saveAndReadData(context)
        } else {
            _dataLoadFinished.value = true
        }
    }

    fun getAllParts(context: Context): Flow<HandleState> = flow {
        Log.d("nbhieu", "API Calling...")
        Log.d("TIMING_TRENDING", "  [API] getAllParts() START")
        emit(HandleState.LOADING)

        val primaryStart = System.currentTimeMillis()
        val response = withTimeoutOrNull(5_000) {
            try {
                RetrofitClient.api.getAllData()
            } catch (e: Exception) {
                Log.e("nbhieu", "BASE_URL failed: ${e.message}")
                Log.e("TIMING_TRENDING", "  [API] BASE_URL fail sau ${System.currentTimeMillis() - primaryStart}ms: ${e.message}")
                null
            }
        }.also {
            if (it != null) Log.d("TIMING_TRENDING", "  [API] BASE_URL response: ${System.currentTimeMillis() - primaryStart}ms | success=${it.isSuccessful}")
            else if (System.currentTimeMillis() - primaryStart >= 4900) Log.w("TIMING_TRENDING", "  [API] BASE_URL timeout (5s)")
        } ?: withTimeoutOrNull(5_000) {
            val fallbackStart = System.currentTimeMillis()
            try {
                RetrofitPreventive.api.getAllData()
            } catch (e: Exception) {
                Log.e("nbhieu", "BASE_URL_PREVENTIVE failed: ${e.message}")
                Log.e("TIMING_TRENDING", "  [API] BASE_URL_PREVENTIVE fail sau ${System.currentTimeMillis() - fallbackStart}ms: ${e.message}")
                null
            }
        }.also {
            if (it != null) Log.d("TIMING_TRENDING", "  [API] BASE_URL_PREVENTIVE response: ok")
            else Log.w("TIMING_TRENDING", "  [API] BASE_URL_PREVENTIVE cũng fail/timeout")
        }

        if (response != null && response.isSuccessful && response.body() != null) {
            val dataMap = ArrayList<DataAPI>()
            response.body()?.forEach { (key, dataBody) ->
                dataMap.add(DataAPI(key, dataBody))
            }
            val saved = try {
                withContext(Dispatchers.IO) { getDataAPI(context, dataMap) }
            } catch (error: Exception) {
                Log.e("TIMING_TRENDING", "  [API] parse/Room save failed", error)
                false
            }
            emit(if (saved) HandleState.SUCCESS else HandleState.FAIL)
        } else {
            Log.w("TIMING_TRENDING", "  [API] request fail, giữ cache API cũ để app vẫn có data")
            emit(HandleState.FAIL)
        }
    }

    suspend fun getDataAPI(context: Context, dataList: ArrayList<DataAPI>): Boolean {
        val allDataAPI: ArrayList<CustomizeModel> = arrayListOf()
        // Character 1, Character 2,...
        dataList.forEachIndexed { indexCharacter, data ->
            ///public/app/ChibiMaker/1/avatar.png

            //https://lvt-api-tech.io.vn/public/app/st225_couplemakerkisscreator/data3/avatar.png
            //https://lvt-api-tech.io.vn/public/app/st225_couplemakerkisscreator/data3/10-19-2/FFFFFF/1.png
            val baseDomain = if (!isFailBaseURL) DomainKey.BASE_URL else DomainKey.BASE_URL_PREVENTIVE
            val avatarCharacter = "$baseDomain${DomainKey.SUB_DOMAIN}/${data.name}/${DomainKey.AVATAR_CHARACTER_API}"
            val layerList = ArrayList<LayerListModel>(data.parts.size)

            // Sort parts by level in ascending order
            val sortedParts = data.parts.sortedBy { it.level }

            sortedParts.forEachIndexed { indexLayer, dataLayer ->
                // Handle both "-" and "_" delimiters, similar to local asset loading
                val layerName = if (dataLayer.parts.contains("-")) {
                    dataLayer.parts.split("-")
                } else {
                    dataLayer.parts.split("_")
                }
                val positionCustom = layerName[0].toInt() - 1
                val positionNavigation = layerName[1].toInt() - 1
                val type = if (layerName.size >= 3) layerName[2].toIntOrNull() ?: 0 else 0
                val imageNavigation = "${baseDomain}${DomainKey.SUB_DOMAIN}/${data.name}/${dataLayer.parts}/${DomainKey.IMAGE_NAVIGATION}"
                if (data.name == "data6") {
                    Log.d("Data6Debug", "=== PART[$indexLayer] ===")
                    Log.d("Data6Debug", "  parts       = ${dataLayer.parts}")
                    Log.d("Data6Debug", "  position    = ${dataLayer.position}")
                    Log.d("Data6Debug", "  quantity    = ${dataLayer.quantity}")
                    Log.d("Data6Debug", "  colorArray  = '${dataLayer.colorArray}'")
                    Log.d("Data6Debug", "  level       = ${dataLayer.level}")
                    Log.d("Data6Debug", "  posCustom   = $positionCustom | posNav = $positionNavigation | type = $type")
                    Log.d("Data6Debug", "  navURL      = $imageNavigation")
                }
                val layer = getDataLayer(baseDomain, dataLayer, dataLayer.parts)

                val layerListModel = LayerListModel(
                    positionCustom = positionCustom,
                    positionNavigation = positionNavigation,
                    imageNavigation = imageNavigation,
                    layer = layer,
                    type = type
                )
                layerList.add(layerListModel)
            }
            layerList.sortBy { it.positionNavigation }

            // Use the minimum level from all parts as the character level
            val characterLevel = sortedParts.minOfOrNull { it.level } ?: 100

            val dataApi = CustomizeModel(
                dataName = data.name,
                avatar = avatarCharacter,
                layerList = layerList,
                level = characterLevel,
                isFromAPI = true
            )
            allDataAPI.add(dataApi)
        }
        val saved = MakerCharacterRepository.replaceApiCharacters(context, allDataAPI)
        allDataAPI.forEach {
            Log.d("nbhieu", "avatar: ${it.avatar}")
        }
        return saved
    }

    private fun getDataLayer(baseDomain: String, partData: PartAPI, layer: String): ArrayList<LayerModel> {
        val hasColor = partData.colorArray != "" || partData.colorArray.isNotEmpty()
        if (partData.position == "data6") {
            Log.d("Data6Debug", "  hasColor    = $hasColor → ${if (hasColor) "getDataAPIColor" else "getDataAPINoColor"}")
        }
        return if (hasColor) {
            getDataAPIColor(baseDomain, partData, layer)
        } else {
            getDataAPINoColor(baseDomain, partData, layer)
        }
    }

    private fun getDataAPINoColor(baseDomain: String, part: PartAPI, layer: String): ArrayList<LayerModel> {
        val actualQuantity = when (part.position) {
            "data300", "data100" -> part.quantity / 2
            else -> part.quantity
        }
        val layerPath = ArrayList<LayerModel>(actualQuantity)
        val prefix = "$baseDomain${DomainKey.SUB_DOMAIN}/${part.position}/${layer}/"
        val suffix = DomainKey.LAYER_EXTENSION
        if (part.position == "data6") {
            Log.d("Data6Debug", "  NoColor: quantity=${part.quantity} → actualQuantity=$actualQuantity")
            Log.d("Data6Debug", "  NoColor: prefix=$prefix | suffix=$suffix")
            Log.d("Data6Debug", "  NoColor: first URL = ${prefix}1${suffix}")
        }
        for (i in 1..actualQuantity) {
            layerPath.add(
                LayerModel(
                    "$prefix${i}$suffix",
                    false,
                    arrayListOf(),
                    "${prefix}thumb_${i}$suffix"
                )
            )
        }
        return layerPath
    }

    private fun getDataAPIColor(baseDomain: String, part: PartAPI, layer: String): ArrayList<LayerModel> {
        val layerPath = ArrayList<LayerModel>(part.quantity)
        val getColorCode = part.colorArray.split(",")
        val prefix = "$baseDomain${DomainKey.SUB_DOMAIN}/${part.position}/${layer}/"
        val suffix = DomainKey.LAYER_EXTENSION

        for (i in 1..part.quantity) {
            val listColor = ArrayList<ColorModel>(getColorCode.size)
            for (j in 0 until getColorCode.size) {
                listColor.add(
                    ColorModel(
                        "#${getColorCode[j]}",
                        "$prefix${getColorCode[j]}/${i}$suffix"
                    )
                )
            }
            layerPath.add(LayerModel(listColor.first().path, true, listColor, "${prefix}thumb_${i}$suffix"))
        }
        return layerPath
    }
}
