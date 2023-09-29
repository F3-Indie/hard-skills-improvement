package com.example.sheets.domain.entities

@Stable
data class GradeEntity(
    val id: String,
    val name: String
) {
    companion object{
        fun createFromArrayList(array: ArrayList<String>) : GradeEntity {
            return with(array) {
                GradeEntity(get(0), get(1))
            }
        }
    }
}