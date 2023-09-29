package com.example.hard_skills_improvement.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hard_skills_improvement.ui.MobileDevelopmentDestination
import com.example.navigation.Destinations

fun homeGroupNavigation(
    navController: NavHostController,
    builder: NavGraphBuilder,
    contentPaddingValues: PaddingValues
) {
    with(builder) {
        navigation(
            startDestination = Destinations.Home.route,
            route = Destinations.route
        ) {
            composable(Destinations.MobileDevelopment.route) {
                MobileDevelopmentDestination(contentPaddingValues) {
                    navController.navigate(it)
                }
            }
        }
    }
}