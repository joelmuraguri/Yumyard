package com.joel.yumyard.feature.discover

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
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
        getRandomRecipes()
    }


    private fun getRandomRecipes(){
        recipeUseCase.getRandomRecipesUseCase().onEach { resource ->
            when(resource){
                is Resource.Error -> {
                    _state.value = DiscoverScreenState(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DiscoverScreenState(
                        loading = true
                    )

                }
                is Resource.Success -> {
                    _state.value = DiscoverScreenState(
                        recipes = resource.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeApp)
                val recipeUseCase = application.container.recipeUseCases
                DiscoverViewModel(recipeUseCase = recipeUseCase)
            }
        }
    }
}