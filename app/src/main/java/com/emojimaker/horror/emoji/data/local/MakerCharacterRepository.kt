package com.emojimaker.horor.emoji.data.local

import android.content.Context
import android.util.Log
import androidx.room.withTransaction
import com.emojimaker.horor.emoji.data.local.entity.MakerCharacterEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerColorEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerEntity
import com.emojimaker.horor.emoji.data.local.entity.MakerLayerGroupEntity
import com.emojimaker.horor.emoji.data.model.custom.ColorModel
import com.emojimaker.horor.emoji.data.model.custom.CustomizeModel
import com.emojimaker.horor.emoji.data.model.custom.LayerListModel
import com.emojimaker.horor.emoji.data.model.custom.LayerModel
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

object MakerCharacterRepository {
    const val SOURCE_LOCAL = "local"
    const val SOURCE_API = "api"
    private const val JSON_CHUNK_SIZE = 64 * 1024

    suspend fun hasSource(context: Context, source: String): Boolean = withContext(Dispatchers.IO) {
        DatabaseProvider.getDatabase(context.applicationContext)
            .makerCharacterDao().countBySource(source) > 0
    }

    suspend fun replaceLocalCharacters(context: Context, models: List<CustomizeModel>): Boolean {
        val saved = replaceSource(context, SOURCE_LOCAL, models)
        if (saved) runCatching {
            DatabaseProvider.getDatabase(context.applicationContext)
                .jsonCacheDao().deleteByKey(ValueKey.DATA_FILE_INTERNAL)
        }.onFailure { Log.w("MakerRoom", "Could not remove old local JSON cache", it) }
        return saved
    }

    suspend fun replaceApiCharacters(context: Context, models: List<CustomizeModel>): Boolean {
        val saved = replaceSource(context, SOURCE_API, models)
        if (saved) runCatching {
            DatabaseProvider.getDatabase(context.applicationContext)
                .jsonCacheDao().deleteByKey(ValueKey.DATA_FILE_API_INTERNAL)
        }.onFailure { Log.w("MakerRoom", "Could not remove old API JSON cache", it) }
        return saved
    }

    suspend fun clearApiCharacters(context: Context) = withContext(Dispatchers.IO) {
        DatabaseProvider.getDatabase(context.applicationContext)
            .makerCharacterDao().deleteBySource(SOURCE_API)
    }

    suspend fun importLegacyApiIfNeeded(context: Context, fileName: String): Boolean {
        if (hasSource(context, SOURCE_API)) return true
        val type = object : TypeToken<List<CustomizeModel>>() {}.type
        val roomModels = runCatching {
            Gson().fromJson<List<CustomizeModel>>(readLegacyJsonInChunks(context, fileName), type)
                .orEmpty()
        }.getOrDefault(emptyList())
        val models = if (roomModels.isNotEmpty()) roomModels else runCatching {
            val file = File(context.filesDir, fileName)
            if (file.isFile && file.length() > 0L) {
                Gson().fromJson<List<CustomizeModel>>(file.readText(), type).orEmpty()
            } else emptyList()
        }.getOrDefault(emptyList())
        return runCatching { replaceApiCharacters(context, models) }
            .onFailure { Log.w("MakerRoom", "Could not import old API cache", it) }
            .getOrDefault(false)
    }

    private suspend fun readLegacyJsonInChunks(context: Context, key: String): String {
        val dao = DatabaseProvider.getDatabase(context.applicationContext).jsonCacheDao()
        val totalLength = dao.getJsonLength(key) ?: return ""
        return buildString(totalLength) {
            var offset = 1
            while (offset <= totalLength) {
                val chunk = dao.getJsonChunk(key, offset, JSON_CHUNK_SIZE).orEmpty()
                if (chunk.isEmpty()) break
                append(chunk)
                offset += chunk.codePointCount(0, chunk.length)
            }
        }
    }

    suspend fun getAllCharacters(context: Context): ArrayList<CustomizeModel> =
        withContext(Dispatchers.IO) {
            val dao = DatabaseProvider.getDatabase(context.applicationContext).makerCharacterDao()
            val groupsByCharacter = dao.getAllLayerGroups().groupBy { it.characterId }
            val layersByGroup = dao.getAllLayers().groupBy { it.layerGroupId }
            val colorsByLayer = dao.getAllColors().groupBy { it.layerId }

            dao.getCharacters().map { character ->
                val groups = groupsByCharacter[character.id].orEmpty().map { group ->
                    val layers = layersByGroup[group.id].orEmpty().map { layer ->
                        val colors = colorsByLayer[layer.id].orEmpty().map { color ->
                            ColorModel(color.color, color.path)
                        }.toCollection(ArrayList())
                        LayerModel(layer.image, layer.isMoreColors, colors, layer.thumb)
                    }.toCollection(ArrayList())
                    LayerListModel(
                        group.positionCustom,
                        group.positionNavigation,
                        group.imageNavigation,
                        layers,
                        group.type
                    )
                }.toCollection(ArrayList())
                CustomizeModel(
                    character.dataName,
                    character.avatar,
                    groups,
                    character.level,
                    character.isFromApi
                )
            }.toCollection(ArrayList())
        }

    private suspend fun replaceSource(
        context: Context,
        source: String,
        models: List<CustomizeModel>
    ): Boolean = withContext(Dispatchers.IO) {
        if (models.isEmpty()) return@withContext false
        val characters = ArrayList<MakerCharacterEntity>()
        val groups = ArrayList<MakerLayerGroupEntity>()
        val layers = ArrayList<MakerLayerEntity>()
        val colors = ArrayList<MakerColorEntity>()

        models.filter { it.dataName.isNotBlank() }.forEachIndexed { characterIndex, model ->
            val characterId = "$source|${model.dataName}"
            characters += MakerCharacterEntity(
                characterId, source, model.dataName, model.avatar, model.level,
                source == SOURCE_API, characterIndex
            )
            model.layerList.forEachIndexed { groupIndex, group ->
                val groupId = "$characterId/g/$groupIndex"
                groups += MakerLayerGroupEntity(
                    groupId, characterId, group.positionCustom, group.positionNavigation,
                    group.imageNavigation, group.type, groupIndex
                )
                group.layer.forEachIndexed { layerIndex, layer ->
                    val layerId = "$groupId/l/$layerIndex"
                    layers += MakerLayerEntity(
                        layerId, groupId, layer.image, layer.isMoreColors, layer.thumb, layerIndex
                    )
                    layer.listColor.forEachIndexed { colorIndex, color ->
                        colors += MakerColorEntity(
                            "$layerId/c/$colorIndex", layerId, color.color, color.path, colorIndex
                        )
                    }
                }
            }
        }

        if (characters.isEmpty()) return@withContext false
        val database = DatabaseProvider.getDatabase(context.applicationContext)
        database.withTransaction {
            val dao = database.makerCharacterDao()
            dao.deleteBySource(source)
            dao.insertCharacters(characters)
            if (groups.isNotEmpty()) dao.insertLayerGroups(groups)
            if (layers.isNotEmpty()) dao.insertLayers(layers)
            if (colors.isNotEmpty()) dao.insertColors(colors)
        }
        true
    }
}
