package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun EmptyView(
    modifier: Modifier = Modifier,
    onTextClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 180.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "아직 접수된 이력이 없어요!",
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.black700
        )
        Text(
            "바로 접수하기",
            style = AppTheme.typography.titleSmall,
            color = AppTheme.colors.black400,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable(true) { onTextClick.invoke() }
        )
    }
}

@Preview
@Composable
internal fun EmptyViewPreview() {
    EmptyView(
        onTextClick = { }
    )
}