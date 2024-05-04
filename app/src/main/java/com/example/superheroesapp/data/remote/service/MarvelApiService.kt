package com.example.superheroesapp.data.remote.service

import com.example.superheroesapp.data.remote.model.CharacterResponse
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
    ): CharacterResponse

    /**
     * Fetches a single character by id.
     */
    @GET("/v1/public/characters")
    suspend fun getCharacter(
        @Query("name")name: String,
        @Query("apikey") apikey: String,
        @Query("ts")timestamp: Int,
        @Query("hash") hash: String,
    ): CharacterResponse

    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
    }
}



    


