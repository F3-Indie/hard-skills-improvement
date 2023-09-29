package com.example.sheets.domain.entities

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Stable()
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Unstable(val reason : String)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StabilityInTest()
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class StabilityUndefined(val reason : String)