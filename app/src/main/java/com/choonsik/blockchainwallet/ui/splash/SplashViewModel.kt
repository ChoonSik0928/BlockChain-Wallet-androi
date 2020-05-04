package com.choonsik.blockchainwallet.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choonsik.blockchainwallet.repository.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val appRepository: AppRepository
): ViewModel(){

    fun checkSecureSetting(){
        viewModelScope.launch {
            Log.e("test","SecurityData = ${ appRepository.hasSecurityData()}")
        }

    }
}