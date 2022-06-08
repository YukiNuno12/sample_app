package com.yuki.sample_app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yuki.sample_app.view.HomeScreen
import com.yuki.sample_app.view.ProfileScreen

@Composable
fun BottomNav(navHostController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Profile
    )
    Scaffold(bottomBar = {
        BottomNavigation {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, null) },
                    label = { Text(stringResource(id = screen.resourceId)) },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navHostController.navigate(screen.route) {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Profile.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen(navHostController) }
            composable(Screen.Profile.route) { ProfileScreen(navHostController) }
        }
    }
}