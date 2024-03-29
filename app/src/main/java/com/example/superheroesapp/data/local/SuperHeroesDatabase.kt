package com.example.superheroesapp.data.local

import androidx.room.RoomDatabase

abstract class SuperHeroesDatabase : RoomDatabase() {
    abstract fun superheroesDao(): SuperheroesDao
}
