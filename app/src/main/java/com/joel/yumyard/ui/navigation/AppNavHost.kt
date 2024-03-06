package com.joel.yumyard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.authentication.onboarding.OnboardingScreen
import com.joel.discover.DiscoverScreen
import com.joel.favourites.FavouritesScreen
import com.joel.mealplan.MealPlanScreen
import com.joel.mealplan.ProfileScreen
import com.joel.search.SearchScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    updateBottomBarState: (Boolean) -> Unit,
    startDestination : String
){

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screens.Onboarding.route){
            updateBottomBarState(false)
            OnboardingScreen()
        }
        composable(route = Screens.Discover.route){
            updateBottomBarState(true)
            DiscoverScreen()
        }
        composable(route = Screens.Search.route){
            updateBottomBarState(true)
            SearchScreen()
        }
        composable(route = Screens.Favorites.route){
            updateBottomBarState(true)
            FavouritesScreen()
        }
        composable(route = Screens.Profile.route){
            updateBottomBarState(true)
            ProfileScreen()
        }
        composable(route = Screens.MealPlan.route){
            updateBottomBarState(false)
            MealPlanScreen()
        }
    }
}