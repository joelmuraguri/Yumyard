package com.joel.remote.api

import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import com.joel.remote.dtos.SimilarRecipeResponse
import com.joel.remote.dtos.RandomRecipeResponse


interface RecipeRemoteSource {

    suspend fun getRandomRecipes(
        includedTags : String,
    ) : RandomRecipeResponse

    suspend fun getRecipeInfo(
        id : Int,
    ) : RecipeInfoResponse

    suspend fun getSimilarRecipes(
        id : Int,
    ) : SimilarRecipeResponse

    suspend fun getRecipeInstructions(
        id : Int,
    ) : RecipeInfoResponse

    suspend fun complexSearch(
        query : String
    ) : SearchRecipeResponse

}