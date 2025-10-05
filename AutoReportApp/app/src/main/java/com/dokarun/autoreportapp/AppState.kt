package com.dokarun.autoreportapp

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    scope: CoroutineScope = rememberCoroutineScope(),
): AppState {
    return remember(navController, snackbarHostState, scope) {
        AppState(navController, snackbarHostState, scope)
    }
}

class AppState(
    val navController: NavHostController,
    val snackbarHostState: SnackbarHostState,
    val scope: CoroutineScope,
) {
    fun showSnackBar(message: String) {
        scope.launch {
            snackbarHostState.showSnackbar(message)
        }
    }
}
