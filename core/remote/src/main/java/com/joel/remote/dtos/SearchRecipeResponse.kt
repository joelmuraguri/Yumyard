package com.joel.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class SearchRecipeResponse(
    val number: Int,
    val offset: Int,
    val results: List<SearchRecipe>,
    val totalResults: Int
) {

    @Serializable
    data class SearchRecipe(
        val id: Int,
        val image: String,
        val imageType: String,
        val title: String
    )
}