package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun ReportPreview(
    modifier: Modifier = Modifier,
    dateTime: String,
    status: ReportStatus,
    title: String,
    description: String,
    address: String,
    detailAddress: String,
    onClick: (() -> Unit)? = null,
    showDivider: Boolean = true,
) {
    Column(
        modifier = modifier.clickable(true) { onClick?.invoke() }
    ) {
        Column(
            modifier = modifier.padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    dateTime,
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.black400
                )
                Chip(
                    status = status
                )
            }
            Spacer(Modifier.height(16.dp))
            Text(
                title,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.black500
            )
            if (description.isNotEmpty()) {
                Spacer(Modifier.height(4.dp))
                Text(
                    description,
                    style = AppTheme.typography.titleSmall,
                    color = AppTheme.colors.black500
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                address,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.black500
            )
            Spacer(Modifier.height(2.dp))
            Text(
                detailAddress,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.black500
            )
        }
        if (showDivider) {
            HorizontalDivider(
                thickness = 1.dp,
                color = AppTheme.colors.black100
            )
        }
    }
}

@Preview(heightDp = 200)
@Composable
internal fun ReportPreviewPreview() {
    ReportPreview(
        dateTime = "2025.09.22 16:33 ",
        status = ReportStatus.PROCESSING,
        title = "도로가 깨져 위험함",
        description = "넘어질 뻔해서 빠른 조치 부탁드려요.",
        address = "경기도 용인시 기흥구 덕영대로 1732",
        detailAddress = "전자정보 대학관 올라가는 길"
    )
}

@Preview(heightDp = 300)
@Composable
internal fun ReportPreviewPreview2() {
    ReportPreview(
        dateTime = "2025.09.22 16:33 ",
        status = ReportStatus.PROCESSING,
        title = "도로가 깨져 위험함 도로가 깨져 위험함 도로가 깨져 위험함 도로가 깨져 위험함 도로가 깨져 위험함 도로가 깨져 위험함",
        description = "",
        address = "경기도 용인시 기흥구 덕영대로 1732 경기도 용인시 기흥구 덕영대로 1732 경기도 용인시 기흥구 덕영대로 1732 경기도 용인시 기흥구 덕영대로 1732 경기도 용인시 기흥구 덕영대로 1732",
        detailAddress = "전자정보 대학관 올라가는 길 전자정보 대학관 올라가는 길 전자정보 대학관 올라가는 길 전자정보 대학관 올라가는 길 전자정보 대학관 올라가는 길"
    )
}