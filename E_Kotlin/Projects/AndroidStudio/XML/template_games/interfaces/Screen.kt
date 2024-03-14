package com.sebss.pass_word.interfaces

abstract class Screen(val game: Game) {
    abstract fun update(deltaTime: Float)
    abstract fun present(deltaTime: Float)
    abstract fun pause()
    abstract fun resume()
    abstract fun dispose()
}