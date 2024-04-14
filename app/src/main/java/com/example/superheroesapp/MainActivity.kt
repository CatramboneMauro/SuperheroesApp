package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.superheroesapp.navigation.Route
import com.example.superheroesapp.ui.screens.character.CharacterScreen
import com.example.superheroesapp.ui.screens.favourite.FavouriteScreen
import com.example.superheroesapp.ui.screens.home.HomeScreen
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            SuperHeroesAppTheme {
                Scaffold(){
                    NavHost(
                        navController = navController,
                        startDestination = Route.MAIN_SCREEN,
                        modifier = Modifier.padding(it),) {
                        composable(Route.MAIN_SCREEN) {
                            HomeScreen(
                                onClick = { hero -> navController.navigate("${Route.CHARACTER_SCREEN}/${hero.id}") },
                            )
                        }
                        composable(Route.FAVOURITE_SCREEN) {
                            FavouriteScreen()
                        }
                        composable(Route.CHARACTER_SCREEN) {
                            CharacterScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun App() {
}
