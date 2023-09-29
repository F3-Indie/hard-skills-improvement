package com.example.sheets.domain.entities

interface Args<T> {
    fun get(): T
}

fun <T> argsOf(provider: () -> T): Args<T> {
    return object : Args<T> {
        override fun get(): T = provider.invoke()
    }
}

fun <T> argsOf(vararg args: T): Args<List<T>> {
    return object : Args<List<T>> {
        override fun get() = args.toList()
    }
}

fun <T> argOf(arg: T): Args<T> {
    return object : Args<T> {
        override fun get(): T = arg
    }
}