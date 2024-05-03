package com.example.superheroesapp.data.repository

import android.content.Context
import com.example.superheroesapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface SuperheroesRepository {
    suspend fun getCharacters(
        timestamp: Int,
        context: Context,
    ): Flow<List<Hero>>

    suspend fun getCharactersByName(
        name: String,
        context: Context,
        timestamp: Int,
    ): Flow<List<Hero>>

    suspend fun getFavouriteCharacters(): Flow<List<Hero>>

    suspend fun modifyFavouriteCharacter(characterId: Int)
}
