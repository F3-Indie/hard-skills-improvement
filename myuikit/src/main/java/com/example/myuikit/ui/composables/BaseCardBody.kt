package com.example.myuikit.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.myuikit.R
import com.example.myuikit.ui.theme.Green

@Composable
fun BaseCardBody(title: String? = null, description: String? = null) {
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