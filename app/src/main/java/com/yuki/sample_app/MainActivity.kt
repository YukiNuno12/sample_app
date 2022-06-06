package com.yuki.sample_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yuki.sample_app.ui.SampleScreen
import com.yuki.sample_app.ui.theme.Sample_appTheme
import com.yuki.sample_app.view.HomeScreen
import com.yuki.sample_app.view.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleApp()
        }
    }
}

@Composable
fun SampleApp() {
    Sample_appTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = SampleScreen.Profile.name) {
            composable(SampleScreen.Home.name) {
                HomeScreen(appName = "HOGE")
            }
            composable(SampleScreen.Profile.name) {
                ProfileScreen()
            }
        }
    }
}