package com.example.hard_skills_improvement

import org.koin.dsl.module

val koinModule = module {
    single { MobileDepartmentViewModel(get()) }
    single { MobileDepartmentMatrixViewModel(get()) }
}