package com.eacipher.doggify.model

class GetBreedsUseCase {
    suspend fun invoke(): List<Breed> = listOf(Breed("Test Get", ""), )
}