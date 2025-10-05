package com.dokarun.autoreportapp.ui.submit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dokarun.autoreportapp.AppState

@Composable
internal fun SubmitScreen(
    appState: AppState,
    viewModel: SubmitViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
}

