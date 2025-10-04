package com.dokarun.autoreportapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    background: Color = Color(0xFFFEFEFE),
    white: Color = Color(0xFFFFFFFF),
    alert: Color = Color(0xFFE45656),
    primary: Color = Color(0xFF4962C7),
    green: Color = Color(0xFF2A9D47),
    black100: Color = Color(0xFFE0E0E0),
    black200: Color = Color(0xFFB8B8B8),
    black300: Color = Color(0xFF929292),
    black400: Color = Color(0xFF6E6E6E),
    black500: Color = Color(0xFF4B4B4B),
    black600: Color = Color(0xFF2B2B2B),
    black700: Color = Color(0xFF111111),
) {
    var background by mutableStateOf(background)
        private set
    var white by mutableStateOf(white)
        private set
    var alert by mutableStateOf(alert)
        private set
    var primary by mutableStateOf(primary)
        private set
    var green by mutableStateOf(green)
        private set
    var black100 by mutableStateOf(black100)
        private set
    var black200 by mutableStateOf(black200)
        private set
    var black300 by mutableStateOf(black300)
        private set
    var black400 by mutableStateOf(black400)
        private set
    var black500 by mutableStateOf(black500)
        private set
    var black600 by mutableStateOf(black600)
        private set
    var black700 by mutableStateOf(black700)
        private set

    fun copy(
        background: Color = this.background,
        white: Color = this.white,
        alert: Color = this.alert,
        primary: Color = this.primary,
        green: Color = this.green,
        black100: Color = this.black100,
        black200: Color = this.black200,
        black300: Color = this.black300,
        black400: Color = this.black400,
        black500: Color = this.black500,
        black600: Color = this.black600,
        black700: Color = this.black700,
    ): AppColors {
        return AppColors(
            background = background,
            white = white,
            alert = alert,
            primary = primary,
            green = green,
            black100 = black100,
            black200 = black200,
            black300 = black300,
            black400 = black400,
            black500 = black500,
            black600 = black600,
            black700 = black700,
        )
    }

    fun updateColorFrom(other: AppColors) {
        background = other.background
        white = other.white
        alert = other.alert
        primary = other.primary
        green = other.green
        black100 = other.black100
        black200 = other.black200
        black300 = other.black300
        black400 = other.black400
        black500 = other.black500
        black600 = other.black600
        black700 = other.black700
    }
}

val LocalColors = staticCompositionLocalOf { AppColors() }