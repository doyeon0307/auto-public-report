package com.dokarun.autoreportapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.R
import com.dokarun.autoreportapp.ui.theme.AppTheme

@Composable
internal fun ReportAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(58.dp)
            .background(AppTheme.colors.background)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_left),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable { onBackClick() }
        )
    }
}

@Preview
@Composable
internal fun ReportAppBarPreview() {
    ReportAppBar(
        onBackClick = {}
    )
}
