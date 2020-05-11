package com.choonsik.blockchainwallet.ui.pin_code.regstration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.LottieAnimationView
import com.choonsik.blockchainwallet.common.Event
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard.PinKey
import javax.inject.Inject

class PinCodeRegViewModel @Inject constructor() : ViewModel() {
    private val _firstPinClick = MutableLiveData<Event<Int>>()
    val firstPinClick: LiveData<Event<Int>> = _firstPinClick

    fun onClickKey(key: PinKey) {
        _firstPinClick.value = Event(0)
    }
}