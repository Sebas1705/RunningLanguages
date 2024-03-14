package com.sebss.pass_word.androidimpl

import android.content.Context
import android.view.View
import com.sebss.pass_word.interfaces.Input.TouchEvent
import com.sebss.pass_word.interfaces.Input

class AndroidInput(context: Context, view: View, scaleX: Float, scaleY: Float) : Input {
    private var accelHandler: AccelerometerHandler
    private var keyHandler: KeyboardHandler
    private var touchHandler: TouchHandler

    init {
        accelHandler = AccelerometerHandler(context)
        keyHandler = KeyboardHandler(view)
        touchHandler = MultiTouchHandler(view, scaleX, scaleY)
    }

    override fun isKeyPressed(keyCode: Int): Boolean {
        return keyHandler.isKeyPressed(keyCode)
    }

    override fun isTouchDown(pointer: Int): Boolean {
        return touchHandler.isTouchDown(pointer)
    }

    override fun getTouchX(pointer: Int): Int {
        return touchHandler.getTouchX(pointer)
    }

    override fun getTouchY(pointer: Int): Int {
        return touchHandler.getTouchY(pointer)
    }

    override val accelX: Float
        get() = accelHandler.accelX
    override val accelY: Float
        get() = accelHandler.accelY
    override val accelZ: Float
        get() = accelHandler.accelZ
    override val touchEvents: List<TouchEvent>
        get() = touchHandler.getTouchEvents()
    override val keyEvents: List<Input.KeyEvent>
        get() = keyHandler.getKeyEvents()
}