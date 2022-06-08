package com.yuki.sample_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.yuki.sample_app.ui.BottomNav

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
    val navController = rememberNavController()
    BottomNav(navController)
}