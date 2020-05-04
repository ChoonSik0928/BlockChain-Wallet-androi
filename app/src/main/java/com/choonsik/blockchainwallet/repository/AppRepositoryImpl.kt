package com.choonsik.blockchainwallet.repository

import com.choonsik.blockchainwallet.db.dao.SecurityDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val securityDao: SecurityDao
) : AppRepository {
    override suspend fun hasSecurityData(): Boolean {
        return securityDao.getSecurity() != null
    }
}