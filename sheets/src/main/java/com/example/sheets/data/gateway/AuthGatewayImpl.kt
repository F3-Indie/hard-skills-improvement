package com.example.sheets.data.gateway

import android.content.res.AssetManager
import com.example.sheets.domain.entities.Args
import com.example.sheets.domain.entities.Response
import com.example.sheets.domain.entities.Stable
import com.example.sheets.domain.gateway.AuthGateway
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.services.sheets.v4.SheetsScopes
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@Stable
class AuthGatewayImpl :
    AuthGateway<GoogleCredential, AssetManager> {

    companion object {
        private const val credentialsPath = "credentials.json"
    }

    override suspend fun getCredentials(args: Args<AssetManager>): Response<GoogleCredential> =
        coroutineScope {

            val credential = async {
                GoogleCredential.fromStream(args.get().open(credentialsPath))
                    .createScoped(SheetsScopes.all())
            }.await()

            object : Response<GoogleCredential> {
                override fun getResult(): GoogleCredential {
                    return credential
                }

                override fun isSuccess(): Boolean {
                    return credential != null
                }

            }
        }

}