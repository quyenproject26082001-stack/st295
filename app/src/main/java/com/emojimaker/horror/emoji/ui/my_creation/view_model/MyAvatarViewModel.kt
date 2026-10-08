package com.emojimaker.horor.emoji.ui.my_creation.view_model

import android.app.Activity
import android.content.Context
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.CancellationException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.base.BaseActivity
import com.emojimaker.horor.emoji.core.helper.InternetHelper
import com.emojimaker.horor.emoji.core.helper.MediaHelper
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import com.emojimaker.horor.emoji.data.model.MyAlbumModel
import com.emojimaker.horor.emoji.data.model.custom.CustomizeModel
import com.emojimaker.horor.emoji.data.model.custom.MakerEditCompatibility
import com.emojimaker.horor.emoji.data.model.custom.MakerEditCompatibilityChecker
import com.emojimaker.horor.emoji.data.model.custom.SuggestionModel
import com.google.gson.Gson
import com.emojimaker.horor.emoji.ui.my_creation.MyCreationActivity
import com.emojimaker.horor.emoji.ui.random_character.RandomCharacterActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MyAvatarViewModel : ViewModel() {
    private val _myAvatarList = MutableStateFlow<ArrayList<MyAlbumModel>>(arrayListOf())
    val myAvatarList = _myAvatarList.asStateFlow()
    private val _isLastItem = MutableStateFlow<Boolean>(false)
    val isLastItem: StateFlow<Boolean> = _isLastItem


    var isApi: Boolean = false
    var positionCharacter = -1
    var editModel = SuggestionModel()

    private var loadJob: Job? = null
    private var loadedRevision = -1L
    private var loadingRevision = -1L

    fun loadMyAvatar(context: Context, force: Boolean = false) {
        val revision = PersistenceRepository.creationRevision.value
        if (!force && (loadedRevision == revision || (loadJob?.isActive == true && loadingRevision == revision))) return
        loadingRevision = revision
        val appContext = context.applicationContext
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            try {
                val items = withContext(Dispatchers.IO) {
                    MediaHelper.readListFromFileAsync<SuggestionModel>(appContext, ValueKey.EDIT_FILE_INTERNAL)
                        .map { MyAlbumModel(it.pathInternalEdit) }.toCollection(ArrayList())
                }
                _myAvatarList.value = items
                loadedRevision = revision
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                android.util.Log.e("MyAvatarViewModel", "Failed to load items", e)
                _myAvatarList.value = arrayListOf()
            }
            checkLastItem()
        }
    }

    private fun checkLastItem() {
        _isLastItem.value = _myAvatarList.value.any { !it.isSelected }
    }

    suspend fun deleteItem(context: Context, pathList: ArrayList<String>) {

        val originList = MediaHelper
            .readListFromFile<SuggestionModel>(context, ValueKey.EDIT_FILE_INTERNAL)
            .toCollection(ArrayList())

        val editDeleteList = originList.filter { it.pathInternalEdit in pathList }
        val myAvatarDeleteList = _myAvatarList.value.filter { it.path in pathList }

        // Update origin file
        val newOriginList = ArrayList(originList).apply {
            removeAll(editDeleteList)
        }
        MediaHelper.writeListToFile(context, ValueKey.EDIT_FILE_INTERNAL, newOriginList)

        // Update StateFlow properly (important!)
        val newAvatarList = ArrayList(_myAvatarList.value).apply {
            removeAll(myAvatarDeleteList)
        }

        _myAvatarList.value = newAvatarList
    }

    suspend fun editItem(
        context: Context,
        pathInternal: String,
        allData: ArrayList<CustomizeModel>
    ): MakerEditCompatibility {
        positionCharacter = -1
        isApi = false
        if (allData.isEmpty()) return MakerEditCompatibility.DATA_UNAVAILABLE

        val originList = runCatching {
            MediaHelper.readListFromFile<SuggestionModel>(context, ValueKey.EDIT_FILE_INTERNAL)
        }.getOrElse { return MakerEditCompatibility.INVALID_SAVED_DATA }
        val savedModel = runCatching {
            originList.firstOrNull { it.pathInternalEdit == pathInternal }
        }.getOrElse { return MakerEditCompatibility.INVALID_SAVED_DATA }
            ?: return MakerEditCompatibility.CREATION_NOT_FOUND

        val exactAvatarPosition = allData.indexOfFirst { it.avatar == savedModel.avatarPath }
        positionCharacter = if (exactAvatarPosition >= 0) exactAvatarPosition else {
            val sourceName = savedModel.sourceDataName.orEmpty()
            if (sourceName.isBlank()) -1 else allData.indexOfFirst { it.dataName == sourceName }
        }
        if (positionCharacter < 0) return MakerEditCompatibility.CHARACTER_NOT_FOUND

        val currentCharacter = allData[positionCharacter]
        val compatibility = runCatching {
            MakerEditCompatibilityChecker.check(savedModel, currentCharacter)
        }.getOrElse { MakerEditCompatibility.INVALID_SAVED_DATA }
        if (compatibility != MakerEditCompatibility.COMPATIBLE) return compatibility

        val stored = runCatching {
            PersistenceRepository.writeModelJson(
                context,
                ValueKey.SUGGESTION_FILE_INTERNAL,
                Gson().toJson(savedModel)
            )
        }.isSuccess
        if (!stored) return MakerEditCompatibility.INVALID_SAVED_DATA

        editModel = savedModel
        isApi = currentCharacter.isFromAPI
        return MakerEditCompatibility.COMPATIBLE
    }

    fun checkDataInternet(context: BaseActivity<*>, action: (() -> Unit)) {
        if (!isApi) {
            action.invoke()
            return
        }
        InternetHelper.checkInternet(context) { result ->
            if (result == HandleState.SUCCESS) {
                action.invoke()
            } else {
                // Show No Internet dialog
                val dialog = com.emojimaker.horor.emoji.dialog.YesNoDialog(
                    context,
                    com.emojimaker.horor.emoji.R.string.no_internet,
                    com.emojimaker.horor.emoji.R.string.please_check_your_internet,
                    isError = true
                )
                dialog.show()
                dialog.onYesClick = {
                    dialog.dismiss()
                }
            }
        }
    }

    fun showLongClick(positionSelect: Int) {
        // Keep a pending refresh from clearing a selection the user just started.
        loadJob?.cancel()
        _myAvatarList.value = _myAvatarList.value.mapIndexed { position, item ->
            item.copy(isSelected = position == positionSelect, isShowSelection = true)
        }.toCollection(ArrayList())
        checkLastItem()
    }

    fun selectAll(shouldSelect: Boolean) {
        _myAvatarList.value = _myAvatarList.value.map {
            it.copy(isSelected = shouldSelect, isShowSelection = true)
        }.toCollection(ArrayList())
        checkLastItem()
    }

    fun toggleSelect(position: Int) {
        val list = _myAvatarList.value.toMutableList()
        list[position] = list[position].copy(isSelected = !list[position].isSelected, isShowSelection = true)
        _myAvatarList.value = list.toCollection(ArrayList())
        checkLastItem()
    }

    fun getPathSelected() : ArrayList<String>{
        return _myAvatarList.value
            .filter { it.isSelected }
            .map { it.path }
            .toCollection(ArrayList())
    }

    fun clearSelection() {
        _myAvatarList.value = _myAvatarList.value.map {
            it.copy(isSelected = false, isShowSelection = false)
        }.toCollection(ArrayList())
        checkLastItem()
    }
}
