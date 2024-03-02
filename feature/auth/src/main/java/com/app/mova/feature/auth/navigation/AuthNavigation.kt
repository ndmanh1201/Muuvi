package com.app.muuvi.feature.auth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.muuvi.feature.auth.screens.SignInScreen
import com.app.muuvi.feature.auth.viewmodel.SignInViewModel

const val ROUTE_AUTH_NAVIGATION_GRAPH = "auth-navigation-graph"
const val ROUTE_SIGN_IN_SCREEN = "sign-in"

fun NavHostController.navigateToAuthNavigationGraph(navOptions: NavOptions? = null) {
    this.navigate(ROUTE_AUTH_NAVIGATION_GRAPH, navOptions)
}

fun NavGraphBuilder.authNavigationGraph(
    navController: NavHostController,
) {
    navigation(startDestination = ROUTE_SIGN_IN_SCREEN, route = ROUTE_AUTH_NAVIGATION_GRAPH) {
        signInScreen(
            onBackClick = navController::popBackStack,
            onSignUpClick = {},
        )
    }
}

fun NavGraphBuilder.signInScreen(
    route: String = ROUTE_SIGN_IN_SCREEN,
    onBackClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    composable(route = route) {
        val viewModel: SignInViewModel = viewModel()
        SignInRoute(
            viewModel = viewModel,
            onBackClick = onBackClick,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onFacebookClick = {},
            onGoogleClick = {},
            onSignUpClick = onSignUpClick,
            onCheckedChange = viewModel::onCheckedChange,
        )
    }
}

@Composable
fun SignInRoute(
    viewModel: SignInViewModel,
    onBackClick: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    SignInScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onEmailChange = onEmailChange,
        onPasswordChange = onPasswordChange,
        onFacebookClick = onFacebookClick,
        onGoogleClick = onGoogleClick,
        onSignUpClick = onSignUpClick,
        onCheckedChange = onCheckedChange,
    )
}
