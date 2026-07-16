package com.create.lalala.ui.my_creation.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.create.lalala.data.local.PackageRepository
import com.create.lalala.data.model.PackageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PackageViewModel : ViewModel() {
    private val _packageList = MutableStateFlow<ArrayList<PackageModel>>(arrayListOf())
    val packageList = _packageList.asStateFlow()

    fun loadPackages(context: Context) {
        _packageList.value = PackageRepository.getPackages(context)
    }

    fun showLongClick(positionSelect: Int) {
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
