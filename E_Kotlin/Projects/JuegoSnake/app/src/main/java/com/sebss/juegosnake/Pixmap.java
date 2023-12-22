package com.sebss.juegosnake;


public interface Pixmap {
    int getWidth();

    int getHeight();

    Graficos.PixmapFormat getFormat();

    void dispose();
}

