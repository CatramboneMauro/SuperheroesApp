package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ItemApiModel(
    @SerializedName("name")
    val name: String
)
