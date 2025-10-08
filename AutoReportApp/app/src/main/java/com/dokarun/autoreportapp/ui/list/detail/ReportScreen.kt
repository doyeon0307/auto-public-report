package com.dokarun.autoreportapp.ui.list.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.ui.component.ReportAppBar
import com.dokarun.autoreportapp.ui.component.ReportPreview
import com.dokarun.autoreportapp.ui.component.ReportStatus
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun ReportScreen(
    appState: AppState,
    viewModel: ReportViewModel,
    id: Int,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(id) {
        id.let { viewModel.getId(it) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        if (uiState.report == null) {
            ReportAppBar(
                onBackClick = { appState.navController.popBackStack() }
            )
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = AppTheme.colors.primary
            )
        } else {
            Column {
                ReportAppBar(
                    onBackClick = { appState.navController.popBackStack() }
                )
                val report = uiState.report!!
                ReportPreview(
                    dateTime = report.dateTime,
                    status = report.status,
                    title = report.title ?: "",
                    description = report.description ?: "",
                    address = report.address ?: "",
                    detailAddress = report.detailAddress ?: "",
                    showDivider = false
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(uiState.report!!.uriList!!) { uri ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(0.85f)
                                .clip(RoundedCornerShape(12.dp)),
                            model = uri,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}