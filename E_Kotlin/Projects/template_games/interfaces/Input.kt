package com.sebss.pass_word.interfaces

interface Input {
    class KeyEvent {
        @JvmField
        var type = 0
        @JvmField
        var keyCode = 0
        @JvmField
        var keyChar = 0.toChar()
        override fun toString(): String {
            val builder = StringBuilder()
            if (type == KEY_DOWN) builder.append("tecla pulsada, ") else builder.append("tecla levantada, ")
            builder.append(keyCode)
            builder.append(",")
            builder.append(keyChar)
            return builder.toString()
        }

        companion object {
            const val KEY_DOWN = 0
            const val KEY_UP = 1
        }
    }

    class TouchEvent {
        @JvmField
        var type = 0
        @JvmField
        var x = 0
        @JvmField
        var y = 0
        @JvmField
        var pointer = 0
        override fun toString(): String {
            val builder = StringBuilder()
            if (type == TOUCH_DOWN) builder.append("touch down, ") else if (type == TOUCH_DRAGGED) builder.append(
                "touch dragged, "
            ) else builder.append("touch up, ")
            builder.append(pointer)
            builder.append(",")
            builder.append(x)
            builder.append(",")
            builder.append(y)
            return builder.toString()
        }

        companion object {
            const val TOUCH_DOWN = 0
            const val TOUCH_UP = 1
            const val TOUCH_DRAGGED = 2
        }
    }

    fun isKeyPressed(keyCode: Int): Boolean
    fun isTouchDown(pointer: Int): Boolean
    fun getTouchX(pointer: Int): Int
    fun getTouchY(pointer: Int): Int
    val accelX: Float
    val accelY: Float
    val accelZ: Float
    val keyEvents: List<KeyEvent>
    val touchEvents: List<TouchEvent>
}