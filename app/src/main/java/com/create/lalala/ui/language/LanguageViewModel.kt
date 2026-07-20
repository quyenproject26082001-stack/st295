package com.create.lalala.ui.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.create.lalala.core.utils.DataLocal
import com.create.lalala.data.model.LanguageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LanguageViewModel : ViewModel() {

    private val _languageList = MutableStateFlow<List<LanguageModel>>(emptyList())
    val languageList: StateFlow<List<LanguageModel>> = _languageList.asStateFlow()

    private val _codeLang = MutableStateFlow("")
    val codeLang: StateFlow<String> = _codeLang.asStateFlow()

    private val _isFirstLanguage = MutableStateFlow(false)
    val isFirstLanguage: StateFlow<Boolean> = _isFirstLanguage.asStateFlow()

    fun loadLanguages(currentLang: String) {
        viewModelScope.launch {
            val list = DataLocal.getLanguageList().map {
                it.copy(activate = !isFirstLanguage.value && it.code == currentLang)
            }.toMutableList()
            val selectedIndex = list.indexOfFirst { it.code == currentLang }
            if (selectedIndex != -1) {
                list.add(0, list.removeAt(selectedIndex))
            }
            _codeLang.value = currentLang
            _languageList.value = list
        }
    }

    fun selectLanguage(code: String) {
        _codeLang.value = code
        val updatedList = _languageList.value.map {
            it.copy(activate = it.code == code)
        }
        _languageList.value = updatedList
    }

    fun setFirstLanguage(isFirst: Boolean){
        _isFirstLanguage.value = isFirst
    }
}
