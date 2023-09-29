package com.example.sheets.domain.entities

@Stable
interface Response<T> {
    fun getResult(): T?
    fun isSuccess(): Boolean
}