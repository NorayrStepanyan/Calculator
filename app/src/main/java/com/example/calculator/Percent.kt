package com.example.calculator

import android.widget.TextView

fun percent(_text: TextView, _pad: Double): TextView {

    var pad = 0.0
    pad = _pad % _text.text.toString().toDouble()
    _text.text = pad.toString()
    return _text
}