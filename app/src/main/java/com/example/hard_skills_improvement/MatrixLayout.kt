package com.example.hard_skills_improvement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hard_skills_improvement.ui.MatrixCardsLayout
import com.example.navigation.Destinations
import org.koin.compose.koinInject
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MatrixLayout(
    contentPaddingValues: PaddingValues,
    grade: String,
    viewModel: MobileDepartmentViewModel = koinInject(),
    onNavigate: ((String) -> Unit)? = null
) {

    val state = viewModel.collectAsState().value
    val collection = state.matrix[grade]?.matrix ?: emptyList()
    Box(
        modifier = Modifier
            .systemBarsPadding()
            .navigationBarsPadding()
    ) {
        MatrixCardsLayout(
            collection = collection,
            contentPaddingValues = contentPaddingValues
        ) {
            onNavigate?.invoke("${Destinations.WebView.route}/${it}")
        }
    }
}