package com.joel.authentication.onboarding.utils

import com.joel.authentication.R

data class OnboardingItems(
    val image : Int,
    val titleHeader : Int,
    val screenDescription : Int
) {
    companion object{
        fun getData(): List<OnboardingItems>{
            return listOf(
                OnboardingItems(
                    image = R.drawable.enjoying_meal,
                    titleHeader =  R.string.endless_meal_ideas,
                    R.string.endless_meal_ideas_desc
                ),
                OnboardingItems(
                    image = R.drawable.meal_plan_image,
                    titleHeader =  R.string.organise_your_meal_plans,
                    R.string.organise_your_meal_plans_desc
                ),
                OnboardingItems(
                    image = R.drawable.favourites_recipes,
                    titleHeader =  R.string.save_your_favourites,
                    R.string.save_your_favourites_desc
                )
            )
        }
    }
}