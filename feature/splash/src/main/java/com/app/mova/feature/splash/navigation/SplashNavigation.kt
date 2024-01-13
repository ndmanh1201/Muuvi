package com.app.mova.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.mova.feature.splash.SplashScreen

const val ROUTE_SPLASH_SCREEN = "splash"

fun NavGraphBuilder.splashScreen() {
    composable(route = ROUTE_SPLASH_SCREEN) {
        SplashScreen()
    }
}
