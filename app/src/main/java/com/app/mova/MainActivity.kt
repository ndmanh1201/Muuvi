package com.app.mova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.app.mova.navigation.AppNavigation
import com.app.mova.core.ui.theme.MovaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovaTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
