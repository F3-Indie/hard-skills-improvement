package com.example.myuikit.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myuikit.ui.data.BaseCardValues
import com.example.sheets.data.MatrixEntity

@Composable
fun CollectionElementsLayout(collection : List<BaseCardValues>, contentPaddingValues : PaddingValues = PaddingValues(), onNavigate : ((String) -> Unit)? = null){
    Column(modifier = Modifier
        .padding(contentPaddingValues)
        .verticalScroll(rememberScrollState())) {
        collection.forEach {
            BaseRectangleElevatedCard(contentPaddingValues = PaddingValues(12.dp), modifier = Modifier.clickable{onNavigate?.invoke(it.title)}) {
                BaseCardBody(
                    title = it.title,
                    description = it.description
                )
            }
        }
    }
}