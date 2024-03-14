package com.sebss.juegosnake.juego;

import com.sebss.juegosnake.Pantalla;
import com.sebss.juegosnake.androidimpl.AndroidJuego;

public class JuegoSnake extends AndroidJuego {
    @Override
    public Pantalla getStartScreen() {
        return new LoadingScreen(this);
    }
}
