package com.choonsik.blockchainwallet.ui.widget.pin_code_view.keyboard

data class Row(var keys: ArrayList<PinKey> = arrayListOf())

data class Keyboard(var rows: ArrayList<Row>)