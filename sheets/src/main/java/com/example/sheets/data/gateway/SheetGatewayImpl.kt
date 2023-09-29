package com.example.sheets.data.gateway

import com.example.sheets.domain.entities.GradeEntity
import com.example.sheets.domain.entities.MatrixEntity
import com.example.sheets.domain.entities.MatrixOrderedByGradeEntity
import com.example.sheets.domain.entities.Response
import com.example.sheets.domain.gateway.SheetGateway
import com.example.sheets.domain.entities.StabilityInTest
import com.google.api.services.sheets.v4.Sheets
import java.util.ArrayList

typealias ArrList<T> = ArrayList<T>

@StabilityInTest
class SheetGatewayImpl(private val sheets: Sheets) : SheetGateway {

    companion object {
        const val spreadsheetId = "11m6UFEqUZy4Jmx3AHmDsrxbbj2SBty6mYFXt1LEPLf0"
    }


    override fun findMatrixById(matrixId: String): Response<MatrixEntity> {
        val response = sheets.Spreadsheets().values().get(spreadsheetId, "All").execute()

        val result = (response.values.last() as MutableList<*>)
            .run {
                removeFirst()
                map { MatrixEntity.createFromArrayList(it as ArrayList<String>) }
                    .firstOrNull { it.cardId == matrixId }
            }


        return object : Response<MatrixEntity> {
            override fun getResult(): MatrixEntity? = result

            override fun isSuccess(): Boolean = result != null

        }
    }

    override fun getGrades(): Response<Collection<GradeEntity>> {
        return try {
            val response = sheets.Spreadsheets().values().get(spreadsheetId, "Grades").execute()
            val result = mutableListOf<GradeEntity>()
            (response.values
                .last() as MutableList<*>)
                .run {
                    removeFirst()
                    forEach {
                        if (it is ArrList<*>) {
                            result.add(GradeEntity.createFromArrayList(it as ArrayList<String>))
                        }
                    }

                }

            object : Response<Collection<GradeEntity>> {
                override fun getResult(): Collection<GradeEntity> = result
                override fun isSuccess(): Boolean = true
            }
        } catch (e: Exception) {
            object : Response<Collection<GradeEntity>> {
                override fun getResult(): Collection<GradeEntity>? = null
                override fun isSuccess(): Boolean = false
            }
        }
    }

    override fun findByGrade(grade: GradeEntity): Response<MatrixOrderedByGradeEntity> {
        val result = mutableListOf<MatrixEntity>()
        return try {
            val response = sheets.Spreadsheets().values().get(spreadsheetId, grade.name).execute()
            (response.values
                .last() as MutableList<*>)
                .run {
                    removeFirst()
                    forEach {
                        if (it is ArrList<*>) {
                            result.add(MatrixEntity.createFromArrayList(it as ArrayList<String>))
                        }
                    }

                }

            object : Response<MatrixOrderedByGradeEntity> {
                override fun getResult(): MatrixOrderedByGradeEntity =
                    MatrixOrderedByGradeEntity(grade.name, result)
                override fun isSuccess(): Boolean = true
            }
        } catch (e: Exception) {
            object : Response<MatrixOrderedByGradeEntity> {
                override fun getResult(): MatrixOrderedByGradeEntity =
                    MatrixOrderedByGradeEntity(grade.name, result)
                override fun isSuccess(): Boolean = false
            }
        }
    }
}