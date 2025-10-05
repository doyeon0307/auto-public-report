package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun InputSection(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isRequired: Boolean = true,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
    ) {
        StepHeader(
            title = title,
            description = description,
            isRequired = isRequired
        )
        content()
    }
}

@Preview
@Composable
internal fun InputSectionPreview() {
    InputSection(
        title = "불편사항을 알려주세요",
        description = "개선이 필요한 곳을 사진으로 찍어 등록해주세요",
        isRequired = true,
    ) {
        AppLargeButton(
            isEnabled = true,
            text = "얍 버튼이닷!!",
        )
    }
}