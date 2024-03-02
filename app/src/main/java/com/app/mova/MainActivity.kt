package com.app.muuvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.app.muuvi.navigation.AppNavigation
import com.app.muuvi.core.ui.theme.muuviTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            muuviTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
