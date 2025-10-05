package com.dokarun.autoreportapp.ui.submit

import androidx.lifecycle.ViewModel
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
}