package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
internal fun LargeButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean,
    text: String,
    contentColor: Color = AppTheme.colors.white,
    backgroundColor: Color = AppTheme.colors.primary,
    disabledBackgroundColor: Color = AppTheme.colors.primary.copy(alpha = 0.4f),
) {
    Surface(
        modifier = modifier,
        color = if (isEnabled) backgroundColor else disabledBackgroundColor,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text,
                color = contentColor,
                style = AppTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
internal fun LargeButtonPreview() {
    LargeButton(
        isEnabled = true,
        text = "접수하기"
    )
}

@Preview
@Composable
internal fun LargeButtonPreview2() {
    LargeButton(
        isEnabled = false,
        text = "접수하기"
    )
}