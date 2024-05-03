package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ComicApiModel(
    @SerializedName("items")
    val items: List<ItemApiModel>,
)
