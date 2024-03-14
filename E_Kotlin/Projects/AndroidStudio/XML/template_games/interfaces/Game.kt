package com.sebss.pass_word.interfaces

interface Game {

    val input: Input
    val fileIO: FileIO
    val graphics: Graphics
    val audio: Audio
    val currentScreen: Screen
    fun setScreen(screen: Screen)
}