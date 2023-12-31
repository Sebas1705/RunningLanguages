package com.sebss.a3dgraphicsmotor.androidimpl

import android.view.View.OnTouchListener
import com.sebss.a3dgraphicsmotor.interfaces.Input.TouchEvent

interface TouchHandler : OnTouchListener {
    fun isTouchDown(pointer: Int): Boolean
    fun getTouchX(pointer: Int): Int
    fun getTouchY(pointer: Int): Int
    fun getTouchEvents(): List<TouchEvent>
}