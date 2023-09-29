package com.example.sheets.domain.gateway

import com.example.sheets.domain.entities.GradeEntity
import com.example.sheets.domain.entities.MatrixEntity
import com.example.sheets.domain.entities.MatrixOrderedByGradeEntity
import com.example.sheets.domain.entities.Response
import com.example.sheets.domain.entities.StabilityInTest

@StabilityInTest
interface SheetGateway {
    fun findMatrixById(matrixId: String): Response<MatrixEntity>
    fun getGrades() : Response<Collection<GradeEntity>>
    fun findByGrade(grade : GradeEntity) : Response<MatrixOrderedByGradeEntity>
}
