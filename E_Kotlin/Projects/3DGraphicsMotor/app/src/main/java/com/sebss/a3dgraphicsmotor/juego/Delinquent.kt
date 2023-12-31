package com.sebss.a3dgraphicsmotor.juego

class Delinquent(x: Int, y: Int, @JvmField var type: Int) : Entity(x, y) {
    companion object {
        const val THIEF = 0
        const val HACKER = 1
        const val GANGSTER = 2
    }
}