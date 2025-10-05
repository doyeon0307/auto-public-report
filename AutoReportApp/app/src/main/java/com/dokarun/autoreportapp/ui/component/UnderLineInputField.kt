package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun UnderLineInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    errorText: String = "",
) {
    var isFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { isFocused = it.isFocused },
        value = value,
        onValueChange = onValueChange,
        textStyle = AppTheme.typography.bodyMedium.copy(color = AppTheme.colors.black600),
        singleLine = true,
        decorationBox = { innerTextField ->
            Column {
                Box (
                    modifier = Modifier.padding(vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    if (value.isEmpty())
                        Text(
                            placeholder,
                            style = AppTheme.typography.bodyMedium,
                            color = AppTheme.colors.black300
                        )
                    innerTextField()
                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = if (errorText.isNotEmpty()) AppTheme.colors.alert else if (isFocused) AppTheme.colors.black400 else AppTheme.colors.black200
                )
            }
        }
    )
}

@Preview(showBackground = true, heightDp = 80)
@Composable
internal fun UnderLineInputFieldPreview() {
    UnderLineInputField(
        value = "",
        onValueChange = {},
        placeholder = "플레이스홀더다"
    )
}