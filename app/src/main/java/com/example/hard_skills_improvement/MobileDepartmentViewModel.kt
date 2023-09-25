package com.example.hard_skills_improvement

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sheets.SheetsAPI
import com.example.sheets.domain.entities.Grade
import com.example.sheets.domain.entities.SheetEntity
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.lang.Exception

data class MobileDepartmentState(
    val matrix : Map<String, SheetEntity>
){
    val matrixOrderedByGrade get() = matrix.keys.zip(matrix.values)
}

class MobileDepartmentViewModel(private val sheetsAPI: SheetsAPI) : ContainerHost<MobileDepartmentState, Unit>, ViewModel() {
    override val container = container<MobileDepartmentState, Unit>(MobileDepartmentState(emptyMap()))
    
    fun loadDepartmentMatrix() = intent {
        reduce {
            val loadedData = mutableMapOf<String, SheetEntity>()
            Grade.values().forEach {
                try {
                    loadedData[it.name] = sheetsAPI.getByGrade(it)
                }catch (e : Exception){
                    Log.e("MobileDepartment", "Something wrong with loading $it data")
                }
            }
    
            state.copy(matrix = loadedData)
        }
    }
}