package com.eacipher.doggify.model

import com.eacipher.doggify.repository.BreedsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBreedsUseCase: KoinComponent
{
    private val breedsRepository: BreedsRepository by inject()

    suspend fun invoke(): List<Breed> =
        breedsRepository.get()
}