package com.example.superheroesapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
) {
    object Home : Screen("Home", Icons.Filled.Home, Icons.Outlined.Home)
    object Favourite : Screen("Favourite", Icons.Filled.Favorite, Icons.Outlined.Favorite)
}
