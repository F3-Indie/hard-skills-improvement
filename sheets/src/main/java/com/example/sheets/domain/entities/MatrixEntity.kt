package com.example.sheets.domain.entities

@Stable
data class MatrixEntity(
    val cardId: String,
    val cardBlock: String,
    val name: String,
    val value: Int?,
    val theoryLink: String?,
    val controlLink: String?
) {
    companion object {
        fun createFromArrayList(array: ArrayList<String>): MatrixEntity {
            return with(array) {
                MatrixEntity(
                    cardId = get(0),
                    cardBlock = get(1),
                    get(2),
                    get(3).toIntOrNull(),
                    getOrNull(4),
                    getOrNull(5)
                )
            }
        }
    }
}

