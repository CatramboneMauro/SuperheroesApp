package com.example.superheroesapp.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.superheroesapp.domain.model.Hero

@Composable
fun HomeScreen(
    viewmodel: HomeViewmodel = hiltViewModel(),
    onClick: (Hero) -> Unit
){

}