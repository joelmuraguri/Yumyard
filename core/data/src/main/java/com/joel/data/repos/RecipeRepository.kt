package com.joel.data.repos

import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import com.joel.remote.dtos.RandomRecipeResponse


interface RecipeRepository {

    suspend fun getRandomByCuisinesRecipes(
        cuisine : String
    ) : RandomRecipeResponse

    suspend fun getRandomByMealTypesRecipes(
        mealType : String,
    ) : RandomRecipeResponse

    suspend fun getRandomByDietRecipes(
        diet : String,
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