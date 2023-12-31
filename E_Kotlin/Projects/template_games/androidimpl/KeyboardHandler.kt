package com.sebss.pass_word.androidimpl

import android.view.KeyEvent
import android.view.View
import com.sebss.pass_word.interfaces.Input
import com.sebss.pass_word.interfaces.Pool
import com.sebss.pass_word.interfaces.Pool.PoolObjectFactory

class KeyboardHandler(view: View) : View.OnKeyListener {
    private var pressedKeys = BooleanArray(128)
    private var keyEventPool: Pool<Input.KeyEvent>
    private var keyEventsBuffer: MutableList<Input.KeyEvent> = ArrayList()
    private var keyEvents: MutableList<Input.KeyEvent> = ArrayList()

    init {
        val factory: PoolObjectFactory<Input.KeyEvent> =
            object : PoolObjectFactory<Input.KeyEvent> {
                override fun createObject(): Input.KeyEvent {
                    return Input.KeyEvent()
                }
            }
        keyEventPool = Pool(factory, 100)
        view.setOnKeyListener(this)
        view.isFocusableInTouchMode = true
        view.requestFocus()
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_MULTIPLE) return false
        synchronized(this) {
            val keyEvent = keyEventPool.newObject()
            keyEvent.keyCode = keyCode
            keyEvent.keyChar = event.unicodeChar.toChar()
            if (event.action == KeyEvent.ACTION_DOWN) {
                keyEvent.type = Input.KeyEvent.KEY_DOWN
                if (keyCode in 1..126) pressedKeys[keyCode] = true
            }
            if (event.action == KeyEvent.ACTION_UP) {
                keyEvent.type = Input.KeyEvent.KEY_UP
                if (keyCode in 1..126) pressedKeys[keyCode] = false
            }
            keyEventsBuffer.add(keyEvent)
        }
        return false
    }

    fun isKeyPressed(keyCode: Int): Boolean {
        return if (keyCode < 0 || keyCode > 127) false else pressedKeys[keyCode]
    }

    fun getKeyEvents(): List<Input.KeyEvent> {
        synchronized(this) {
            val len = keyEvents.size
            for (i in 0 until len) keyEventPool.free(keyEvents[i])
            keyEvents.clear()
            keyEvents.addAll(keyEventsBuffer)
            keyEventsBuffer.clear()
            return keyEvents
        }
    }
}