package com.joel.remote.api.impl

import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import com.joel.remote.dtos.SimilarRecipeResponse
import com.joel.remote.dtos.RandomRecipeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject


class DefaultRecipeRemoteSource @Inject constructor(
    private val client : HttpClient,
    private val apiKey : String
) : RecipeRemoteSource {

    override suspend fun getRandomRecipes(
        includedTags: List<String>,
    ): RandomRecipeResponse =
        client.get("https://api.spoonacular.com/recipes/random"){
            parameter("include_tags", includedTags)
            parameter("api_key",apiKey)
        }.body()

    override suspend fun getRecipeInfo(id: Int): RecipeInfoResponse =
        client.get("https://api.spoonacular.com/recipes/${id}/information"){
            parameter("id", id)
            parameter("apiKey",apiKey)
        }.body()


    override suspend fun getSimilarRecipes(id: Int): SimilarRecipeResponse =
        client.get("https://api.spoonacular.com/recipes/${id}/similar"){
            parameter("id", id)
            parameter("apiKey",apiKey)
        }.body()

    override suspend fun getRecipeInstructions(id: Int): RecipeInfoResponse  =
        client.get("https://api.spoonacular.com/recipes/${id}/analyzedInstructions"){
            parameter("id", id)
            parameter("apiKey",apiKey)
        }.body()

    override suspend fun complexSearch(query: String): SearchRecipeResponse =
        client.get(" https://api.spoonacular.com/recipes/complexSearch"){
            parameter("query", query)
            parameter("apiKey",apiKey)
        }.body()
}