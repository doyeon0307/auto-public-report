package com.dokarun.autoreportapp.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.ui.component.AppBar
import com.dokarun.autoreportapp.ui.component.EmptyView
import com.dokarun.autoreportapp.ui.component.ReportPreview
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun ListScreen(
    appState: AppState,
    viewModel: ListViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        Column {
            AppBar(
                onSubmit = false,
                onTextClick = { appState.navController.popBackStack() }
            )
            if (uiState.reports.isEmpty()) {
                EmptyView { appState.navController.popBackStack() }
            } else {
                LazyColumn {
                    items(uiState.reports) { report ->
                        ReportPreview(
                            dateTime = report.dateTime,
                            status = report.status,
                            title = report.title ?: "",
                            description = report.description ?: "",
                            address = report.address ?: "",
                            detailAddress = report.detailAddress ?: "",
                            onClick = { appState.navController.navigate("reportScreen/${report.id}") }
                        )
                    }
                }
            }
        }
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = AppTheme.colors.primary
            )
        }
    }
}