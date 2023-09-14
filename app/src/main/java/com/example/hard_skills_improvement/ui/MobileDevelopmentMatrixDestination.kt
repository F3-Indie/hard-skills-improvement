package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myuikit.R
import com.example.myuikit.ui.composables.BaseCardBody
import com.example.myuikit.ui.composables.BaseRectangleElevatedCard

@Composable
fun MobileDevelopmentMatrixDestination(contentPaddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(contentPaddingValues)) {
        BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_trainee_title),
                description = stringResource(id = R.string.card_mobile_dev_trainee_description)
            )
        }
        BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_junior_title),
                description = stringResource(id = R.string.card_mobile_dev_junior_description)
            )
        }
        BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_premiddle_title),
                description = stringResource(id = R.string.card_mobile_dev_premiddle_description)
            )
        }
        BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_middle_title),
                description = stringResource(id = R.string.card_mobile_dev_middle_description)
            )
        }
    }
}