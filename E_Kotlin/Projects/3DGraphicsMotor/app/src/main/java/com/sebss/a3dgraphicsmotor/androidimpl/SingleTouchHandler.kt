package com.sebss.a3dgraphicsmotor.androidimpl

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.sebss.a3dgraphicsmotor.interfaces.Input
import com.sebss.a3dgraphicsmotor.interfaces.Pool
import com.sebss.a3dgraphicsmotor.interfaces.Pool.PoolObjectFactory

class SingleTouchHandler(view: View, scaleX: Float, scaleY: Float) : TouchHandler {
    private var isTouched = false
    private var touchX = 0
    private var touchY = 0
    private var touchEventPool: Pool<Input.TouchEvent>
    private val touchEvents: MutableList<Input.TouchEvent> = ArrayList()
    private var touchEventsBuffer: MutableList<Input.TouchEvent> = ArrayList()
    private var scaleX: Float
    private var scaleY: Float

    init {
        val factory: PoolObjectFactory<Input.TouchEvent> =
            object : PoolObjectFactory<Input.TouchEvent> {
                override fun createObject(): Input.TouchEvent {
                    return Input.TouchEvent()
                }
            }
        touchEventPool = Pool(factory, 100)
        view.setOnTouchListener(this)
        this.scaleX = scaleX
        this.scaleY = scaleY
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        synchronized(this) {
            val touchEvent = touchEventPool.newObject()
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    touchEvent.type = Input.TouchEvent.TOUCH_DOWN
                    isTouched = true
                }

                MotionEvent.ACTION_MOVE -> {
                    touchEvent.type = Input.TouchEvent.TOUCH_DRAGGED
                    isTouched = true
                }

                MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                    touchEvent.type = Input.TouchEvent.TOUCH_UP
                    isTouched = false
                }
            }
            touchX = (event.x * scaleX).toInt()
            touchEvent.x = touchX
            touchY = (event.y * scaleY).toInt()
            touchEvent.y = touchY
            touchEventsBuffer.add(touchEvent)
            return true
        }
    }

    override fun isTouchDown(pointer: Int): Boolean {
        synchronized(this) { return if (pointer == 0) isTouched else false }
    }

    override fun getTouchX(pointer: Int): Int {
        synchronized(this) { return touchX }
    }

    override fun getTouchY(pointer: Int): Int {
        synchronized(this) { return touchY }
    }

    override fun getTouchEvents(): MutableList<Input.TouchEvent> {
        synchronized(this) {
            val len = touchEvents.size
            for (i in 0 until len) touchEventPool.free(touchEvents[i])
            touchEvents.clear()
            touchEvents.addAll(touchEventsBuffer)
            touchEventsBuffer.clear()
            return touchEvents
        }
    }

}