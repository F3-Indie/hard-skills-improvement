package com.example.sheets

import android.content.Context
import android.util.Log
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes

private val spreadsheetId = "11m6UFEqUZy4Jmx3AHmDsrxbbj2SBty6mYFXt1LEPLf0"

class Test {
  fun t(context: Context) {
    val credential =
      GoogleCredential.fromStream(context.assets.open("credentials.json"))
        .createScoped(SheetsScopes.all())
  
    val service = Sheets.Builder(
      AndroidHttp.newCompatibleTransport(),
      JacksonFactory.getDefaultInstance(),
      credential
    )
      .setApplicationName("hard-skills-improvement")
      .build()
  
    val response = service.Spreadsheets()
      .values()[spreadsheetId, "Trainee!A:F"]
      .execute()
    
    Log.e("RESPONSE", response.toPrettyString())
  }
}