package com.example.superheroesapp.data.remote.model

import com.example.superheroesapp.data.local.entity.CharacterEntity
import com.example.superheroesapp.domain.model.Hero
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("comics")
    val comics: ComicApiModel,
    val isFavourite: Boolean = false
)


