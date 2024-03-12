package com.joel.yumyard.di

import com.joel.data.repos.RecipeRepository
import com.joel.domain.usecase.recipe.GetRandomRecipesUseCase
import com.joel.domain.usecase.recipe.RecipeUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesRecipeUseCases(
        recipeRepository: RecipeRepository
    ) : RecipeUseCases{
        return RecipeUseCases(
            getRandomRecipesUseCase = GetRandomRecipesUseCase(recipeRepository)
        )
    }

}