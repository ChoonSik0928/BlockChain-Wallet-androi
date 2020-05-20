package com.choonsik.blockchainwallet.repository

import android.util.Log
import com.choonsik.blockchainwallet.db.dao.SecurityDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val securityDao: SecurityDao
) : AppRepository {
    override suspend fun hasSecurityData(): Boolean {
        Log.e("test", "data = ${securityDao.getSecurity()}")
        return securityDao.getSecurity() != null
    }
}