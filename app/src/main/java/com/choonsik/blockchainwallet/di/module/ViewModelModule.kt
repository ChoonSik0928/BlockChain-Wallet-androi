package com.choonsik.blockchainwallet.di.module

import androidx.lifecycle.ViewModelProvider
import com.choonsik.blockchainwallet.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}