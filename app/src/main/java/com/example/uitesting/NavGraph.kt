package com.example.uitesting

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    // Setting up the navigation host with the starting destination
    NavHost(
        navController = navController,
        startDestination = "appStartNavigation"
    ) {
        // Declaring the navigation graph for different sections
        homeNavGraph(navController)
    }
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    // Defining the navigation graph for the home section
    navigation(
        startDestination = "HomeScreen",
        route =  "appStartNavigation"
    ) {
        // Composable for the Home screen
        composable(
            route = "HomeScreen"
        ) {
            HomeScreen(navController)
        }

        // Composable for the Settings screen
        composable(
            route = "SettingsScreen"
        ) {
            SettingsScreen(navController)
        }
    }
}
