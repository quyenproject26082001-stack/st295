package com.emojimaker.horor.emoji.ui.my_creation.view_model

import com.emojimaker.horor.emoji.data.local.PersistenceRepository
import android.content.Context
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CancellationException
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.emojimaker.horor.emoji.data.local.PackageRepository
import com.emojimaker.horor.emoji.data.model.PackageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PackageViewModel : ViewModel() {
    private val _packageList = MutableStateFlow<ArrayList<PackageModel>>(arrayListOf())
    val packageList = _packageList.asStateFlow()

    private var loadJob: Job? = null
    private var loadedRevision = -1L
    private var loadingRevision = -1L

    fun loadPackages(context: Context, force: Boolean = false) {
        val revision = PersistenceRepository.creationRevision.value
        if (!force && (loadedRevision == revision || (loadJob?.isActive == true && loadingRevision == revision))) return
        loadingRevision = revision
        val appContext = context.applicationContext
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            try {
                val items = withContext(Dispatchers.IO) {
                    PackageRepository.getPackagesAsync(appContext)
                }
                _packageList.value = items
                loadedRevision = revision
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                android.util.Log.e("PackageViewModel", "Failed to load items", e)
                _packageList.value = arrayListOf()
            }
        }
    }

    fun showLongClick(positionSelect: Int) {
        // Keep a pending refresh from clearing a selection the user just started.
        loadJob?.cancel()
        _packageList.value = _packageList.value.mapIndexed { position, item ->
            item.copy(isSelected = position == positionSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    fun toggleSelect(position: Int) {
        val list = _packageList.value.toMutableList()
        list[position] = list[position].copy(isSelected = !list[position].isSelected, isShowSelection = true)
        _packageList.value = list.toCollection(ArrayList())
    }

    fun selectAll(shouldSelect: Boolean) {
        _packageList.value = _packageList.value.map {
            it.copy(isSelected = shouldSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    fun clearSelection() {
        _packageList.value = _packageList.value.map {
            it.copy(isSelected = false, isShowSelection = false)
        }.toCollection(ArrayList())
    }

    fun getSelectedIds(): ArrayList<String> {
        return _packageList.value.filter { it.isSelected }.map { it.id }.toCollection(ArrayList())
    }

    fun getAllIds(): ArrayList<String> {
        return _packageList.value.map { it.id }.toCollection(ArrayList())
    }

    fun deleteSelected(context: Context) {
        PackageRepository.deletePackages(context, getSelectedIds())
        loadPackages(context)
    }
}
