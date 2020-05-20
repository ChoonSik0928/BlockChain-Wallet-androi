package com.choonsik.blockchainwallet.ui.splash

import android.util.Log
import androidx.lifecycle.LiveData
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
) : ViewModel() {
    private val _actionPinCodeRegistration = MutableLiveData<Event<Unit>>()
    val actionPinCodeRegistration: LiveData<Event<Unit>> = _actionPinCodeRegistration

    fun checkSecureSetting() {
        viewModelScope.launch {
            Log.e("check","hasData = ${appRepository.hasSecurityData()}")
            if (!appRepository.hasSecurityData()) {
                _actionPinCodeRegistration.value = Event(Unit)
            }else{

            }
        }
    }

    companion object {
        const val DELAY_MILLISECONDS = 2000L
    }
}