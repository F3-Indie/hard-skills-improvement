package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hard_skills_improvement.MobileDepartmentViewModel
import com.example.myuikit.ui.composables.BaseCardBody
import com.example.myuikit.ui.composables.BaseRectangleElevatedCard
import com.example.myuikit.ui.composables.LoadingScreen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MobileDevelopmentMatrixDestination(viewModel: MobileDepartmentViewModel, contentPaddingValues: PaddingValues) {
    val state = viewModel.collectAsState().value
    
    LaunchedEffect(key1 = Unit){
        viewModel.loadDepartmentMatrix()
    }
    
    if(state.matrix.isEmpty()){
        LoadingScreen()
    }else{
        Column(modifier = Modifier.padding(contentPaddingValues)) {
            state.matrix.forEach{
                BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
                    BaseCardBody(
                        title = it.key,
                        description = "null"
                    )
                }
            }
        }
    }
}