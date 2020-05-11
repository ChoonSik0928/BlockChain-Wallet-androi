package com.choonsik.blockchainwallet.common

import android.view.View
import androidx.databinding.BindingAdapter
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.PinKeyboardView
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard.PinKey
import com.choonsik.blockchainwallet.ui.widget.pin_code_view.listener.KeyboardClickListener

@BindingAdapter("android:onKeyboard")
fun onKeyboard(view: PinKeyboardView, onClickKey: OnClickKey?) {
    view.setKeyboardClickListener(object : KeyboardClickListener{
        override fun onKeyClick(key: PinKey) {
            onClickKey?.onKey(key)
        }
    })
}

interface OnClickKey{
    fun onKey(key: PinKey)
}
