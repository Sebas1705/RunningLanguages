package com.sebss.a3dgraphicsmotor.juego

class PoliceCar {
    @JvmField
    var parts: MutableList<Prisoners> = ArrayList()
    @JvmField
    var direction: Int

    init {
        direction = UP
        parts.add(Prisoners(5, 6))
    }

    fun turnLeft() {
        direction += 1
        if (direction > RIGHT) direction = UP
    }

    fun turnRight() {
        direction -= 1
        if (direction < UP) direction = RIGHT
    }

    fun catchDelinquent() {
        val end = parts[parts.size - 1]
        parts.add(Prisoners(end.x, end.y))
    }

    fun go() {
        val coche = parts[0]
        val len = parts.size - 1
        for (i in len downTo 1) {
            val antes = parts[i - 1]
            val parte = parts[i]
            parte.x = antes.x
            parte.y = antes.y
        }
        if (direction == UP) coche.y -= 1
        if (direction == LEFT) coche.x -= 1
        if (direction == DOWN) coche.y += 1
        if (direction == RIGHT) coche.x += 1
        if (coche.x < 0) coche.x = 9
        if (coche.x > 9) coche.x = 0
        if (coche.y < 0) coche.y = 12
        if (coche.y > 12) coche.y = 0
    }

    companion object {
        const val UP = 0
        const val LEFT = 1
        const val DOWN = 2
        const val RIGHT = 3
    }
}