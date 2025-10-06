package com.dokarun.autoreportapp.ui.component

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.autoreportapp.R
import com.dokarun.autoreportapp.ui.theme.AppTheme
import gun0912.tedimagepicker.builder.TedImagePicker

@Composable
internal fun ImagePickerButton(
    modifier: Modifier = Modifier,
    onImagesSelected: (List<Uri>) -> Unit,
) {
    val context = LocalContext.current

    Surface(
        modifier = modifier,
        color = AppTheme.colors.background,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp,
            color = AppTheme.colors.black200
        ),
        onClick = {
            TedImagePicker.with(context)
                .startMultiImage { uriList ->
                    onImagesSelected(uriList)
                }
        }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_gallery),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
internal fun ImagePickerButtonPreview() {
    ImagePickerButton(
        modifier = Modifier
            .width(160.dp)
            .height(190.dp),
        onImagesSelected = {}
    )
}