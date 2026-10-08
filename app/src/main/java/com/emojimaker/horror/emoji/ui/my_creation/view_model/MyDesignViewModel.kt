package com.emojimaker.horor.emoji.ui.my_creation.view_model

import android.app.Activity
import android.content.Context
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.CancellationException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emojimaker.horor.emoji.core.helper.MediaHelper
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import com.emojimaker.horor.emoji.data.model.MyAlbumModel
import com.emojimaker.horor.emoji.data.model.custom.SuggestionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MyDesignViewModel : ViewModel() {
    private val _myDesignList = MutableStateFlow<ArrayList<MyAlbumModel>>(arrayListOf())
    val myDesignList = _myDesignList.asStateFlow()
    private val _isLastItem = MutableStateFlow<Boolean>(false)
    val isLastItem: StateFlow<Boolean> = _isLastItem

    private var loadJob: Job? = null
    private var loadedRevision = -1L
    private var loadingRevision = -1L

    fun loadMyDesign(context: Context, force: Boolean = false) {
        val revision = PersistenceRepository.creationRevision.value
        if (!force && (loadedRevision == revision || (loadJob?.isActive == true && loadingRevision == revision))) return
        loadingRevision = revision
        val appContext = context.applicationContext
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            try {
                val items = withContext(Dispatchers.IO) {
                    PersistenceRepository.getAlbumPathsAsync(appContext, ValueKey.DOWNLOAD_ALBUM)
                        .map { MyAlbumModel(it) }.toCollection(ArrayList())
                }
                _myDesignList.value = items
                loadedRevision = revision
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                android.util.Log.e("MyDesignViewModel", "Failed to load items", e)
                _myDesignList.value = arrayListOf()
            }
            checkLastItem()
        }
    }

    fun showLongClick(positionSelect: Int) {
        // Keep a pending refresh from clearing a selection the user just started.
        loadJob?.cancel()
        _myDesignList.value = _myDesignList.value.mapIndexed { position, item ->
            item.copy(isSelected = position == positionSelect, isShowSelection = true)
        }.toCollection(ArrayList())
        checkLastItem()
    }

    private fun checkLastItem() {
        _isLastItem.value = _myDesignList.value.any { !it.isSelected }
    }

    suspend fun deleteItem(context: Context, pathList: ArrayList<String>){
        MediaHelper.deleteFileByPathNotFlow(pathList)
        PersistenceRepository.deleteMediaItems(context, pathList)
    }

    fun toggleSelect(position: Int) {
        val list = _myDesignList.value.toMutableList()
        list[position] = list[position].copy(isSelected = !list[position].isSelected, isShowSelection = true)
        _myDesignList.value = list.toCollection(ArrayList())
        checkLastItem()
    }

    fun selectAll(shouldSelect: Boolean) {
        _myDesignList.value = _myDesignList.value.map {
            it.copy(isSelected = shouldSelect, isShowSelection = true)
        }.toCollection(ArrayList())
        checkLastItem()
    }

    fun getPathSelected() : ArrayList<String>{
        return _myDesignList.value.filter { it.isSelected }.map { it.path }.toCollection(ArrayList())
    }

    fun clearSelection() {
        _myDesignList.value = _myDesignList.value.map {
            it.copy(isSelected = false, isShowSelection = false)
        }.toCollection(ArrayList())
        checkLastItem()
    }
}
