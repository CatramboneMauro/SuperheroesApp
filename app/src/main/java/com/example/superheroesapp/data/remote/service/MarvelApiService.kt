package com.example.superheroesapp.data.remote.service

import com.example.superheroesapp.data.remote.model.CharacterNetworkResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {

    /**
     * Returns a list of characters in a Flow
     */

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String,
        @Query("ts")timestamp: Int,
        @Query("hash") hash: String,
    ): Flow<CharacterNetworkResponse>

    /**
     * Fetches a single character by id.
     */
    @GET("/v1/public/characters{characterId}")
    suspend fun getCharacter(
        @Path("characterId")id: Int,
        @Query("apikey") apikey: String,
        @Query("ts")timestamp: Int,
        @Query("hash") hash: String,
    ): Flow<CharacterNetworkResponse>

    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        const val API_KEY = "82c999774c5c40b77ed7fcb3d791e8bd"
    }
}



    


