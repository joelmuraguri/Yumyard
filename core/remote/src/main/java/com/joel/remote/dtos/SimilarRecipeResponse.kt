package com.joel.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class SimilarRecipeResponse(
    val recipes : List<SimilarRecipe>
) {

    @Serializable
    data class SimilarRecipe(
        val id: Int,
        val imageType: String,
        val readyInMinutes: Int,
        val servings: Int,
        val sourceUrl: String,
        val title: String
    )
}

