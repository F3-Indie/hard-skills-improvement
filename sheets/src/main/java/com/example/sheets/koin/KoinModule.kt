package com.example.sheets.koin

import android.content.res.AssetManager
import com.example.sheets.data.gateway.AuthGatewayImpl
import com.example.sheets.data.gateway.SheetsServiceGatewayImpl
import com.example.sheets.domain.gateway.AuthGateway
import com.example.sheets.domain.gateway.ServiceGateway
import com.example.sheets.data.gateway.GoogleSheetAPIProvider
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.services.sheets.v4.Sheets
import org.koin.dsl.module

val koinModule = module {
    single<AuthGateway<GoogleCredential, AssetManager>> { AuthGatewayImpl() }
    single<ServiceGateway<Sheets, GoogleCredential>> { SheetsServiceGatewayImpl() }

    single { GoogleSheetAPIProvider(get(), get()) }
}