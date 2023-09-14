package com.example.myuikit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myuikit.R
import com.example.myuikit.ui.theme.Gray

@Composable
fun ScaffoldTopBar() {
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