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

    //    override suspend fun getRandomRecipes(
//        includedTags: List<String>,
//    ): RandomRecipeResponse =
//        client.get("https://api.spoonacular.com/recipes/random"){
//            parameter("include_tags", includedTags)
//            parameter("api_key",apiKey)
//        }.body()
//
//    override suspend fun getRecipeInfo(id: Int): RecipeInfoResponse =
//        client.get("https://api.spoonacular.com/recipes/${id}/information"){
//            parameter("id", id)
//            parameter("apiKey",apiKey)
//        }.body()
//
//
//    override suspend fun getSimilarRecipes(id: Int): SimilarRecipeResponse =
//        client.get("https://api.spoonacular.com/recipes/${id}/similar"){
//            parameter("id", id)
//            parameter("apiKey",apiKey)
//        }.body()
//
//    override suspend fun getRecipeInstructions(id: Int): RecipeInfoResponse  =
//        client.get("https://api.spoonacular.com/recipes/${id}/analyzedInstructions"){
//            parameter("id", id)
//            parameter("apiKey",apiKey)
//        }.body()
//
//    override suspend fun complexSearch(query: String): SearchRecipeResponse =
//        client.get(" https://api.spoonacular.com/recipes/complexSearch"){
//            parameter("query", query)
//            parameter("apiKey",apiKey)
//        }.body()
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