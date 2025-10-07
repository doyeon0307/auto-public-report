package com.dokarun.autoreportapp.ui.submit

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.Routes

fun NavGraphBuilder.submitGraph(
    appState: AppState,
) {
    composable(
        route = Routes.Submit.ROUTE
    ) {
        val viewModel: SubmitViewModel = hiltViewModel()

        SubmitScreen(
            appState = appState,
            viewModel = viewModel
        )
    }

    composable(
        route = Routes.Submit.ZIP_WEB_VIEW
    ) {
        ZipWebView(
            appState = appState
        )
    }
}