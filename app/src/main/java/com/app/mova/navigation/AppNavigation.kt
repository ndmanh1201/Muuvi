package com.app.muuvi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.app.muuvi.feature.auth.navigation.authNavigationGraph
import com.app.muuvi.feature.auth.navigation.navigateToAuthNavigationGraph
import com.app.muuvi.feature.onboarding.navigation.navigateToOnboardingGraph
import com.app.muuvi.feature.onboarding.navigation.onboardingGraph
import com.app.muuvi.feature.splash.navigation.ROUTE_SPLASH_SCREEN
import com.app.muuvi.feature.splash.navigation.splashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ROUTE_SPLASH_SCREEN) {
        splashScreen(onSplashFinished = {
            navController.navigateToOnboardingGraph(
                navOptions = navOptions {
                    popUpTo(ROUTE_SPLASH_SCREEN) {
                        inclusive = true
                    }
                }
            )
        })
        onboardingGraph(
            navController = navController,
            onPasswordSignInClick = navController::navigateToAuthNavigationGraph,
        )
        authNavigationGraph(
            navController = navController,
        )
    }
}