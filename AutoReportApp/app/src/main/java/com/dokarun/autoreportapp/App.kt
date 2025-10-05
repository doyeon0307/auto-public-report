package com.dokarun.autoreportapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG: String = "APP"

@HiltAndroidApp
class App : Application()