package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.util.Base64
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choonsik.blockchainwallet.R
import com.choonsik.blockchainwallet.common.Event
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard.PinKey
import com.choonsik.blockchainwallet.util.crypt.CryptManager
import com.choonsik.blockchainwallet.util.crypt.KeyStoreWrapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

class PinCodeRegViewModel @Inject constructor() : ViewModel() {
    private val _pinClick = MutableLiveData<Event<PinKeyEvent>>()
    val pinClick: LiveData<Event<PinKeyEvent>> = _pinClick
    private val _inputFinishAndClear = MutableLiveData<Event<Unit>>()
    val inputFinishAndClear: LiveData<Event<Unit>> = _inputFinishAndClear
    private val _successRegistration = MutableLiveData<Event<Unit>>()
    val successRegistration: LiveData<Event<Unit>> = _successRegistration


    val descriptionStringRes = MutableLiveData<Int>()
    private val _registrationKeys = arrayListOf<PinKey>()
    private val _inputKeys = arrayListOf<PinKey>()
    private var isDelayed = false

    init {
        descriptionStringRes.value = R.string.fragment_reg_start_description
    }
//
//    fun reset(){
//        descriptionMessage.value =
//    }

    fun onClickKey(view: View, key: PinKey) {
        if (isDelayed) return
        when (key) {
            is PinKey.BackKey -> {
                if (_inputKeys.isNotEmpty() && _inputKeys.size < PIN_MAX_SIZE) {
                    notifyPin(key)
                    _inputKeys.removeAt(_inputKeys.lastIndex)
                }
            }
            else -> {
                // +1 마지막 등록된
                val isLastInput = _inputKeys.size + 1 == PIN_MAX_SIZE
                _inputKeys.add(key)
                notifyPin(key)

                /** 등록 **/
                if (!isRegistration() && isLastInput) {
                    regInput()
                    viewModelScope.launch {
                        isDelayed = true
                        delay(600)
                        descriptionStringRes.value = R.string.fragment_reg_re_input_description
                        _inputFinishAndClear.value = Event(Unit)
                        isDelayed = false
                    }
                }
                /** 핀 등록 완료 + 입력한 핀의 마지막 입력**/
                else if (isRegistration() && isLastInput) {

                    val isEquals = isEqualsKey()
                    if (isEquals) {
                        _successRegistration.value = Event(Unit)
//                        description.value = "핀번호가 일치합니다"
//                        pinPreference.savePinInfo(encryptedValue)
//                        registrationComplete.call()
                    } else {
//                        description.value = "핀번호가 일치하지 않습니다"
//                        _inputKeys.clear()
                    }
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

    private fun regInput() {
        _registrationKeys.addAll(_inputKeys)
        _inputKeys.clear()
    }

    private fun isEqualsKey(): Boolean {
        return _inputKeys == _registrationKeys

    }

    private fun createMasterKey(){
        val data = createRandomData()
    }

    private fun createRandomData(): String {
        val random = Random(Calendar.getInstance().timeInMillis)
        val randomInt = Random(Calendar.getInstance().timeInMillis)
        val randomSize = randomInt.nextInt(200, 500)
        val bytes = random.nextBytes(randomSize)
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    data class PinKeyEvent(val index: Int, val key: PinKey)
    companion object {
        private const val PIN_MAX_SIZE = 4
    }
}