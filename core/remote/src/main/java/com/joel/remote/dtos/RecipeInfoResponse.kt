package com.joel.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class RecipeInfoResponse(
    val aggregateLikes: Int ?= null,
    val analyzedInstructions: List<String> = emptyList(),
    val cheap: Boolean ?= null,
    val cookingMinutes: Int ?= null,
    val creditsText: String ?= null,
    val cuisines: List<String> ?= emptyList(),
    val dairyFree: Boolean ?= null,
    val diets: List<String> ?= emptyList(),
    val dishTypes: List<String> ?= null,
    val extendedIngredients: List<ExtendedIngredient> = emptyList(),
    val gaps: String ?= null,
    val glutenFree: Boolean ?= false,
    val healthScore: Int?= null,
    val id: Int ?= null,
    val image: String ?= null,
    val imageType: String ?= null,
    val instructions: String ?= null,
    val license: String ?= null,
    val lowFodmap: Boolean ?= false,
    val nutrition: Nutrition ?= null,
    val occasions: List<String> = emptyList(),
    val originalId: Int ?= null,
    val preparationMinutes: Int ?= null,
    val pricePerServing: Double ?= null,
    val readyInMinutes: Int ?= null,
    val servings: Int ?= null,
    val sourceName: String ?= null,
    val sourceUrl: String ?= null,
    val spoonacularScore: Double ?= null,
    val spoonacularSourceUrl: String ?= null,
    val summary: String ?= null,
    val sustainable: Boolean ?= null,
    val title: String ?= null,
    val vegan: Boolean ?= null,
    val vegetarian: Boolean ?= null,
    val veryHealthy: Boolean ?= null,
    val veryPopular: Boolean ?= null,
    val weightWatcherSmartPoints: Int ?= null,
    val winePairing: WinePairing
) {

    @Serializable
    data class ExtendedIngredient(
        val aisle: String ? = null,
        val amount: Double ?= null,
        val consistency: String ?= null,
        val id: Int ?= null,
        val image: String ?= null,
        val measures: Measures ? = null,
        val meta: List<String> = emptyList(),
        val name: String ?= null,
        val nameClean: String ?= null,
        val original: String ?= null,
        val originalName: String ?= null,
        val unit: String ?= null
    ) {

        @Serializable
        data class Measures(
            val metric: Metric ?= null,
            val us: Us ? = null
        )

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
            val unitShort: String ? = null
        )

    }

    @Serializable
    data class Nutrition(
        val caloricBreakdown: CaloricBreakdown,
        val flavonoids: List<Flavonoid>,
        val ingredients: List<Ingredient>,
        val nutrients: List<NutrientX>,
        val properties: List<Property>,
        val weightPerServing: WeightPerServing
    ) {

        @Serializable
        data class CaloricBreakdown(
            val percentCarbs: Double ?= null,
            val percentFat: Double ? = null,
            val percentProtein: Double ?= null
        )

        @Serializable
        data class Flavonoid(
            val amount: Double ?= null,
            val name: String ?= null,
            val unit: String ?= null
        )

        @Serializable
        data class Ingredient(
            val amount: Double ?= null,
            val id: Int ?= null,
            val name: String ?= null,
            val nutrients: List<NutrientX> = emptyList(),
            val unit: String ?= null
        )

        @Serializable
        data class NutrientX(
            val amount: Double ?= null,
            val name: String ?= null,
            val percentOfDailyNeeds: Double ?= null,
            val unit: String ?= null
        )

        @Serializable
        data class Property(
            val amount: Double ?= null,
            val name: String ?= null,
            val unit: String ?= null
        )

        @Serializable
        data class WeightPerServing(
            val amount: Int ? = null,
            val unit: String ?= null
        )
    }

    @Serializable
    data class WinePairing(
        val pairedWines: List<String> = emptyList(),
        val pairingText: String ?= null,
        val productMatches: List<String> = emptyList()
    )


}