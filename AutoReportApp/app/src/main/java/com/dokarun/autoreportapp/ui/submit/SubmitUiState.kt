package com.dokarun.autoreportapp.ui.submit

import android.net.Uri

data class SubmitUiState(
    val isLoading: Boolean = false,
    val images: List<Uri> = listOf(),
    val address: String = "",
    val detailAddress: String = "",
    val description: String = "",
    val canSubmit: Boolean = false,
    val errorOnAddress: Boolean = false,
    val errorOnDetailAddress: Boolean = false,
    val errorOnDescription: Boolean = false,
)