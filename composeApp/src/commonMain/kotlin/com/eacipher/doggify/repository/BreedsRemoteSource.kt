package com.eacipher.doggify.repository

import com.eacipher.doggify.api.BreedsApi
import com.eacipher.doggify.model.Breed
import com.eacipher.doggify.util.DispatcherProvider
import kotlinx.coroutines.withContext

internal class BreedsRemoteSource(
    private val api: BreedsApi,
    private val dispatcherProvider: DispatcherProvider
) {
    suspend fun getBreeds() =
        withContext(dispatcherProvider.io){
            api.getBreeds().breeds
        }

    suspend fun getBreedImage(breed: String) =
        withContext(dispatcherProvider.io){
            api.getRandomBreedImageFor(breed).breedImageUrl
        }
}