package com.example.superheroesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterNetworkResponse(
    @SerializedName("data")
    val data: Data,
)
