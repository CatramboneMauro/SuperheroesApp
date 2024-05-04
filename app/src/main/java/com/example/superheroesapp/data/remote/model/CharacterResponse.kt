package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data")
    val data: Data
)
