package com.example.hard_skills_improvement

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.lifecycle.coroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.hard_skills_improvement.services.AsyncProvider
import com.example.hard_skills_improvement.ui.HomeDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentMatrixDestination
import com.example.myuikit.ui.composables.CollectionElementsLayout
import com.example.myuikit.ui.composables.EmptyBackHandler
import com.example.myuikit.ui.composables.LoadingScreen
import com.example.myuikit.ui.composables.ScaffoldTopBar
import com.example.myuikit.ui.data.BaseCardValues
import com.example.myuikit.ui.theme.HardskillsimprovementTheme
import com.example.myuikit.ui.theme.LightGray
import com.example.navigation.Destinations
import com.example.navigation.MobileDevelopmentDestinations
import com.example.sheets.SheetsAPI
import com.example.sheets.data.SheetEntity
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.compose.collectAsState

class MainActivity : ComponentActivity() {
    
    private val googleServicesViewModel = GoogleServicesViewModel()
    private lateinit var mobileDepartmentViewModel: MobileDepartmentViewModel
    
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        lifecycle.coroutineScope.launch {
            val sheetApiProvider = AsyncProvider<SheetsAPI>().setup{
                SheetsAPI.build(this@MainActivity)
            }
            with(sheetApiProvider.getValue() as SheetsAPI){
                mobileDepartmentViewModel = MobileDepartmentViewModel(this)
                googleServicesViewModel.setup(this)
            }
        }
        
        setContent {
           
            val googleServiceState = googleServicesViewModel.collectAsState().value
            
            if (googleServiceState.sheetsAPI == null) {
                LoadingScreen()
            } else {
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
                                    MobileDevelopmentMatrixDestination(
                                        mobileDepartmentViewModel,
                                        contentPaddingValues
                                    ){
                                        navController.navigate(it)
                                    }
                                }
                                composable(MobileDevelopmentDestinations.MatrixInner.route) {
                                    val state = mobileDepartmentViewModel.collectAsState().value
                                    MatrixLayout(contentPaddingValues, state.matrix.entries.first().value)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MatrixLayout(contentPaddingValues: PaddingValues ,sheetEntity: SheetEntity) {
    Box(modifier = Modifier
        .systemBarsPadding()
        .navigationBarsPadding()){
        CollectionElementsLayout(
            collection = sheetEntity.rows.map { BaseCardValues(it.name, "null") },
            contentPaddingValues = contentPaddingValues
        )
    }
}
