package com.joel.domain.model

import com.joel.remote.dtos.RandomRecipeResponse

data class Recipe(
    val id : Int,
    val title : String,
    val readyInMinutes : Int,
    val image : String,
    val healthLevel : Int
)


fun RandomRecipeResponse.Recipe.toRecipeDomainModel() : Recipe{
    return Recipe(
        id = id ?: 0,
        title = title ?: "",
        readyInMinutes = readyInMinutes ?: 0,
        image = imageType ?: "",
        healthLevel = healthScore ?: 0
    )
}