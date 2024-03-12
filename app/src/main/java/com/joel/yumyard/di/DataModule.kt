package com.joel.yumyard.di

import com.joel.data.repos.impl.DefaultRecipeRepository
import com.joel.remote.api.RecipeRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesRecipeRepository(
        recipeRemoteSource: RecipeRemoteSource
    ) : DefaultRecipeRepository {
        return DefaultRecipeRepository(recipeRemoteSource)
    }

}