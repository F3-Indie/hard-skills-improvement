package com.example.sheets.data.gateway

import com.example.sheets.domain.entities.Args
import com.example.sheets.domain.entities.Response
import com.example.sheets.domain.entities.Stable
import com.example.sheets.domain.gateway.ServiceGateway
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@Stable
class SheetsServiceGatewayImpl :
    ServiceGateway<Sheets, GoogleCredential> {
    override suspend fun getService(args: Args<GoogleCredential>): Response<Sheets> =
        coroutineScope {
            val service = async {
                Sheets.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    JacksonFactory.getDefaultInstance(),
                    args.get()
                )
                    .setApplicationName("hard-skills-improvement")
                    .build()
            }.await()

            object : Response<Sheets> {
                override fun getResult(): Sheets {
                    return service
                }

                override fun isSuccess(): Boolean {
                    return service != null
                }

            }
        }

}