package com.example.hard_skills_improvement.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_skills_improvement.BaseCardBody
import com.example.hard_skills_improvement.R
import com.example.hard_skills_improvement.navigation.Destinations
import com.example.hard_skills_improvement.navigation.MobileDevDestinations
import com.example.myuikit.BaseRectangleElevatedCard

@Composable
fun MobileDevelopmentDestination(contentPaddingValues: PaddingValues,  onNavigate : (String)->Unit){
    Column(modifier = Modifier.padding(contentPaddingValues)) {
        BaseRectangleElevatedCard(
            modifier = Modifier.clickable { onNavigate.invoke(MobileDevDestinations.Matrix.route) },
            contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_matrix_title),
                description = stringResource(id = R.string.card_mobile_dev_matrix_description)
            )
        }
        BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
            BaseCardBody(
                title = stringResource(id = R.string.card_mobile_dev_interview_title),
                description = stringResource(id = R.string.card_mobile_dev_interview_description)
            )
        }
    }
}