package com.example.sheets.domain.entities

data class MatrixEntity(
    val cardId : String,
    val cardBlock : CardBlock,
    val name : String,
    val value : Int?,
    val theoryLink : String,
    val controlLink : String
)

data class MatrixDto(
    val cardId : String?,
    val cardBlock : String?,
    val name : String?,
    val value : String?,
    val theoryLink : String?,
    val controlLink : String?
)