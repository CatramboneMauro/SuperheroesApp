package com.example.superheroesapp.data.repository

import com.example.superheroesapp.data.local.SuperHeroesDatabase
import com.example.superheroesapp.data.local.entity.CharacterEntity
import com.example.superheroesapp.data.remote.model.CharacterNetworkResponse
import com.example.superheroesapp.data.remote.service.MarvelApiService
import kotlinx.coroutines.flow.Flow

class SuperheroesDefaultRepository(
    service: MarvelApiService,
    database: SuperHeroesDatabase
): SuperheroesRepository {
    override suspend fun getCharacters(
        apikey: String,
        timestamp: Int,
        hash: String
    ): Flow<CharacterNetworkResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterById(
        characterId: Int,
        apikey: String,
        timestamp: Int,
        hash: String
    ): Flow<CharacterNetworkResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavouriteCharacters(): Flow<List<CharacterEntity>> {
        TODO("Not yet implemented")
    }
}