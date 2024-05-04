package com.example.superheroesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superheroesapp.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class],version = 1)
abstract class SuperHeroesDatabase : RoomDatabase() {
    abstract val dao: SuperheroesDao
}
