package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun AddressDisplayField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() },
    ) {
        Text(
            if (value.isEmpty()) placeholder else value,
            style = AppTheme.typography.bodyMedium,
            color = if (value.isEmpty()) AppTheme.colors.black300 else AppTheme.colors.black600,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = if (value.isEmpty()) AppTheme.colors.black200 else AppTheme.colors.black400
        )
    }
}

@Preview
@Composable
internal fun AddressDisplayFieldPreview() {
    AddressDisplayField(
        value = "아나",
        placeholder = "아아아아"
    )
}

@Preview
@Composable
internal fun AddressDisplayFieldPreview2() {
    AddressDisplayField(
        value = "",
        placeholder = "아아아아"
    )
}