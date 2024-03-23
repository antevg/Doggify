package com.eacipher.doggify.di

import com.eacipher.doggify.api.BreedsApi
import com.eacipher.doggify.model.FetchBreedsUseCase
import com.eacipher.doggify.model.GetBreedsUseCase
import com.eacipher.doggify.model.ToggleFavouriteStateUseCase
import com.eacipher.doggify.repository.BreedsRemoteSource
import com.eacipher.doggify.repository.BreedsRepository
import com.eacipher.doggify.util.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module



private val utilityModule = module {
    factory { getDispatcherProvider() }
}

private val apiModule = module {
    factory { BreedsApi() }
}

private val repositoryModule = module {
    single { BreedsRepository(get()) }
    factory { BreedsRemoteSource(get(), get()) }
}

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val sharedModules = listOf(
    usecaseModule,
    repositoryModule,
    apiModule,
    utilityModule)

fun initKoin(appDeclaration: KoinAppDeclaration = {})
= startKoin {
    appDeclaration()
    modules(sharedModules)
}