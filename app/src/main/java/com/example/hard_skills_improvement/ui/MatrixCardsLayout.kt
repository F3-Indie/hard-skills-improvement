package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuikit.ui.composables.BaseCardBody
import com.example.myuikit.ui.composables.BaseRectangleElevatedCard
import com.example.sheets.domain.entities.MatrixEntity

@Composable
fun MatrixCardsLayout(
    contentPaddingValues: PaddingValues,
    collection: Collection<MatrixEntity>,
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
                modifier = Modifier.clickable { onNavigate?.invoke(it.cardId) }) {
                BaseCardBody(
                    title = it.name,
                    description = it.cardId
                )
            }
        }
    }
}