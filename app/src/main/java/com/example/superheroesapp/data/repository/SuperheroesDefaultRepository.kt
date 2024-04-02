package com.example.superheroesapp.data.repository

import com.example.superheroesapp.data.local.SuperHeroesDatabase
import com.example.superheroesapp.data.remote.service.MarvelApiService

class SuperheroesDefaultRepository(
    service: MarvelApiService,
    database: SuperHeroesDatabase
) {
}