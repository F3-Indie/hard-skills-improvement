package com.example.hard_skills_improvement

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hard_skills_improvement.navigation.MatrixScreen
import com.example.hard_skills_improvement.navigation.homeGroupNavigation
import com.example.hard_skills_improvement.navigation.mobileDepartmentGroupNavigation
import com.example.hard_skills_improvement.ui.HomeDestination
import com.example.myuikit.ui.composables.EmptyBackHandler
import com.example.myuikit.ui.composables.LoadingScreen
import com.example.myuikit.ui.composables.ScaffoldTopBar
import com.example.myuikit.ui.theme.HardskillsimprovementTheme
import com.example.myuikit.ui.theme.LightGray
import com.example.navigation.Destinations
import com.example.sheets.data.gateway.GoogleSheetAPIProvider
import org.koin.compose.koinInject

@Composable
fun HardSkillsImprovementApp() {
    val navController = rememberNavController()
    HardSkillsImprovementNavHost(navController)
}

@Composable
fun HardSkillsImprovementNavHost(navController: NavHostController) {
    if (koinInject<GoogleSheetAPIProvider>().api == null) {
        LoadingScreen()
    } else {
        HardskillsimprovementTheme {
            Scaffold(
                topBar = { ScaffoldTopBar() },
                containerColor = LightGray
            ) { contentPaddingValues ->
                EmptyBackHandler()
                NavHost(
                    navController = navController,
                    startDestination = Destinations.Home.route
                ) {
                    composable(Destinations.Home.route) {
                        HomeDestination(contentPaddingValues) {
                            navController.navigate(it)
                        }
                    }
                    composable("${Destinations.WebView.route}/{id}") { backStackEntry ->
                        val matrixId = backStackEntry.arguments?.getString("id", "") ?: ""
                        MatrixScreen(matrixId)
                    }
                    homeGroupNavigation(navController, this, contentPaddingValues)
                    mobileDepartmentGroupNavigation(navController, this, contentPaddingValues)
                }
            }
        }
    }
}


