package com.joel.domain.usecase.recipe

data class RecipeUseCases(
    val getRandomCuisinesRecipesUseCase: GetRandomCuisinesRecipesUseCase,
    val getRandomDietsRecipesUseCase : GetRandomDietsRecipesUseCase,
    val getRandomMealTypesRecipesUseCase: GetRandomMealTypesRecipesUseCase
)
