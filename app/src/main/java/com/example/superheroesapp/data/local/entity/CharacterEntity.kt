package com.example.superheroesapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.superheroesapp.domain.model.Hero

@Entity(
    tableName = "Character",
)
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("cover")
    val cover: String,
    @ColumnInfo("isFavourite")
    val isFavourite: Boolean = false,
)

