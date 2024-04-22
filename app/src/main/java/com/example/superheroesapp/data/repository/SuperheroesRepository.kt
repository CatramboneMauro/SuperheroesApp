package com.example.superheroesapp.data.repository

import com.example.superheroesapp.data.local.entity.CharacterEntity
import com.example.superheroesapp.data.remote.model.CharacterNetworkResponse
import kotlinx.coroutines.flow.Flow

interface SuperheroesRepository {
    suspend fun getCharacters(
        apikey: String,
        timestamp: Int,
        hash: String,
    ): Flow<CharacterNetworkResponse>

    suspend fun getCharacterById(
        characterId: Int,
        apikey: String,
        timestamp: Int,
        hash: String,
    ): Flow<CharacterNetworkResponse>

    suspend fun getFavouriteCharacters(): Flow<List<CharacterEntity>>

    suspend fun modifyFavouriteCharacter(characterId: Int)
}