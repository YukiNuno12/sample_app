package com.yuki.sample_app.ui

import androidx.annotation.StringRes
import com.yuki.sample_app.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.home)
    object Profile : Screen("profile", R.string.profile)
}
