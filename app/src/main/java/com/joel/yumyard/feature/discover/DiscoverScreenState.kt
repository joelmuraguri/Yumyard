package com.joel.yumyard.feature.discover

import com.joel.domain.model.Recipe

data class DiscoverScreenState(
    val recipesMealTypes : List<Recipe> = emptyList(),
    val recipesCuisines : List<Recipe> = emptyList(),
    val recipesDiets : List<Recipe> = emptyList(),
    val loading : Boolean = false,
    val error : String = "",
    val selectedMealType : String = "dessert",
    val selectedDiets : String = "paleo",
    val selectedCuisines : String = "african",
)
