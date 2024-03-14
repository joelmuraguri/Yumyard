package com.joel.yumyard.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joel.yumyard.feature.discover.DiscoverViewModel
import com.joel.yumyard.RecipeApp

object ViewModelFactory {

    val Factory = viewModelFactory {
        initializer {
            DiscoverViewModel(
                recipeUseCase = recipeApplication().container.recipeUseCases
            )
        }
    }
}

fun CreationExtras.recipeApplication() : RecipeApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeApp)