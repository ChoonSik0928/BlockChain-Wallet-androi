package com.choonsik.blockchainwallet.ui.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choonsik.blockchainwallet.common.Event
import com.choonsik.blockchainwallet.repository.AppRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val appRepository: AppRepository
): ViewModel(){
    val actionPinCodeRegistration = MutableLiveData<Event<Unit>>()

    fun checkSecureSetting(){
        viewModelScope.launch {
            if(!appRepository.hasSecurityData()){
                delay(DELAY_MILLISECONDS)
                actionPinCodeRegistration.value = Event(Unit)
            }
        }
    }

    companion object{
        const val DELAY_MILLISECONDS = 1000L
    }
}