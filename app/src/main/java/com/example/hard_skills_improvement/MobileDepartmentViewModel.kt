package com.example.hard_skills_improvement

import androidx.lifecycle.ViewModel
import com.example.sheets.SheetsAPI
import com.example.sheets.data.Grade
import com.example.sheets.data.SheetEntity
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class MobileDepartmentState(
    val matrix : List<SheetEntity>
)

class MobileDepartmentViewModel(private val sheetsAPI: SheetsAPI) : ContainerHost<MobileDepartmentState, Unit>, ViewModel() {
    override val container = container<MobileDepartmentState, Unit>(MobileDepartmentState(emptyList()))
    
    fun loadDepartmentMatrix(number: Int) = intent {
        reduce {
            val loadedData = mutableListOf<SheetEntity>()
            Grade.values().forEach {
                loadedData.add(sheetsAPI.getByGrade(it))
            }
    
            state.copy(matrix = loadedData)
        }
    }
}