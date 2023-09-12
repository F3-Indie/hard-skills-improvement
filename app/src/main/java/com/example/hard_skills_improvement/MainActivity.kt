package com.example.hard_skills_improvement

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hard_skills_improvement.navigation.Destinations
import com.example.hard_skills_improvement.navigation.MobileDevDestinations
import com.example.hard_skills_improvement.ui.HomeDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentDestination
import com.example.hard_skills_improvement.ui.MobileDevelopmentMatrixDestination
import com.example.hard_skills_improvement.ui.theme.Gray
import com.example.hard_skills_improvement.ui.theme.Green
import com.example.hard_skills_improvement.ui.theme.HardskillsimprovementTheme
import com.example.hard_skills_improvement.ui.theme.LightGray
import com.example.myuikit.BaseRectangleElevatedCard

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HardskillsimprovementTheme {
                Scaffold(topBar = { ScaffoldTopBar() }, containerColor = LightGray) {contentPaddingValues->
                    EmptyBackHandler()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Destinations.Home.route){
                        composable(Destinations.Home.route){
                            HomeDestination(contentPaddingValues){
                                navController.navigate(it)
                            }
                        }
                        composable(Destinations.MobileDevelopment.route){
                            MobileDevelopmentDestination(contentPaddingValues){
                                navController.navigate(it)
                            }
                        }
                        composable(MobileDevDestinations.Matrix.route){
                            MobileDevelopmentMatrixDestination(contentPaddingValues)
                        }
                        composable(MobileDevDestinations.Interview.route){
                            //TODO
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyBackHandler(){
    BackHandler {}
}

@Composable
private fun ScaffoldTopBar() {
    Box(
      Modifier
        .systemBarsPadding()
        .fillMaxWidth()
        .requiredHeight(64.dp)
        .background(Gray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dunice_logo),
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BaseCardBody(title : String? = null, description : String? = null) {
    Box {
        Column(modifier = Modifier.padding()) {
            title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                      .padding(vertical = 12.dp)
                      .padding(start = 12.dp, bottom = 8.dp)
                )
            }
            description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                      .padding(vertical = 12.dp)
                      .padding(start = 12.dp, end = 36.dp)
                )
            }
        }
        Image(
            painterResource(id = R.drawable.next_button),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Green),
            modifier = Modifier
                .requiredSize(48.dp)
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        )
    }
}