package com.example.hard_skills_improvement

import androidx.lifecycle.ViewModel
import com.example.sheets.data.gateway.GoogleSheetAPIProvider
import com.example.sheets.domain.entities.MatrixEntity
import com.example.sheets.domain.entities.StabilityUndefined
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class MobileDepartmentMatrixState(
    val matrixEntity: MatrixEntity? = null
)

@StabilityUndefined("Данная viewmodel еще не проходила тестирования")
class MobileDepartmentMatrixViewModel(private val googleSheetAPIProvider: GoogleSheetAPIProvider) :
    ContainerHost<MobileDepartmentMatrixState, Unit>, ViewModel() {
    override val container =
        container<MobileDepartmentMatrixState, Unit>(MobileDepartmentMatrixState())

    fun loadMatrixData(matrixId: String) = intent {
        reduce {
            state.copy(
                matrixEntity = googleSheetAPIProvider.api?.findMatrixById(matrixId)?.getResult()
            )
        }
    }
}