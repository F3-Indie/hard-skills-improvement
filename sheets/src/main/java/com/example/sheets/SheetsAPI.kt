package com.example.sheets

import android.content.Context
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.gson.Gson

data class SheetsAPIConfig(
    val spreadsheetId: String,
    val applicationName: String
)

class SheetsAPI private constructor(
    private var service: Sheets,
    private var sheetsConfig: SheetsAPIConfig
) {
    
    companion object {
        private const val credentialsPath = "credentials.json"
        private const val configPath = "config.json"
        
        fun build(context: Context): SheetsAPI {
            val credential =
                GoogleCredential.fromStream(context.assets.open(credentialsPath))
                    .createScoped(SheetsScopes.all())
            val gson = Gson()
            val sheetsConfig = gson.fromJson(
                gson.toJson(context.assets.open(configPath)),
                SheetsAPIConfig::class.java
            )
            
            val service = Sheets.Builder(
                AndroidHttp.newCompatibleTransport(),
                JacksonFactory.getDefaultInstance(),
                credential
            )
                .setApplicationName(sheetsConfig.applicationName)
                .build()
            
            return SheetsAPI(service, sheetsConfig)
        }
    }
}