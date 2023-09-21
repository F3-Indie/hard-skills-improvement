package com.example.hard_skills_improvement

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.sheets.SheetsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

data class GoogleServicesState(
    val sheetsAPI: SheetsAPI? = null
)

class GoogleServicesViewModel : ContainerHost<GoogleServicesState, Unit>, ViewModel() {
    override val container = container<GoogleServicesState, Unit>(GoogleServicesState())
    
    /*suspend fun connectServices(context: Context) = intent {
        coroutineScope {
            val api = SheetsAPI.build(context)
            reduce {
                state.copy(sheetsAPI = api)
            }
        }
    }*/
    
    fun setup(sheetsAPI: SheetsAPI) = intent {
        reduce {
            state.copy(sheetsAPI = sheetsAPI)
        }
    }
}