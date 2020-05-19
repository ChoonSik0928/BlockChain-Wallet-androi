package com.choonsik.blockchainwallet.di.module

import com.choonsik.blockchainwallet.crypt.WalletCrypt
import com.choonsik.blockchainwallet.crypt.WalletCryptImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
internal interface CryptModule {

    @Binds
    @Singleton
    fun bindWalletCrypt(walletCrypt: WalletCryptImpl): WalletCrypt
}