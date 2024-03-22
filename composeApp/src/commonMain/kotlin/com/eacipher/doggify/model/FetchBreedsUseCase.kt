package com.eacipher.doggify.model

class FetchBreedsUseCase {
    suspend fun invoke(): List<Breed> = listOf(Breed("Test Fetch", ""), )
}