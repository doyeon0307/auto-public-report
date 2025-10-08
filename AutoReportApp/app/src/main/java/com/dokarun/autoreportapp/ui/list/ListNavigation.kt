package com.dokarun.autoreportapp.ui.list

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dokarun.autoreportapp.AppState
import com.dokarun.autoreportapp.Routes
import com.dokarun.autoreportapp.ui.list.detail.ReportScreen
import com.dokarun.autoreportapp.ui.list.detail.ReportViewModel

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

    composable(
        route = "${Routes.List.REPORT}/{id}",
        arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )
    ) { entry ->
        val id = entry.arguments?.getString("id")?.toIntOrNull() ?: 0
        val viewModel: ReportViewModel = hiltViewModel()

        ReportScreen(
            appState = appState,
            viewModel = viewModel,
            id = id,
        )
    }
}