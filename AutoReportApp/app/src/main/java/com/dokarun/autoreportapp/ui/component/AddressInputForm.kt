package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun AddressInputForm(
    modifier: Modifier = Modifier,
    title: String,
    message: String? = null,
    onMessageClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.width(60.dp)
            ) {
                Text(
                    title,
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.black400
                )
            }
            content()
        }
        if (message != null) {
            Text(
                message,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.primary,
                modifier = Modifier
                    .padding(top = 8.dp, start = 60.dp)
                    .clickable(true) { onMessageClick?.invoke() },
            )
        }
    }
}