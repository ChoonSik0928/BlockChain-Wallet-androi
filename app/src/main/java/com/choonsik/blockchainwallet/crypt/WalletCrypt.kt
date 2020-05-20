package com.choonsik.blockchainwallet.crypt

interface WalletCrypt {
    suspend fun pinRegister(inputData: String)
}