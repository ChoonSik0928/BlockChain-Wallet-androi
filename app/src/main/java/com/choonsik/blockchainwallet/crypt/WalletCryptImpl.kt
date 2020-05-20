package com.choonsik.blockchainwallet.crypt

import android.util.Base64
import android.util.Log
import com.choonsik.blockchainwallet.db.dao.SecurityDao
import com.choonsik.blockchainwallet.db.entities.SecurityEntity
import com.choonsik.blockchainwallet.util.crypt.CryptManager
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class WalletCryptImpl @Inject constructor(
    private val securityDao: SecurityDao
) : WalletCrypt {

    override suspend fun pinRegister(inputData: String) {
        val encryptedData =
            CryptManager.encryptPlainText(KEY_ALIAS_PIN, inputData, createRandomData())
        Log.e("encrypted Data", " data = $encryptedData")
        securityDao.insert(SecurityEntity(0, encryptedData))
        Log.e("encrypted Data", " insertSuccess")
    }

    private fun createRandomData(): String {
        val random = Random(Calendar.getInstance().timeInMillis)
        val randomInt = Random(Calendar.getInstance().timeInMillis)
        val randomSize = randomInt.nextInt(50, 100)
        val bytes = random.nextBytes(randomSize)
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    companion object {
        const val KEY_ALIAS_PIN = "PIN"
    }

}