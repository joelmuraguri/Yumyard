package com.joel.yumyard.di

import com.joel.remote.api.RecipeRemoteSource
import com.joel.remote.api.impl.DefaultRecipeRemoteSource
import com.joel.remote.utils.HttpClientFactory
import com.joel.yumyard.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.AndroidClientEngine
import io.ktor.client.engine.android.AndroidEngineConfig
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object RemoteModule {
//    @Provides
//    @Singleton
//    fun provideHttpClientEngine(): HttpClientEngine = AndroidClientEngine(AndroidEngineConfig())
//
//    @Provides
//    @Singleton
//    fun provideHttpClient(engine: HttpClientEngine): HttpClient = HttpClientFactory().createEngine(engine)
//
//    @Provides
//    fun providesSpoonacularAPIRemoteSource(
//        httpClient: HttpClient,
//        apiKey: String = BuildConfig.SPOONACULAR_API_KEY
//    ): RecipeRemoteSource = DefaultRecipeRemoteSource(httpClient, apiKey)
//
//}