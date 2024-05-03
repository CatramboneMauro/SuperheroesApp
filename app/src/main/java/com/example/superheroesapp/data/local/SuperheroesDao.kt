package com.example.superheroesapp.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.superheroesapp.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface SuperheroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<CharacterEntity>)

    @Update
    suspend fun modifyLiked(character: CharacterEntity)

    @Query("SELECT * FROM Character")
    suspend fun loadAll(): List<CharacterEntity>

    @Query(
        """
        SELECT * FROM Character WHERE name LIKE :name
    """,
    )
    suspend fun loadCharacter(name: String): CharacterEntity

    @Query("SELECT * FROM Character WHERE isFavourite = true")
    suspend fun loadLiked(): Flow<List<CharacterEntity>>
}
