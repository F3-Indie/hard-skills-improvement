package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.hard_skills_improvement.MobileDepartmentViewModel
import com.example.myuikit.ui.composables.CollectionElementsLayout
import com.example.myuikit.ui.composables.LoadingScreen
import com.example.myuikit.ui.data.BaseCardValues
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MobileDevelopmentMatrixDestination(
    viewModel: MobileDepartmentViewModel,
    contentPaddingValues: PaddingValues
) {
    val state = viewModel.collectAsState().value
    
    LaunchedEffect(key1 = Unit) {
        viewModel.loadDepartmentMatrix()
    }
    
    if (state.matrix.isEmpty()) {
        LoadingScreen()
    } else {
        CollectionElementsLayout(
            collection = state.matrix.keys.zip(state.matrix.values)
                .map { BaseCardValues(it.first, "null") }, contentPaddingValues
        )
    }
}

