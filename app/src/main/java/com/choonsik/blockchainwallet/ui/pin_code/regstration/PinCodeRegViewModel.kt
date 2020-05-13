package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.choonsik.blockchainwallet.common.Event
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard.PinKey
import javax.inject.Inject

class PinCodeRegViewModel @Inject constructor() : ViewModel() {
    private val _pinClick = MutableLiveData<Event<PinKeyEvent>>()
    val pinClick: LiveData<Event<PinKeyEvent>> = _pinClick

    private val _registrationKeys = arrayListOf<PinKey>()
    private val _inputKeys = arrayListOf<PinKey>()

    fun onClickKey(key: PinKey) {
        when (key) {
            is PinKey.BackKey -> {
                if (_inputKeys.isNotEmpty() && _inputKeys.size < PIN_MAX_SIZE) {
                    notifyPin(key)
                    _inputKeys.removeAt(_inputKeys.lastIndex)
                }
            }
            else -> {
                // +1 마지막 등록된
                val isLastInput = _inputKeys.size == PIN_MAX_SIZE
                _inputKeys.add(key)
                notifyPin(key)

                /** 등록 **/
                if (!isRegistration() && isLastInput) {

//                    registrationKey()
//                    displayInputPinCode()
                }
                /** 핀 등록 완료 + 입력한 핀의 마지막 입력**/
                else if (isRegistration() && isLastInput) {

//                    val isEquals = isEqualsKey()
//                    if (isEquals) {
//                        description.value = "핀번호가 일치합니다"
//                        pinPreference.savePinInfo(encryptedValue)
//                        registrationComplete.call()
//                    } else {
//                        description.value = "핀번호가 일치하지 않습니다"
//                        _inputKeys.clear()
//                    }
//                    displayInputPinCode()
                }
            }
        }

    }

    private fun notifyPin(key: PinKey) {
        _pinClick.value = Event(PinKeyEvent(_inputKeys.size, key))
    }

    private fun isRegistration(): Boolean {
        return _registrationKeys.isNotEmpty()
    }

    private fun isEqualsKey(): Boolean {
        return false
    }

    data class PinKeyEvent(val index: Int, val key: PinKey)
    companion object {
        private const val PIN_MAX_SIZE = 4
    }
}