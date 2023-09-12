package com.example.myuikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Stable
private val shadowElevation = 4.dp


@Composable
fun BaseRectangleElevatedCard(
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    Surface(
        shape = RectangleShape,
        shadowElevation = shadowElevation,
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
            .padding(paddingValues = contentPaddingValues)
            .background(
                shape = RectangleShape,
                color = Color(color = 0xFFDCDCDC)
            )
            .then(modifier)
    ) {
        content.invoke()
    }
}