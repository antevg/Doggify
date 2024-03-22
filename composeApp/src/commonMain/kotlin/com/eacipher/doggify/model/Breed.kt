package com.eacipher.doggify.model

data class Breed(
    val name: String,
    val imageUrl: String,
    val isFavourite: Boolean = false
)
