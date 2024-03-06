package com.joel.yumyard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Onboarding.route
    ){
        composable(route = Screens.Onboarding.route){

        }
        composable(route = Screens.Discover.route){

        }
        composable(route = Screens.Search.route){

        }
        composable(route = Screens.Favorites.route){

        }
        composable(route = Screens.Profile.route){

        }
        composable(route = Screens.MealPlan.route){

        }

    }
}