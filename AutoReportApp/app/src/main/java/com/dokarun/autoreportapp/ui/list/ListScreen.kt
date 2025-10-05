package com.dokarun.autoreportapp.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dokarun.autoreportapp.AppState

@Composable
internal fun ListScreen(
    appState: AppState,
    viewModel: ListViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
}