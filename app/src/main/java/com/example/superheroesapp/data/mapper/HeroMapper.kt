package com.example.superheroesapp.data.mapper

import com.example.superheroesapp.data.local.entity.CharacterEntity
import com.example.superheroesapp.data.remote.model.Result
import com.example.superheroesapp.domain.model.Hero

fun CharacterEntity.toDomain(): Hero {
    return Hero(
        id = id,
        name = name,
        description = description,
        thumbnail = cover,
        isFavourite = isFavourite,
    )
}

fun Result.toDomain(): Hero{
    return Hero(
        id = id,
        description = description,
        name = name,
        thumbnail = thumbnail.path + thumbnail.extension,
        isFavourite = isFavourite
    )
}

fun Hero.toEntity():CharacterEntity{
    return CharacterEntity(
        id = id,
        name = name,
        description = description,
        cover = thumbnail,
        isFavourite = isFavourite
    )
}