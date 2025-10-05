package com.dokarun.autoreportapp.ui.list

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.Routes

fun NavGraphBuilder.listGraph(
    appState: AppState,
) {
    composable(
        route = Routes.List.ROUTE
    ) {
        val viewModel: ListViewModel = hiltViewModel()

        ListScreen(
            appState = appState,
            viewModel = viewModel
        )
    }
}