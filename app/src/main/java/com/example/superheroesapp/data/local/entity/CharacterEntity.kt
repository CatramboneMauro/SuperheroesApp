package com.example.superheroesapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Character",
)
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("cover")
    val cover: String,
    @ColumnInfo("favourite")
    val favourite: Boolean = false,
)
