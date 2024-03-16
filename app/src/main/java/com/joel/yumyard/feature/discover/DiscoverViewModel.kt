package com.joel.yumyard.feature.discover

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joel.domain.model.Recipe
import com.joel.domain.usecase.recipe.RecipeUseCases
import com.joel.domain.utils.Resource
import com.joel.yumyard.RecipeApp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DiscoverViewModel(
    private val recipeUseCase : RecipeUseCases
): ViewModel() {

    private val _state = mutableStateOf(DiscoverScreenState())
    val state: State<DiscoverScreenState> = _state

    init {
        refreshAll()
    }

    private fun refreshAll() {
        getRandomDietsRecipes()
        getRandomMealTypesRecipes()
        getRandomCuisinesRecipes()
    }

    fun onEvents(events: DiscoverEvents){
        when(events){
            is DiscoverEvents.SelectedCuisines -> {
                _state.value = DiscoverScreenState(
                    selectedCuisines = events.cuisine
                )
            }
            is DiscoverEvents.SelectedDiets -> {
                _state.value = DiscoverScreenState(
                    selectedDiets = events.diet
                )
            }
            is DiscoverEvents.SelectedMealType -> {
                _state.value = DiscoverScreenState(
                    selectedMealType = events.mealType
                )
            }
        }
    }

    private fun getRandomMealTypesRecipes() {
        recipeUseCase.getRandomMealTypesRecipesUseCase(_state.value.selectedMealType)
            .onEach { resource ->
                handleResource(resource) { recipes ->
                    _state.value = _state.value.copy(recipesMealTypes = recipes,loading = false)
                }
            }.launchIn(viewModelScope)
    }

    private fun getRandomCuisinesRecipes() {
        recipeUseCase.getRandomCuisinesRecipesUseCase(_state.value.selectedCuisines)
            .onEach { resource ->
                handleResource(resource) { recipes ->
                    _state.value = _state.value.copy(recipesCuisines = recipes,  loading = false)
                }
            }.launchIn(viewModelScope)
    }

    private fun getRandomDietsRecipes() {
        recipeUseCase.getRandomDietsRecipesUseCase(_state.value.selectedDiets)
            .onEach { resource ->
                handleResource(resource) { recipes ->
                    _state.value = _state.value.copy(recipesDiets = recipes, loading = false)
                }
            }.launchIn(viewModelScope)
    }

    private inline fun handleResource(
        resource: Resource<List<Recipe>>,
        onSuccess: (List<Recipe>) -> Unit
    ) {
        when (resource) {
            is Resource.Error -> {
                _state.value = _state.value.copy(
                    loading = false,
                    error = resource.message ?: "An unexpected error occurred"
                )
            }
            is Resource.Loading -> {
                _state.value = _state.value.copy(loading = true)
            }
            is Resource.Success -> {
                onSuccess(resource.data ?: emptyList())
            }
        }
    }

}