package com.sebss.juegosnake.juego;

import java.util.ArrayList;
import java.util.List;

public class CochePolicia {

    public static final int ARRIBA = 0;
    public static final int IZQUIERDA= 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;

    public List<DelicuentesDetenidos> partes = new ArrayList<>();
    public int direccion;

    public CochePolicia() {
        direccion = ARRIBA;
        partes.add(new DelicuentesDetenidos(5, 6));
    }

    public void girarIzquierda() {
        direccion += 1;
        if(direccion > DERECHA)
            direccion = ARRIBA;
    }

    public void girarDerecha() {
        direccion -= 1;
        if(direccion < ARRIBA)
            direccion = DERECHA;
    }

    public void atrapar() {
        DelicuentesDetenidos end = partes.get(partes.size()-1);
        partes.add(new DelicuentesDetenidos(end.x, end.y));
    }

    public void avance() {
        DelicuentesDetenidos coche = partes.get(0);

        int len = partes.size() - 1;
        for(int i = len; i > 0; i--) {
            DelicuentesDetenidos antes = partes.get(i-1);
            DelicuentesDetenidos parte = partes.get(i);
            parte.x = antes.x;
            parte.y = antes.y;
        }

        if(direccion == ARRIBA)
            coche.y -= 1;
        if(direccion == IZQUIERDA)
            coche.x -= 1;
        if(direccion == ABAJO)
            coche.y += 1;
        if(direccion == DERECHA)
            coche.x += 1;

        if(coche.x < 0)
            coche.x = 9;
        if(coche.x > 9)
            coche.x = 0;
        if(coche.y < 0)
            coche.y = 12;
        if(coche.y > 12)
            coche.y = 0;
    }


}

