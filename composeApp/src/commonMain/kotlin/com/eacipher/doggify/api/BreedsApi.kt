package com.eacipher.doggify.api

import com.eacipher.doggify.api.model.BreedImageResponse
import com.eacipher.doggify.api.model.BreedsResponse
import com.eacipher.doggify.model.Breed
import io.ktor.client.call.body
import io.ktor.client.request.get


internal class BreedsApi: KtorApi() {
    suspend fun getBreeds(): BreedsResponse =
        client.get {
            apiUrl("breeds/list")
        }.body()

    suspend fun getRandomBreedImageFor(breed: String): BreedImageResponse =
        client.get {
            apiUrl("breeds/$breed/images/random")
        }.body()
}

