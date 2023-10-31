package com.example.hard_skills_improvement

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.coroutineScope
import com.example.sheets.data.gateway.GoogleSheetAPIProvider
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.hard_skills_improvement.koinModule as coreKoinModule
import com.example.sheets.koin.koinModule as sheetKoinModule
//TODO добавил строчку

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(coreKoinModule, sheetKoinModule)
        }

        val googleSheetAPIProvider = get<GoogleSheetAPIProvider>()
        lifecycle.coroutineScope.launch(googleSheetAPIProvider.createExceptionHandler(context = this)) {
            googleSheetAPIProvider.install(assets)
        }

        setContent {
            HardSkillsImprovementApp()
        }
    }
}