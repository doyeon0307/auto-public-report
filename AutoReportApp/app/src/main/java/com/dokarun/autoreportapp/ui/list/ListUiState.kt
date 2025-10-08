package com.dokarun.autoreportapp.ui.list

import com.dokarun.autoreportapp.ui.data.Report

data class ListUiState(
    val isLoading: Boolean = false,
    val reports: List<Report> = listOf()
)