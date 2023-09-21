package com.example.sheets

import android.content.Context
import com.example.sheets.data.Grade
import com.example.sheets.data.SheetEntity
import com.example.sheets.data.MatrixDto
import com.example.sheets.data.MatrixEntity
import com.example.sheets.data.TraineeCardBlock
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

typealias ArrList<T> = java.util.ArrayList<T>

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
        
        suspend fun build(context: Context): SheetsAPI = coroutineScope {
            async{
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
                    .setApplicationName("hard-skills-improvement")
                    .build()
                
                SheetsAPI(service, sheetsConfig)
            }.await()
        }
    }
    
    fun getByGrade(grade: Grade): SheetEntity {
        val response = service.Spreadsheets().values()
            .get("11m6UFEqUZy4Jmx3AHmDsrxbbj2SBty6mYFXt1LEPLf0", grade.name).execute()
        return mapValueRangeToSheetEntity(grade, response.values)
    }
    
    private fun mapValueRangeToSheetEntity(grade: Grade, valueRange: MutableCollection<Any>): SheetEntity {
        val rows = mutableListOf<MatrixEntity>()
        
        var cellValues: ArrList<ArrList<Any>> =
            (valueRange.find { it is ArrList<*> } as ArrList<ArrList<Any>>)
        cellValues.removeFirst()
        
        cellValues.forEach {
            rows.add(mapSheetRowDtoToEntity(mapValuesToRowEntity(it as ArrList<String>)))
            
        }
        
        return SheetEntity(grade.name, rows)
    }
    
    private fun mapSheetRowDtoToEntity(dto: MatrixDto): MatrixEntity {
        with(dto)
        {
            return MatrixEntity(
                cardId = cardId ?: "null",
                cardBlock = /*add mapper*/ TraineeCardBlock.Language,
                name = name ?: "",
                value = value?.toIntOrNull() ?: 0,
                theoryLink = theoryLink ?: "",
                controlLink = controlLink ?: ""
            )
        }
    }
    
    private fun mapValuesToRowEntity(values: ArrList<String>): MatrixDto {
        with(values) {
            return MatrixDto(
                getOrNull(0),
                getOrNull(1),
                getOrNull(2),
                getOrNull(3),
                getOrNull(4),
                getOrNull(5)
            )
        }
    }
}