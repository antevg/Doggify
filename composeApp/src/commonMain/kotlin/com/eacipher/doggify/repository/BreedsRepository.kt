package com.eacipher.doggify.repository

import com.eacipher.doggify.model.Breed
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.awaitAll

class BreedsRepository internal constructor(
    private val remoteSource: BreedsRemoteSource
) {
    suspend fun get() = fetch()

    suspend fun fetch() = supervisorScope {
        remoteSource.getBreeds().map {
            async {
                Breed(name = it,
                    imageUrl = remoteSource.getBreedImage(it))
            }
        }.awaitAll()
    }
}
