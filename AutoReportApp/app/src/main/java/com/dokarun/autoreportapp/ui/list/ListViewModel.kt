package com.dokarun.autoreportapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokarun.autoreportapp.ui.data.ReportDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val reportDao: ReportDao,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ListUiState())
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    init {
        getReports()
    }

    private fun getReports() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            val reports = reportDao.getAll()
            _uiState.value = _uiState.value.copy(reports = reports)
        }
        _uiState.value = _uiState.value.copy(isLoading = false)
    }
}