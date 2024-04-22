package com.example.superheroesapp.data.remote.model

import com.example.superheroesapp.data.local.entity.CharacterEntity
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
    val comics: List<ComicList>,
)

fun Result.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        description = description,
        name = name,
        cover = "${thumbnail.path}.${thumbnail.extension}",
    )
}
