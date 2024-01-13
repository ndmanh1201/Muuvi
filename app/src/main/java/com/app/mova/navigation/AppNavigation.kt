package com.app.mova.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.mova.feature.splash.navigation.ROUTE_SPLASH_SCREEN
import com.app.mova.feature.splash.navigation.splashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTE_SPLASH_SCREEN) {
        splashScreen()
    }
}