package com.joel.yumyard.feature.discover

sealed class DiscoverEvents {
    data class SelectedMealType(val mealType : String) : DiscoverEvents()
    data class SelectedDiets(val diet : String) : DiscoverEvents()
    data class SelectedCuisines(val cuisine : String) : DiscoverEvents()
}