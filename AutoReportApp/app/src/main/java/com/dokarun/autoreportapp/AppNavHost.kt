package com.dokarun.autoreportapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.dokarun.autoreportapp.ui.list.listGraph
import com.dokarun.autoreportapp.ui.submit.submitGraph

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(appState: AppState) {
    val navController = appState.navController

    Scaffold(
        modifier = Modifier.statusBarsPadding()
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.Submit.ROUTE,
            modifier = Modifier.padding(paddingValues)
        ) {
            submitGraph(appState)
            listGraph(appState)
        }
    }
}