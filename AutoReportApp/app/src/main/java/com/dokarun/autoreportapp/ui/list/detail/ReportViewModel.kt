package com.dokarun.autoreportapp.ui.list.detail

import com.dokarun.autoreportapp.ui.data.ReportDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(
    private val reportDao: ReportDao,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ReportUiState())
    val uiState: StateFlow<ReportUiState> = _uiState.asStateFlow()

    fun getId(id: Int) {
        _uiState.value = _uiState.value.copy(id = id)
        getReport()
    }

    fun getReport() {
        if (_uiState.value.id == null) return

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                report = reportDao.findById(_uiState.value.id!!)
            )
        }
    }
}