package com.eacipher.doggify.di

import com.eacipher.doggify.model.FetchBreedsUseCase
import com.eacipher.doggify.model.GetBreedsUseCase
import com.eacipher.doggify.model.ToggleFavouriteStateUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val sharedModules = listOf(usecaseModule)

fun initKoin(appDeclaration: KoinAppDeclaration = {})
= startKoin {
    appDeclaration()
    modules(sharedModules)
}