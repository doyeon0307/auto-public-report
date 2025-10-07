package com.dokarun.autoreportapp.ui.submit

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dokarun.autoreportapp.TAG
import com.dokarun.autoreportapp.ui.data.Report
import com.dokarun.autoreportapp.ui.data.ReportDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubmitViewModel @Inject constructor(
    private val reportDao: ReportDao,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SubmitUiState())
    val uiState: StateFlow<SubmitUiState> = _uiState.asStateFlow()

    fun refreshScreen() {
        _uiState.value = _uiState.value.copy(
            images = listOf(),
            address = "",
            detailAddress = "",
            description = "",
            canSubmit = false,
        )
    }

    fun onAddressChanged(newText: String) {
        _uiState.value = _uiState.value.copy(address = newText)
        checkCanSubmit()
    }

    fun onDetailAddressChanged(newText: String) {
        _uiState.value = _uiState.value.copy(detailAddress = newText)
        checkCanSubmit()
    }

    fun onDescriptionChanged(newText: String) {
        _uiState.value = _uiState.value.copy(description = newText)
        checkCanSubmit()
    }

    fun checkCanSubmit() {
        _uiState.value =
            _uiState.value.copy(
                canSubmit = _uiState.value.images.isNotEmpty() and _uiState.value.address.isNotEmpty() and _uiState.value.detailAddress.isNotEmpty()
            )
    }

    fun onImagesSelected(uriList: List<Uri>) {
        _uiState.value = _uiState.value.copy(
            images = uriList
        )
        Log.d(TAG, "이미지 가져옴: ${_uiState.value.images}")
    }

    fun onSubmit() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        Log.d(TAG, "🚀 접수 시작")
        // 캡셔닝 후 title로 넣어줌
        viewModelScope.launch {
            try {
                reportDao.insert(
                    Report(
                        title = "임시 제목",
                        description = _uiState.value.description,
                        address = _uiState.value.address,
                        detailAddress = _uiState.value.detailAddress,
                        uriList = _uiState.value.images
                    )
                )
                Log.d(TAG, "✏️ 접수 완료")
                refreshScreen()
            } catch (e: Exception) {
                Log.e(TAG, "❌ 접수 실패", e)
            } finally {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}