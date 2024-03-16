package com.joel.yumyard.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.joel.data.repos.RecipeRepository
import com.joel.data.repos.impl.DefaultRecipeRepository
import com.joel.domain.usecase.recipe.GetRandomCuisinesRecipesUseCase
import com.joel.domain.usecase.recipe.GetRandomDietsRecipesUseCase
import com.joel.domain.usecase.recipe.GetRandomMealTypesRecipesUseCase
import com.joel.domain.usecase.recipe.RecipeUseCases
import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.api.RecipeService
import com.joel.remote.api.impl.DefaultRecipeRemoteSource
import com.joel.yumyard.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface AppDataContainer{
    val recipeRemoteSource : RecipeRemoteSource
    val recipeRepository : RecipeRepository
    val recipeUseCases : RecipeUseCases
}

class DefaultAppContainer : AppDataContainer {

    private val spoonacularBaseUrl = "https://api.spoonacular.com"

    private val json = Json { ignoreUnknownKeys = true }

    private val client : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10L, TimeUnit.SECONDS)
        .writeTimeout(10L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(client)
        .baseUrl(spoonacularBaseUrl)
        .build()

    private val retrofitService: RecipeService by lazy {
        retrofit.create(RecipeService::class.java)
    }

    override val recipeRemoteSource: RecipeRemoteSource by lazy {
        DefaultRecipeRemoteSource(
            recipeService = retrofitService,
            apiKey = BuildConfig.SPOONACULAR_API_KEY
        )
    }


    override val recipeRepository: RecipeRepository by lazy{
        DefaultRecipeRepository(recipeRemoteSource)
    }

    override val recipeUseCases: RecipeUseCases by lazy {
        RecipeUseCases(
            getRandomCuisinesRecipesUseCase = GetRandomCuisinesRecipesUseCase(recipeRepository),
            getRandomDietsRecipesUseCase = GetRandomDietsRecipesUseCase(recipeRepository),
            getRandomMealTypesRecipesUseCase = GetRandomMealTypesRecipesUseCase(recipeRepository)
        )
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().also {
            it.level = level
        }
    }

}
