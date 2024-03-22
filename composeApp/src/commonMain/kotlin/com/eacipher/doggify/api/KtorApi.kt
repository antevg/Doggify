package com.eacipher.doggify.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json



internal abstract class KtorApi {

    private val  jsonConfiguration = Json{
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
        install(Logging){

        }
    }
}