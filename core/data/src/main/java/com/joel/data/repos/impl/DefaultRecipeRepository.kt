package com.joel.data.repos.impl

import com.joel.data.repos.RecipeRepository
import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.dtos.RandomRecipeResponse
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import javax.inject.Inject

class DefaultRecipeRepository @Inject constructor(
    private val recipeRemoteSource : RecipeRemoteSource
) : RecipeRepository {

    override suspend fun getRandomByCusinesRecipes(): RandomRecipeResponse {
        return recipeRemoteSource.getRandomRecipes(
            includedTags = listOf("dessert")
        )
    }

    override suspend fun getRandomByMealTypesRecipes(includedTags: List<String>): RandomRecipeResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomWithoutIntoleranceRecipes(excludeTags: List<String>): RandomRecipeResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeInfo(id: Int): RecipeInfoResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getSimilarRecipes(id: Int): RandomRecipeResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeInstructions(id: Int): RecipeInfoResponse {
        TODO("Not yet implemented")
    }

    override suspend fun complexSearch(apiKey: String): SearchRecipeResponse {
        TODO("Not yet implemented")
    }
}