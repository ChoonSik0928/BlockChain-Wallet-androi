package com.choonsik.blockchainwallet.repository

interface AppRepository {
    suspend fun hasSecurityData(): Boolean
}