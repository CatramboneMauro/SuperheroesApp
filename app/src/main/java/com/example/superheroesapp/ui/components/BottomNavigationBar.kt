package com.example.superheroesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    screens: List<Screen>,
) {
    var selectedScreen by remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .shadow(3.dp)
            .height(30.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            for (screen in screens) {
                val isSelected = screen == screens[selectedScreen]
                Box(
                    modifier = Modifier.weight(if (isSelected)1.5f else 1f),
                ) {
                    BottomNavItem(screen,isSelected)
                    Text()
                }
            }
        }
    }
}
