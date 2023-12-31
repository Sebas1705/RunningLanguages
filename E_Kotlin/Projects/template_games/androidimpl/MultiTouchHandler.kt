package com.sebss.pass_word.androidimpl

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.sebss.pass_word.interfaces.Input.TouchEvent
import com.sebss.pass_word.interfaces.Pool
import com.sebss.pass_word.interfaces.Pool.PoolObjectFactory

class MultiTouchHandler(view: View, scaleX: Float, scaleY: Float) : TouchHandler {
    private var isTouched = BooleanArray(20)
    private var touchX = IntArray(20)
    private var touchY = IntArray(20)
    private var touchEventPool: Pool<TouchEvent>
    private val touchEvents: MutableList<TouchEvent> = ArrayList()
    private var touchEventsBuffer: MutableList<TouchEvent> = ArrayList()
    private var scaleX: Float
    private var scaleY: Float

    init {
        val factory: PoolObjectFactory<TouchEvent> =
            object : PoolObjectFactory<TouchEvent> {
                override fun createObject(): TouchEvent {
                    return TouchEvent()
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
            val action = event.action and MotionEvent.ACTION_MASK
            var pointerIndex =
                event.action and MotionEvent.ACTION_POINTER_INDEX_MASK shr MotionEvent.ACTION_POINTER_INDEX_SHIFT
            var pointerId = event.getPointerId(pointerIndex)
            var touchEvent: TouchEvent
            when (action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                    touchEvent = touchEventPool.newObject()
                    touchEvent.type = TouchEvent.TOUCH_DOWN
                    touchEvent.pointer = pointerId
                    run {
                        touchX[pointerId] = (event
                            .getX(pointerIndex) * scaleX).toInt()
                        touchEvent.x = touchX[pointerId]
                    }
                    run {
                        touchY[pointerId] = (event
                            .getY(pointerIndex) * scaleY).toInt()
                        touchEvent.y = touchY[pointerId]
                    }
                    isTouched[pointerId] = true
                    touchEventsBuffer.add(touchEvent)
                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL -> {
                    touchEvent = touchEventPool.newObject()
                    touchEvent.type = TouchEvent.TOUCH_UP
                    touchEvent.pointer = pointerId
                    run {
                        touchX[pointerId] = (event
                            .getX(pointerIndex) * scaleX).toInt()
                        touchEvent.x = touchX[pointerId]
                    }
                    run {
                        touchY[pointerId] = (event
                            .getY(pointerIndex) * scaleY).toInt()
                        touchEvent.y = touchY[pointerId]
                    }
                    isTouched[pointerId] = false
                    touchEventsBuffer.add(touchEvent)
                }

                MotionEvent.ACTION_MOVE -> {
                    val pointerCount = event.pointerCount
                    var i = 0
                    while (i < pointerCount) {
                        pointerIndex = i
                        pointerId = event.getPointerId(pointerIndex)
                        touchEvent = touchEventPool.newObject()
                        touchEvent.type = TouchEvent.TOUCH_DRAGGED
                        touchEvent.pointer = pointerId
                        touchX[pointerId] = (event
                            .getX(pointerIndex) * scaleX).toInt()
                        touchEvent.x = touchX[pointerId]
                        touchY[pointerId] = (event
                            .getY(pointerIndex) * scaleY).toInt()
                        touchEvent.y = touchY[pointerId]
                        touchEventsBuffer.add(touchEvent)
                        i++
                    }
                }
            }
            return true
        }
    }

    override fun isTouchDown(pointer: Int): Boolean {
        synchronized(this) { return if (pointer < 0 || pointer >= 20) false else isTouched[pointer] }
    }

    override fun getTouchX(pointer: Int): Int {
        synchronized(this) { return if (pointer < 0 || pointer >= 20) 0 else touchX[pointer] }
    }

    override fun getTouchY(pointer: Int): Int {
        synchronized(this) { return if (pointer < 0 || pointer >= 20) 0 else touchY[pointer] }
    }

    override fun getTouchEvents(): MutableList<TouchEvent> {
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