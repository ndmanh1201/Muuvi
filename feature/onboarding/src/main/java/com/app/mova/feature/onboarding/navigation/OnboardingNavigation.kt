package com.app.mova.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.mova.feature.onboarding.screens.GetStartedScreen
import com.app.mova.feature.onboarding.screens.WelcomeScreen

const val ROUTE_ONBOARDING_GRAPH = "onboarding"
const val ROUTE_WELCOME_SCREEN = "welcome"
const val ROUTE_GET_STARTED = "get-started"

fun NavGraphBuilder.onboardingGraph(
    navController: NavHostController,
    onPasswordSignInClick: () -> Unit,
) {
    navigation(startDestination = ROUTE_WELCOME_SCREEN, route = ROUTE_ONBOARDING_GRAPH) {
        welcomeScreen(
            onButtonClick = navController::navigateToGetStartedScreen
        )
        getStartedScreen(
            onBackClick = navController::popBackStack,
            onFacebookClick = {},
            onGoogleClick = {},
            onPasswordSignInClick = onPasswordSignInClick,
            onSignUpClick = {},
        )
    }
}

fun NavGraphBuilder.welcomeScreen(
    onButtonClick: () -> Unit,
) {
    composable(route = ROUTE_WELCOME_SCREEN) {
        WelcomeScreen(
            onButtonClick = onButtonClick,
        )
    }
}

fun NavGraphBuilder.getStartedScreen(
    onBackClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onPasswordSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    composable(route = ROUTE_GET_STARTED) {
        GetStartedScreen(
            onBackClick = onBackClick,
            onFacebookClick = onFacebookClick,
            onGoogleClick = onGoogleClick,
            onPasswordSignInClick = onPasswordSignInClick,
            onSignUpClick = onSignUpClick,
        )
    }
}

fun NavHostController.navigateToGetStartedScreen() {
    this.navigate(ROUTE_GET_STARTED)
}

fun NavHostController.navigateToOnboardingGraph(
    navOptions: NavOptions? = null,
) {
    this.navigate(ROUTE_ONBOARDING_GRAPH, navOptions)
}
