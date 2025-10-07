package com.dokarun.autoreportapp.ui.submit

import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.dokarun.autoreportapp.AppState

@SuppressLint("JavascriptInterface", "SetJavaScriptEnabled")
@Composable
internal fun ZipWebView(
    appState: AppState,
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true

                addJavascriptInterface(object {
                    @JavascriptInterface
                    fun processDATA(roadAddress: String, jibunAddress: String) {
                        (context as? ComponentActivity)?.runOnUiThread {
                            appState.navController.previousBackStackEntry
                                ?.savedStateHandle
                                ?.set("address", Pair(roadAddress, jibunAddress))
                            appState.navController.popBackStack()
                        }
                    }
                }, "Android")

                loadUrl("https://ziphosting-8a4a2.web.app/")
            }
        },
        modifier = Modifier.fillMaxSize()
    )

    BackHandler {
        appState.navController.popBackStack()
    }
}