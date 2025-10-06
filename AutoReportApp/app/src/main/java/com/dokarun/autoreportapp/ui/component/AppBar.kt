package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun AppBar(
    modifier: Modifier = Modifier,
    onSubmit: Boolean = true,
    onTextClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = AppTheme.colors.background,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(58.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "간편 민원접수 도우미",
                    style = AppTheme.typography.headlineSmall,
                    color = AppTheme.colors.primary
                )
                Surface(
                    onClick = onTextClick,
                    color = Color.Transparent
                ) {
                    Text(
                        if (onSubmit) "접수내역 보기" else "접수하기",
                        style = AppTheme.typography.headlineSmall,
                        color = AppTheme.colors.black600,
                    )
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = AppTheme.colors.black100,
            )
        }
    }
}

@Preview(heightDp = 80)
@Composable
internal fun AppBarPreview() {
    AppBar(
        onSubmit = true,
        onTextClick = {}
    )
}

@Preview(heightDp = 80)
@Composable
internal fun AppBarPreview2() {
    AppBar(
        onSubmit = false,
        onTextClick = {}
    )
}