package com.eacipher.doggify.util

import kotlinx.coroutines.Dispatchers

private class AndroidDispatcherProvider :DispatcherProvider {
    override val io = Dispatchers.Default
    override val unconfined = Dispatchers.Unconfined
    override val main = Dispatchers.Main
}

internal actual fun getDispatcherProvider(): DispatcherProvider = AndroidDispatcherProvider()