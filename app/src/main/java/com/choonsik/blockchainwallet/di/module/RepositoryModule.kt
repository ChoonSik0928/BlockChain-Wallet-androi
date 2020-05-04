package com.choonsik.blockchainwallet.di.module

import com.choonsik.blockchainwallet.repository.AppRepository
import com.choonsik.blockchainwallet.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoryModule{

    @Binds
    @Singleton
    fun bindAppRepository(repository: AppRepositoryImpl): AppRepository

}