package com.example.hard_skills_improvement.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hard_skills_improvement.MatrixLayout
import com.example.hard_skills_improvement.ui.MobileDepartmentMatrixScreen
import com.example.navigation.Destinations
import com.example.navigation.MobileDevelopmentDestinations

fun mobileDepartmentGroupNavigation(
    navController: NavHostController,
    builder: NavGraphBuilder,
    contentPaddingValues: PaddingValues
) {
    with(builder) {
        navigation(
            startDestination = Destinations.MobileDevelopment.route,
            route = MobileDevelopmentDestinations.route
        ) {
            composable(MobileDevelopmentDestinations.Matrix.route) {
                MobileDepartmentMatrixScreen(
                    contentPaddingValues
                ) {
                    navController.navigate(it)
                }
            }
            composable("${MobileDevelopmentDestinations.MatrixInner.route}/{grade}") { backStackEntry ->
                val argument =
                    backStackEntry.arguments?.getString("grade", "Trainee")
                        ?: "Trainee"
                MatrixLayout(
                    contentPaddingValues,
                    argument
                ) {
                    navController.navigate(it)
                }
            }
        }
    }
}

