package com.example.superheroesapp.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.superheroesapp.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface SuperheroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterEntity>)

    @Update
    suspend fun modifyLikedCharacter(character: CharacterEntity)

    @Query("SELECT * FROM Character")
    suspend fun loadAllCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM Character WHERE favourite = true")
    suspend fun loadLikedCharacters(): Flow<List<CharacterEntity>>
}
