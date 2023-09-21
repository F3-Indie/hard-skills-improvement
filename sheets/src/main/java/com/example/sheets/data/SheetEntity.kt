package com.example.sheets.data

data class SheetEntity(
    val name : String,
    val rows: List<MatrixEntity>
)