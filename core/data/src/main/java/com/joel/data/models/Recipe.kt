package com.joel.data.models

data class Recipe(
    val id : Int,
    val title : String,
    val readyInMinutes : Int,
    val image : String,
    val calories : String,
    val healthLevel : String
)
