package com.example.superheroesapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun BottomNavItem(
    screen: Screen,
    isSelected: Boolean
){
    if(isSelected)Icon(screen.activeIcon,null)else Icon(screen.inactiveIcon,null)
}