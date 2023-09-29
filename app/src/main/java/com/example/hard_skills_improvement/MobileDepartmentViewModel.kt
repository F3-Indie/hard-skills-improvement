package com.example.hard_skills_improvement

import androidx.lifecycle.ViewModel
import com.example.sheets.data.gateway.GoogleSheetAPIProvider
import com.example.sheets.domain.entities.MatrixOrderedByGradeEntity
import com.example.sheets.domain.entities.StabilityUndefined
import com.example.sheets.domain.entities.Unstable
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class MobileDepartmentState(
    val matrix: Map<String, MatrixOrderedByGradeEntity>
) {
    val matrixOrderedByGrade get() = matrix.keys.zip(matrix.values)
}

@Unstable("При неправильной загрузке данных или ошибке во время загрузки приложение" +
        " упадет в бесконечную загрузку с экраном загрузки")
class MobileDepartmentViewModel(private val googleSheetAPIProvider: GoogleSheetAPIProvider) :
    ContainerHost<MobileDepartmentState, Unit>, ViewModel() {
    override val container =
        container<MobileDepartmentState, Unit>(MobileDepartmentState(emptyMap()))

    fun loadDepartmentMatrix() = intent {
        reduce {
            val loadedData = mutableMapOf<String, MatrixOrderedByGradeEntity>()
            googleSheetAPIProvider.api?.let { repository ->
                repository.getGrades().getResult()?.forEach {
                    loadedData[it.name] =
                        repository.findByGrade(it).getResult() ?: throw NullPointerException()
                }
            }
            state.copy(matrix = loadedData)
        }
    }
}

