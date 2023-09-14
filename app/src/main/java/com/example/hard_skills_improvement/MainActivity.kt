package com.example.hard_skills_improvement

import com.example.myuikit.ui.composables.EmptyBackHandler
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.hard_skills_improvement.ui.HomeDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentMatrixDestination
import com.example.myuikit.ui.composables.ScaffoldTopBar
import com.example.myuikit.ui.theme.HardskillsimprovementTheme
import com.example.myuikit.ui.theme.LightGray
import com.example.navigation.Destinations
import com.example.navigation.MobileDevelopmentDestinations

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HardskillsimprovementTheme {
                Scaffold(
                    topBar = { ScaffoldTopBar() },
                    containerColor = LightGray
                ) { contentPaddingValues ->
                    EmptyBackHandler()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.route
                    ) {
                        navigation(
                            startDestination = Destinations.Home.route,
                            route = Destinations.route
                        ) {
                            composable(Destinations.Home.route) {
                                HomeDestination(contentPaddingValues) {
                                    navController.navigate(it)
                                }
                            }
                            composable(Destinations.MobileDevelopment.route) {
                                MobileDevelopmentDestination(contentPaddingValues) {
                                    navController.navigate(it)
                                }
                            }
                        }
                        navigation(startDestination = Destinations.MobileDevelopment.route, route = MobileDevelopmentDestinations.route){
                            composable(MobileDevelopmentDestinations.Matrix.route){
                                MobileDevelopmentMatrixDestination(contentPaddingValues)
                            }
                        }
                    }
                }
            }
        }
    }
}

