package com.example.superheroesapp.data.repository

import android.content.Context
import android.util.Log
import com.example.superheroesapp.BuildConfig
import com.example.superheroesapp.core.util.isOnline
import com.example.superheroesapp.core.util.md5
import com.example.superheroesapp.data.local.SuperheroesDao
import com.example.superheroesapp.data.local.entity.CharacterEntity
import com.example.superheroesapp.data.mapper.toDomain
import com.example.superheroesapp.data.mapper.toEntity
import com.example.superheroesapp.data.remote.service.MarvelApiService
import com.example.superheroesapp.domain.model.Hero
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.timeout
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class SuperheroesRepositoryImpl @Inject constructor(
    private val service: MarvelApiService,
    private val dao: SuperheroesDao,
) : SuperheroesRepository {
    override suspend fun getCharacters(
        timestamp: Int,
        context: Context,
    ): Flow<List<Hero>> {
        try{
            return flow {
                val dbResult = dao.loadAll()
                if (dbResult.isNotEmpty()) {
                    emit(
                        dbResult.map {
                            it.toDomain()
                        },
                    )
                }

                if (isOnline(context)) {
                    val hash = "$timestamp${BuildConfig.MARVEL_PRIVATE_API_KEY}${BuildConfig.MARVEL_API_KEY}"
                    var networkResult = service.getCharacters(BuildConfig.MARVEL_API_KEY, timestamp, hash.md5())
                    dao.insertAll(networkResult.data.results.map { it.toDomain().toEntity() })
                    emit(networkResult.data.results.map { it.toDomain() })

                }else{
                    TODO() // Agregar UiEvent que informe del error al cargar de internet
                }


            }.timeout(3000.milliseconds)
        }catch(e:Exception){
            Log.e("Repository",e.message.toString())

        }

    }

    @OptIn(FlowPreview::class)
    override suspend fun getCharactersByName(
        name: String,
        context: Context,
        timestamp: Int,
    ): Flow<List<Hero>> {
        try{
            return flow{
                var dbResult = dao.getCharacter(name)
                if (dbResult.isNotEmpty()) {
                    emit(
                        dbResult.map {
                            it.toDomain()
                        },
                    )

                }

                if(isOnline(context)){
                    val hash = "$timestamp${BuildConfig.MARVEL_PRIVATE_API_KEY}${BuildConfig.MARVEL_API_KEY}"
                    var networkResult = service.getCharacter(BuildConfig.MARVEL_API_KEY, timestamp, hash.md5())
                    dao.insertAll(networkResult.data.results.map { it.toDomain().toEntity() })
                    emit(networkResult.data.results.map { it.toDomain() })
                }
            }.timeout(3000.milliseconds)
        }catch(e:Exception){
            Log.e("Repository",e.message.toString())
        }
    }

    override suspend fun getFavouriteCharacters(): Flow<List<Hero>> {
        return dao.getLiked().map {
            it.map {character ->
                character.toDomain()
            }
        }
    }

    override suspend fun modifyFavouriteCharacter(hero: CharacterEntity) {
        dao.modifyLiked(hero)
    }
}