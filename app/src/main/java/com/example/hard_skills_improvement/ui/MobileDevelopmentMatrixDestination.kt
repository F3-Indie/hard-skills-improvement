package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hard_skills_improvement.MobileDepartmentViewModel
import com.example.myuikit.ui.composables.BaseCardBody
import com.example.myuikit.ui.composables.BaseRectangleElevatedCard
import com.example.myuikit.ui.composables.LoadingScreen
import com.example.navigation.MobileDevelopmentDestinations
import com.example.sheets.data.SheetEntity
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MobileDevelopmentMatrixDestination(
    viewModel: MobileDepartmentViewModel,
    contentPaddingValues: PaddingValues,
    onNavigate: ((String) -> Unit)? = null
) {
    val state = viewModel.collectAsState().value
    
    LaunchedEffect(key1 = Unit) {
        viewModel.loadDepartmentMatrix()
    }
    
    if (state.matrix.isEmpty()) {
        LoadingScreen()
    } else {
        MatrixByGradeLayout(
            collection = state.matrixOrderedByGrade.map { it.second },
            contentPaddingValues = contentPaddingValues,
            onNavigate = {
                onNavigate?.invoke("${MobileDevelopmentDestinations.MatrixInner.route}/$it")
            }
        )
    }
}

@Composable
fun MatrixByGradeLayout(
    contentPaddingValues: PaddingValues,
    collection: List<SheetEntity>,
    onNavigate: ((String) -> Unit)?
) {
    Column(
        modifier = Modifier
            .padding(contentPaddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        collection.forEach {
            BaseRectangleElevatedCard(
                contentPaddingValues = PaddingValues(12.dp),
                modifier = Modifier.clickable { onNavigate?.invoke(it.name) }) {
                BaseCardBody(
                    title = it.name,
                    description = null
                )
            }
        }
    }
}

