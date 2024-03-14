package com.sebss.pass_word.juego

import com.sebss.pass_word.androidimpl.AndroidGame

class MainGame : AndroidGame() {
    init {
        super.currentScreen = LoadingScreen (this)
    }
}