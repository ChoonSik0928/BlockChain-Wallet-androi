package com.choonsik.blockchainwallet.util.crypt

import android.content.Context
import androidx.biometric.BiometricManager

object BiometricUtil {
    fun isEnabledBiometric(context: Context): Boolean {
        return BiometricManager.from(context).canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS
    }
}