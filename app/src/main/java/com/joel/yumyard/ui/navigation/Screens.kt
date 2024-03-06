package com.joel.yumyard.ui.navigation

import com.joel.design.icons.UzitoIcons
import com.joel.yumyard.R

sealed class Screens(
    val route : String,
    val icon : Int? = null,
    val title : Int ?= null
) {

    data object Discover : Screens(
        route = "discover_route",
        icon = UzitoIcons.home,
        title = com.joel.design.R.string.discover_title
    )
    data object Search : Screens(
        route = "search_route",
        icon = UzitoIcons.search,
        title = com.joel.design.R.string.discover_title
    )
    data object Favorites : Screens(
        route = "favorites_route",
        icon = UzitoIcons.favorites,
        title = com.joel.design.R.string.favorites_title
    )
    data object Profile : Screens(
        route = "profile_route",
        icon = UzitoIcons.profile,
        title = com.joel.design.R.string.profile_title
    )
    data object MealPlan : Screens(
        route = "meal_plan_route",
    )
    data object Onboarding : Screens(
        route = "onboarding_route",
    )

}

val bottomBarNavigationList = listOf(
    Screens.Discover,
    Screens.Search,
    Screens.Favorites,
    Screens.Profile
)