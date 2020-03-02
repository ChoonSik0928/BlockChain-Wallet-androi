package com.choonsik.blockchainwallet.di.module

import com.choonsik.blockchainwallet.base.DefaultDispatcherProvider
import com.choonsik.blockchainwallet.base.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
internal interface AppModule {
    @Binds
    fun bindDispatchers(dispatcher: DefaultDispatcherProvider): DispatcherProvider
}