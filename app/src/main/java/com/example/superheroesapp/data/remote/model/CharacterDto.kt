package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("data")
    val data: Data
)
