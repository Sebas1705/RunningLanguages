package com.sebss.a3dgraphicsmotor.juego

import com.sebss.a3dgraphicsmotor.androidimpl.AndroidGame
import com.sebss.a3dgraphicsmotor.interfaces.Screen

class MainGame : AndroidGame() {
    init {
        super.currentScreen = LoadingScreen (this)
    }
}