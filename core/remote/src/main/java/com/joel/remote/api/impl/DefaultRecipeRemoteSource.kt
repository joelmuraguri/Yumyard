package com.joel.remote.api.impl

import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.api.RecipeService
import com.joel.remote.dtos.RandomRecipeResponse
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import com.joel.remote.dtos.SimilarRecipeResponse


class DefaultRecipeRemoteSource(
    private val recipeService: RecipeService,
    private val apiKey : String
) : RecipeRemoteSource {

    override suspend fun getRandomRecipes(includedTags: String): RandomRecipeResponse {
        return recipeService.getRandomRecipes(includedTags, apiKey)
    }


    override suspend fun getRecipeInfo(id: Int): RecipeInfoResponse {
        return recipeService.getRecipeInfo(id, apiKey)
    }

    override suspend fun getSimilarRecipes(id: Int): SimilarRecipeResponse {
        return recipeService.getSimilarRecipes(id, apiKey)
    }

    override suspend fun getRecipeInstructions(id: Int): RecipeInfoResponse {
        return recipeService.getRecipeInstructions(id, apiKey)
    }

    override suspend fun complexSearch(query: String): SearchRecipeResponse {
        return recipeService.complexSearch(query, apiKey)
    }
}