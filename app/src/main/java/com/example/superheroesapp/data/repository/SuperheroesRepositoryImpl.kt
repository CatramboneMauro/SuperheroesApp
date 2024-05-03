package com.example.superheroesapp.data.repository

import android.content.Context
import android.util.Log
import com.example.superheroesapp.BuildConfig
import com.example.superheroesapp.core.util.isOnline
import com.example.superheroesapp.core.util.md5
import com.example.superheroesapp.data.local.SuperHeroesDatabase
import com.example.superheroesapp.data.local.entity.toDomain
import com.example.superheroesapp.data.remote.model.toDomain
import com.example.superheroesapp.data.remote.service.MarvelApiService
import com.example.superheroesapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SuperheroesRepositoryImpl @Inject constructor(
    private val service: MarvelApiService,
    private val database: SuperHeroesDatabase,
) : SuperheroesRepository {
    override suspend fun getCharacters(
        timestamp: Int,
        context: Context,
    ): Flow<List<Hero>> {
        try{
            return flow {
                val dbResult = database.superheroesDao().loadAll()
                if (dbResult.isNotEmpty()) {
                    emit(
                        dbResult.map {
                            it.toDomain()
                        },
                    )
                }

                if (isOnline(context)) {
                    val hash = "$timestamp${BuildConfig.MARVEL_PRIVATE_API_KEY}${BuildConfig.MARVEL_API_KEY}"
                    val networkResult = service.getCharacters(BuildConfig.MARVEL_API_KEY, timestamp, hash.md5()).map { it.data.results. }
                    networkResult.collect{
                        emit(it.data.results.map {
                            it.toDomain()
                        }

                        )
                    }
                }else{
                    TODO() // Agregar UiEvent sin internet
                }


            }
        }catch(e:Exception){
            Log.e("Repository",e.message.toString())

        }

    }

    override suspend fun getCharactersByName(
        name: String,
        context: Context,
        timestamp: Int,
    ): Flow<List<Hero>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavouriteCharacters(): Flow<List<<Hero>> {
        TODO("Not yet implemented")
    }

    override suspend fun modifyFavouriteCharacter(characterId: Int) {
        TODO("Not yet implemented")
    }
}
