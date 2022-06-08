package com.yuki.sample_app.view

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Button(onClick = { navController.navigate("Profile") }) {
        Text(text = "Profile Navigate next")
    }
}