package com.joel.yumyard.feature.discover

import com.joel.domain.model.Recipe

data class DiscoverScreenState(
    val recipes : List<Recipe> = emptyList(),
    val loading : Boolean = false,
    val error : String = ""
)
