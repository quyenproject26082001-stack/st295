package com.create.lalala.ui.view

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.create.lalala.core.extensions.shareImagesPaths
import com.create.lalala.core.helper.MediaHelper
import com.create.lalala.core.utils.key.ValueKey
import com.create.lalala.core.utils.state.HandleState
import com.create.lalala.data.local.PersistenceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ViewViewModel : ViewModel() {
    private val _pathInternal = MutableStateFlow<String>("")
    val pathInternal: StateFlow<String> = _pathInternal.asStateFlow()

    var statusFrom = ValueKey.AVATAR_TYPE

    fun setPath(path: String) {
        _pathInternal.value = path
    }

    fun deleteFile(context: Context, path: String): Flow<HandleState> = flow {
        if (statusFrom == ValueKey.MY_DESIGN_TYPE || statusFrom == ValueKey.PRIDE_OVERLAY_TYPE) {
            MediaHelper.deleteFileByPath(arrayListOf(path)).collect { state ->
                if (state == HandleState.SUCCESS) {
                    PersistenceRepository.deleteMediaItems(context, listOf(path))
                }
                emit(state)
            }
        } else {
            emit(HandleState.LOADING)
            val result = try {
                if (PersistenceRepository.deleteSavedAvatars(context, listOf(path))) {
                    HandleState.SUCCESS
                } else {
                    HandleState.FAIL
                }
            } catch (e: Exception) {
                Log.e("nbhieu", "deleteFile: $e")
                HandleState.FAIL
            }
            emit(result)
        }
    }.flowOn(Dispatchers.IO)

    fun shareFiles(context: Activity) {
        viewModelScope.launch {
            context.shareImagesPaths(arrayListOf(_pathInternal.value))
        }
    }

    fun downloadFiles(context: Activity): Flow<HandleState> = flow {
        emitAll(
            MediaHelper.downloadPartsToExternal(
                context, arrayListOf(_pathInternal.value)
            )
        )
    }.flowOn(Dispatchers.IO)

    fun updateStatusFrom(status: Int) {
        statusFrom = status
    }
}
