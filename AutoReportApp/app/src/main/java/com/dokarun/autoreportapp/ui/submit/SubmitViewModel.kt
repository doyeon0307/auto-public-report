package com.dokarun.autoreportapp.ui.submit

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.dokarun.autoreportapp.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SubmitViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(SubmitUiState())
    val uiState: StateFlow<SubmitUiState> = _uiState.asStateFlow()

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

    fun onSubmit() {}
}