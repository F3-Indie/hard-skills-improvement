package com.example.sheets.domain.entities

@Stable
data class MatrixOrderedByGradeEntity(
    val name: String,
    val matrix: Collection<MatrixEntity>
)