package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun StepHeader(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isRequired: Boolean = true,
) {
    Column(
        modifier = modifier.padding(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row {
            Text(
                title,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.black700
            )
            if (isRequired)
                Text(
                    "*",
                    style = AppTheme.typography.titleMedium,
                    color = AppTheme.colors.alert
                )
        }
        Text(
            description,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.black400
        )
    }
}

@Preview
@Composable
internal fun StepHeaderPreview() {
    StepHeader(
        title = "불편사항을 알려주세요",
        description = "개선이 필요한 곳을 사진으로 찍어 등록해주세요",
    )
}