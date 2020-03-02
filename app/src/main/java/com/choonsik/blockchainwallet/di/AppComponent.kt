package com.choonsik.blockchainwallet.di

import com.choonsik.blockchainwallet.BlockChainWalletApplication
import com.choonsik.blockchainwallet.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<BlockChainWalletApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BlockChainWalletApplication): AppComponent
    }
}