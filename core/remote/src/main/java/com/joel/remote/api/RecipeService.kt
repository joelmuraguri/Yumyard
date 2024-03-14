package com.joel.remote.api

import com.joel.remote.dtos.RandomRecipeResponse
import com.joel.remote.dtos.RecipeInfoResponse
import com.joel.remote.dtos.SearchRecipeResponse
import com.joel.remote.dtos.SimilarRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("include-tags") includedTags : String,
        @Query("apiKey") apiKey : String,
        @Query("number") number : Int = 1
    ) : RandomRecipeResponse

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInfo(
        @Path("id") id : Int,
        @Query("apiKey") apiKey : String
    ) : RecipeInfoResponse

    @GET("/recipes/{id}/similar")
    suspend fun getSimilarRecipes(
        @Path("id") id : Int,
        @Query("apiKey") apiKey : String
    ) : SimilarRecipeResponse

    @GET("/recipes/{id}/analyzedInstructions")
    suspend fun getRecipeInstructions(
        @Path("id") id : Int,
        @Query("apiKey") apiKey : String
    ) : RecipeInfoResponse

    @GET("/recipes/complexSearch")
    suspend fun complexSearch(
        @Query("query") query : String,
        @Query("apiKey") apiKey : String
    ) : SearchRecipeResponse


}