package com.example.sheets.domain.gateway

import com.example.sheets.domain.entities.Args
import com.example.sheets.domain.entities.Response
import com.example.sheets.domain.entities.Stable

@Stable
interface AuthGateway<T, R> {
    suspend fun getCredentials(args: Args<R>): Response<T>
}

