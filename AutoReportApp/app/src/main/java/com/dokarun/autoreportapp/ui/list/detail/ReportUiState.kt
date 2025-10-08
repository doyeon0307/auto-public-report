package com.dokarun.autoreportapp.ui.list.detail

import com.dokarun.autoreportapp.ui.data.Report

data class ReportUiState(
    val isLoading: Boolean = false,
    val id: Int? = null,
    val report: Report? = null,
)