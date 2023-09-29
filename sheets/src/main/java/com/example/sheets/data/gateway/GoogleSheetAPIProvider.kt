package com.example.sheets.data.gateway

import android.content.Context
import android.content.res.AssetManager
import android.widget.Toast
import com.example.sheets.domain.entities.Stable
import com.example.sheets.domain.entities.argOf
import com.example.sheets.domain.gateway.AuthGateway
import com.example.sheets.domain.gateway.ServiceGateway
import com.example.sheets.domain.gateway.SheetGateway
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.services.sheets.v4.Sheets
import kotlinx.coroutines.CoroutineExceptionHandler

@Stable
class GoogleSheetAPIProvider(
    private val authGateway: AuthGateway<GoogleCredential, AssetManager>,
    private val serviceGateway: ServiceGateway<Sheets, GoogleCredential>
) {

    companion object {
        const val exceptionHandlerToastMessage =
            "Что-то пошло не так при подключении к сервисам google"
        const val exceptionHandlerToastDuration = Toast.LENGTH_LONG
    }

    private var instance: SheetGateway? = null

    val api get() = instance

    suspend fun install(assetManager: AssetManager) {
        val credentials = authGateway.getCredentials(argOf(assetManager)).getResult()
            ?: throw NullPointerException()

        instance = SheetGatewayImpl(
            serviceGateway.getService(argOf(credentials)).getResult()
                ?: throw NullPointerException()
        )
    }


    fun createExceptionHandler(context: Context): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, _ ->
            Toast.makeText(
                context,
                exceptionHandlerToastMessage,
                exceptionHandlerToastDuration
            ).show()
        }
    }
}