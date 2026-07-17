package com.create.lalala.ui.my_creation.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.create.lalala.core.helper.MediaHelper
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.data.local.PersistenceRepository
import com.create.lalala.data.model.MyAlbumModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyEmojiViewModel : ViewModel() {
    private val _myEmojiList = MutableStateFlow<ArrayList<MyAlbumModel>>(arrayListOf())
    val myEmojiList = _myEmojiList.asStateFlow()

    fun loadMyEmoji(context: Context) {
        val imageList = MediaHelper.getImageInternal(context, ValueKey.EMOJI_ALBUM)
        _myEmojiList.value = imageList.map { MyAlbumModel(it) }.toCollection(ArrayList())
    }

    fun showLongClick(positionSelect: Int) {
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
