package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myuikit.R
import com.example.myuikit.ui.composables.BaseCardBody
import com.example.navigation.Destinations
import com.example.myuikit.ui.composables.BaseRectangleElevatedCard

@Composable
fun HomeDestination(contentPaddingValues: PaddingValues, onNavigate : (String)->Unit){
    val defaultCardPaddings = remember {
        PaddingValues(
            horizontal = 12.dp,
            vertical = contentPaddingValues.calculateTopPadding() + 12.dp
        )
    }
    BaseRectangleElevatedCard(
        modifier = Modifier.clickable { onNavigate.invoke(Destinations.MobileDevelopment.route) },
        contentPaddingValues = defaultCardPaddings
    ) {
        BaseCardBody(
            title = stringResource(id = R.string.card_mobile_dev_title),
            description = stringResource(id = R.string.card_mobile_dev_description)
        )
    }
}