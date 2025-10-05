package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun DimmedLoadingIndicator(
    modifier: Modifier = Modifier,
    content: String = "민원 글을 자동으로 작성하고 있어요...",
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.black600.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(60.dp),
                color = AppTheme.colors.white,
                strokeWidth = 4.dp
            )
            Text(
                content,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.white
            )
        }
    }
}

@Preview
@Composable
internal fun DimmedLoadingIndicatorPreview() {
    DimmedLoadingIndicator()
}