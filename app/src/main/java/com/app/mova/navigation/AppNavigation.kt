package com.app.mova.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.app.mova.feature.onboarding.navigation.ROUTE_ONBOARDING_GRAPH
import com.app.mova.feature.onboarding.navigation.navigateToOnboardingGraph
import com.app.mova.feature.onboarding.navigation.onboardingGraph
import com.app.mova.feature.splash.navigation.ROUTE_SPLASH_SCREEN
import com.app.mova.feature.splash.navigation.splashScreen

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
        onboardingGraph(navController = navController)
    }
}