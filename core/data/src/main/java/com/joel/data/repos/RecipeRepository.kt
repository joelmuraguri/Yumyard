package com.joel.data.repos

import com.joel.remote.dtos.RandomRecipeResponse
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse

interface RecipeRepository {

    suspend fun getRandomByCusinesRecipes(
    ) : RandomRecipeResponse

    suspend fun getRandomByMealTypesRecipes(
        includedTags : List<String>,
    ) : RandomRecipeResponse

    suspend fun getRandomWithoutIntoleranceRecipes(
        excludeTags : List<String>,
    ) : RandomRecipeResponse

    suspend fun getRecipeInfo(
        id : Int,
    ) : RecipeInfoResponse

    suspend fun getSimilarRecipes(
        id : Int,
    ) : RandomRecipeResponse

    suspend fun getRecipeInstructions(
        id : Int,
    ) : RecipeInfoResponse

    suspend fun complexSearch(
        apiKey: String,
    ) : SearchRecipeResponse
}