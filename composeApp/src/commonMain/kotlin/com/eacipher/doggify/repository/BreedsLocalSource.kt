package com.eacipher.doggify.repository

import com.eacipher.doggify.db.DogifyDatabase
import com.eacipher.doggify.model.Breed
import com.eacipher.doggify.util.DispatcherProvider
import kotlinx.coroutines.withContext

internal class BreedsLocalSource(
    database: DogifyDatabase,
    private val dispatcherProvider: DispatcherProvider
) {

    private val dao = database.breedsQueries


    //Разобраться как сделать map
    val breeds = dao.selectAll().executeAsList().map {
        Breed(it.name, it.imageUrl, it.isFavourite ?: false)
    }

    suspend fun selectAll() =
        withContext(dispatcherProvider.io){
            dao.selectAll{ name, imageUrl, isFavourite ->
                Breed(name, imageUrl, isFavourite ?: false)
            }.executeAsList()
        }

    suspend fun insert(breed: Breed) =
        withContext(dispatcherProvider.io) {
            dao.insert(breed.name, breed.imageUrl, breed.isFavourite)
        }

    suspend fun update(breed: Breed) =
        withContext(dispatcherProvider.io){
            dao.update(breed.imageUrl, breed.isFavourite, breed.name)
        }

    suspend fun clear() =
        withContext(dispatcherProvider.io){
            dao.clear()
        }
}