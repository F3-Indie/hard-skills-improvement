package com.example.hard_skills_improvement.services

import android.app.Activity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

class AsyncProvider<T> {
    private var job: Deferred<T>? = null
    suspend fun getValue() = job?.await()
    
    suspend fun setup(provider: suspend CoroutineScope.()->T): AsyncProvider<T> = coroutineScope {
        job?.cancel()
        job = async { provider.invoke(this) }
        
        return@coroutineScope this@AsyncProvider
    }
}