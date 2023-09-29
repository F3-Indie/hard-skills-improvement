package com.example.hard_skills_improvement.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.hard_skills_improvement.MobileDepartmentMatrixViewModel
import com.example.myuikit.ui.composables.WebViewLayout
import org.koin.compose.koinInject
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MatrixScreen(matrixId : String, viewModel: MobileDepartmentMatrixViewModel = koinInject()){

    val state = viewModel.collectAsState().value

    LaunchedEffect(key1 = state) {
        viewModel.loadMatrixData(matrixId)
    }

    if(state.matrixEntity != null){
        WebViewLayout(state.matrixEntity.theoryLink ?: "")
    }

}