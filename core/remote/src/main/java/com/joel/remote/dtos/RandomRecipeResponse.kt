package com.joel.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class RandomRecipeResponse(
    val recipes: List<Recipe> = emptyList()
) {

    @Serializable
    data class Recipe(
        val aggregateLikes: Int,
        val analyzedInstructions: List<AnalyzedInstruction> = emptyList(),
        val cheap: Boolean = false,
        val cookingMinutes: Int ?= null,
        val creditsText: String ?= null,
        val cuisines: List<String> = emptyList(),
        val dairyFree: Boolean = false,
        val diets: List<String> = emptyList(),
        val dishTypes: List<String> = emptyList(),
        val extendedIngredients: List<ExtendedIngredient>,
        val gaps: String ?= null,
        val glutenFree: Boolean = false,
        val healthScore: Int ?= null,
        val id: Int ?= null,
        val instructions: String ?= null,
        val license: String ?= null,
        val lowFodmap: Boolean = false,
        val occasions: List<String> = emptyList(),
        val originalId: String ?= null,
        val preparationMinutes: Int ?= null,
        val pricePerServing: Double ?= null,
        val readyInMinutes: Int ?= null,
        val servings: Int ?= null,
        val sourceName: String ?= null,
        val sourceUrl: String ?= null,
        val spoonacularScore: Double ?= null,
        val spoonacularSourceUrl: String ?= null,
        val summary: String ?= null,
        val sustainable: Boolean = false,
        val title: String ?= null,
        val vegan: Boolean = false,
        val vegetarian: Boolean = false,
        val veryHealthy: Boolean = false,
        val veryPopular: Boolean = false,
        val weightWatcherSmartPoints: Int ?= null
    ){
        @Serializable
        data class AnalyzedInstruction(
            val name: String ?= null,
            val steps: List<Step> = emptyList()
        ) {
            @Serializable
            data class Step(
                val equipment: List<Equipment> = emptyList(),
                val ingredients: List<Ingredient> = emptyList(),
                val length: Length ?= null,
                val number: Int? = null,
                val step: String ?= null
            ) {
                @Serializable
                data class Equipment(
                    val id: Int ?= null,
                    val image: String?= null,
                    val localizedName: String?= null,
                    val name: String?= null
                )
                @Serializable
                data class Ingredient(
                    val id: Int ?= null,
                    val image: String ?= null,
                    val localizedName: String ?= null,
                    val name: String ?= null
                )
                @Serializable
                data class Length(
                    val number: Int ?= null,
                    val unit: String ?= null
                )
            }
        }

        @Serializable
        data class ExtendedIngredient(
            val aisle: String ?= null,
            val amount: Double ?= null,
            val consistency: String ?= null,
            val id: Int ?= null,
            val image: String ?= null,
            val measures: Measures,
            val meta: List<String>,
            val name: String,
            val nameClean: String,
            val original: String,
            val originalName: String,
            val unit: String
        ) {
            @Serializable
            data class Measures(
                val metric: Metric,
                val us: Us
            ) {
                @Serializable
                data class Metric(
                    val amount: Double ?= null,
                    val unitLong: String ?= null,
                    val unitShort: String ?= null
                )
                @Serializable
                data class Us(
                    val amount: Double ?= null,
                    val unitLong: String ?= null,
                    val unitShort: String ?= null
                )
            }
        }
    }
}