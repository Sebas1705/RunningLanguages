package com.sebss.pass_word.juego

class Civil(x: Int, y: Int, @JvmField var tipo: Int) : Entity(x, y) {
    companion object {
        const val YAYA = 0
        const val NINO = 1
        const val CANI = 2
    }
}