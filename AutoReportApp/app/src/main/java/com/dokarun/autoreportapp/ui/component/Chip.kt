package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun Chip(
    modifier: Modifier = Modifier,
    status: ReportStatus,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        color = status.backgroundColor()
    ) {
        Box(
            Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
        ) {
            Text(
                status.label,
                style = AppTheme.typography.labelLarge,
                color = status.contentColor()
            )
        }
    }
}

enum class ReportStatus(
    val label: String,
) {
    PENDING(
        label = "접수대기",
    ),
    PROCESSING(
        label = "접수중",
    ),
    COMPLETED(
        label = "처리완료"
    )
}

@Composable
fun ReportStatus.contentColor(): Color = when (this) {
    ReportStatus.PENDING -> AppTheme.colors.black500
    ReportStatus.PROCESSING -> AppTheme.colors.primary
    ReportStatus.COMPLETED -> AppTheme.colors.green
}

@Composable
fun ReportStatus.backgroundColor(): Color = when (this) {
    ReportStatus.PENDING -> AppTheme.colors.black500.copy(alpha = 0.1f)
    ReportStatus.PROCESSING -> AppTheme.colors.primary.copy(alpha = 0.1f)
    ReportStatus.COMPLETED -> AppTheme.colors.green.copy(alpha = 0.1f)
}

@Preview
@Composable
internal fun ChipPreview() {
    Chip(
        status = ReportStatus.PENDING
    )
}

@Preview
@Composable
internal fun ChipPreview2() {
    Chip(
        status = ReportStatus.PROCESSING
    )
}

@Preview
@Composable
internal fun ChipPreview3() {
    Chip(
        status = ReportStatus.COMPLETED
    )
}