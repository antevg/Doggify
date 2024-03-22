package com.eacipher.doggify.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.Logging
import kotlinx.serialization.json.Json



//import kotlinx.serialization.json.Json

internal abstract class KtorApi {

    private val  jsonConfiguration = Json{
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    val client = HttpClient {
        install(JsonFeature){

        }
        install(Logging){

        }
    }
}