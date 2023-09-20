package com.example.sheets.data

data class SheetRowEntity(
    val cardId : Int,
    val cardBlock : CardBlock,
    val name : String,
    val value : Int?,
    val theoryLink : String,
    val controlLink : String
)