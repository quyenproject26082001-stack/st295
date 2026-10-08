package com.emojimaker.horor.emoji.ui.my_creation.view_model

import android.content.Context
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CancellationException
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.emojimaker.horor.emoji.core.helper.MediaHelper
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import com.emojimaker.horor.emoji.data.model.MyAlbumModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyEmojiViewModel : ViewModel() {
    private val _myEmojiList = MutableStateFlow<ArrayList<MyAlbumModel>>(arrayListOf())
    val myEmojiList = _myEmojiList.asStateFlow()

    private var loadJob: Job? = null
    private var loadedRevision = -1L
    private var loadingRevision = -1L

    fun loadMyEmoji(context: Context, force: Boolean = false) {
        val revision = PersistenceRepository.creationRevision.value
        if (!force && (loadedRevision == revision || (loadJob?.isActive == true && loadingRevision == revision))) return
        loadingRevision = revision
        val appContext = context.applicationContext
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            try {
                val items = withContext(Dispatchers.IO) {
                    PersistenceRepository.getAlbumPathsAsync(appContext, ValueKey.EMOJI_ALBUM)
                        .map { MyAlbumModel(it) }.toCollection(ArrayList())
                }
                _myEmojiList.value = items
                loadedRevision = revision
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                android.util.Log.e("MyEmojiViewModel", "Failed to load items", e)
                _myEmojiList.value = arrayListOf()
            }
        }
    }

    fun showLongClick(positionSelect: Int) {
        // Keep a pending refresh from clearing a selection the user just started.
        loadJob?.cancel()
        _myEmojiList.value = _myEmojiList.value.mapIndexed { position, item ->
            item.copy(isSelected = position == positionSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    suspend fun deleteItem(context: Context, pathList: ArrayList<String>) {
        MediaHelper.deleteFileByPathNotFlow(pathList)
        PersistenceRepository.deleteMediaItems(context, pathList)
    }

    fun toggleSelect(position: Int) {
        val list = _myEmojiList.value.toMutableList()
        list[position] = list[position].copy(isSelected = !list[position].isSelected, isShowSelection = true)
        _myEmojiList.value = list.toCollection(ArrayList())
    }

    fun selectAll(shouldSelect: Boolean) {
        _myEmojiList.value = _myEmojiList.value.map {
            it.copy(isSelected = shouldSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    fun getPathSelected(): ArrayList<String> {
        return _myEmojiList.value.filter { it.isSelected }.map { it.path }.toCollection(ArrayList())
    }

    fun clearSelection() {
        _myEmojiList.value = _myEmojiList.value.map {
            it.copy(isSelected = false, isShowSelection = false)
        }.toCollection(ArrayList())
    }
}
