package com.example.myuikit.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuikit.ui.data.BaseCardValues

@Composable
fun CollectionElementsLayout(collection : List<BaseCardValues>, contentPaddingValues : PaddingValues){
    Column(modifier = Modifier.padding(contentPaddingValues)) {
        collection.forEach {
            BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp)) {
                BaseCardBody(
                    title = it.title,
                    description = it.description
                )
            }
        }
    }
}