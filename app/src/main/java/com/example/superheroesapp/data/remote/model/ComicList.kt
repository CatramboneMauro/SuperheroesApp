package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ComicList(
    @SerializedName("items")
    val items: List<Comic>
)
