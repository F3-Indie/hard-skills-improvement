package com.example.sheets.domain.entities

data class SheetEntity(
    val name : String,
    val rows: List<MatrixEntity>
)