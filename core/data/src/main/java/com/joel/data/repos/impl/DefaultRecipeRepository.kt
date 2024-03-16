package com.joel.data.repos.impl

import com.joel.data.repos.RecipeRepository
import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.dtos.RandomRecipeResponse
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse

class DefaultRecipeRepository(
    private val recipeRemoteSource : RecipeRemoteSource
) : RecipeRepository {

    override suspend fun getRandomByCuisinesRecipes(cuisine : String): RandomRecipeResponse {
        return recipeRemoteSource.getRandomRecipes(
            includedTags = cuisine
        )
    }

    override suspend fun getRandomByMealTypesRecipes(mealType : String): RandomRecipeResponse {
        return recipeRemoteSource.getRandomRecipes(
            includedTags = mealType
        )
    }

    override suspend fun getRandomByDietRecipes(diet : String): RandomRecipeResponse {
        return recipeRemoteSource.getRandomRecipes(
            includedTags = diet
        )
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