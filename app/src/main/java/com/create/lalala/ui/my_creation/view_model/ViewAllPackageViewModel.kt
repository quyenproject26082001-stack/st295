package com.create.lalala.ui.my_creation.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.create.lalala.data.local.PackageRepository
import com.create.lalala.data.model.MyAlbumModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewAllPackageViewModel : ViewModel() {
    private val _itemList = MutableStateFlow<ArrayList<MyAlbumModel>>(arrayListOf())
    val itemList = _itemList.asStateFlow()

    var packageId: String = ""
    var packageName: String = ""

    fun loadPackage(context: Context, id: String) {
        packageId = id
        val packageModel = PackageRepository.getPackages(context).firstOrNull { it.id == id }
        packageName = packageModel?.name.orEmpty()
        _itemList.value = packageModel?.items
            ?.map { MyAlbumModel(it) }
            ?.toCollection(ArrayList())
            ?: arrayListOf()
    }

    fun showLongClick(positionSelect: Int) {
        _itemList.value = _itemList.value.mapIndexed { position, item ->
            item.copy(isSelected = position == positionSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    fun toggleSelect(position: Int) {
        val list = _itemList.value.toMutableList()
        list[position] = list[position].copy(isSelected = !list[position].isSelected, isShowSelection = true)
        _itemList.value = list.toCollection(ArrayList())
    }

    fun selectAll(shouldSelect: Boolean) {
        _itemList.value = _itemList.value.map {
            it.copy(isSelected = shouldSelect, isShowSelection = true)
        }.toCollection(ArrayList())
    }

    fun clearSelection() {
        _itemList.value = _itemList.value.map {
            it.copy(isSelected = false, isShowSelection = false)
        }.toCollection(ArrayList())
    }

    fun getSelectedPaths(): ArrayList<String> {
        return _itemList.value.filter { it.isSelected }.map { it.path }.toCollection(ArrayList())
    }

    fun getAllPaths(): ArrayList<String> {
        return _itemList.value.map { it.path }.toCollection(ArrayList())
    }

    fun deletePaths(context: Context, paths: ArrayList<String>) {
        PackageRepository.deleteItems(context, packageId, paths)
        loadPackage(context, packageId)
    }
}
