package com.sebss.pass_word.interfaces

interface Music {
    fun play()
    fun stop()
    fun pause()
    fun setVolume(volume: Float)
    val isPlaying: Boolean
    val isStopped: Boolean
    var isLooping: Boolean
    fun dispose()
}