package com.example.hard_skills_improvement

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.hard_skills_improvement.ui.HomeDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentMatrixDestination
import com.example.myuikit.ui.composables.EmptyBackHandler
import com.example.myuikit.ui.composables.LoadingScreen
import com.example.myuikit.ui.composables.ScaffoldTopBar
import com.example.myuikit.ui.theme.HardskillsimprovementTheme
import com.example.myuikit.ui.theme.LightGray
import com.example.navigation.Destinations
import com.example.navigation.MobileDevelopmentDestinations
import org.orbitmvi.orbit.compose.collectAsState

class MainActivity : ComponentActivity() {
    
    private val googleServicesViewModel = GoogleServicesViewModel()
    private lateinit var mobileDepartmentViewModel: MobileDepartmentViewModel
    
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val googleServiceState = googleServicesViewModel.collectAsState().value
            
            LaunchedEffect(key1 = Unit){
                googleServicesViewModel.connectServices(this@MainActivity)
            }
            
            if (googleServiceState.sheetsAPI == null) {
                LoadingScreen()
            } else {
                mobileDepartmentViewModel = MobileDepartmentViewModel(googleServiceState.sheetsAPI)
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
                            navigation(
                                startDestination = Destinations.MobileDevelopment.route,
                                route = MobileDevelopmentDestinations.route
                            ) {
                                composable(MobileDevelopmentDestinations.Matrix.route) {
                                    MobileDevelopmentMatrixDestination(mobileDepartmentViewModel, contentPaddingValues)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

