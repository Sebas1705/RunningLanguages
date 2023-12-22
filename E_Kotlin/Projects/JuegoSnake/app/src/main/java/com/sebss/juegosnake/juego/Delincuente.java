package com.sebss.juegosnake.juego;

public class Delincuente extends Entidad{
    public static final int LADRON = 0;
    public static final int HACKER = 1;
    public static final int MAFIOSO = 2;
    public int tipo;


    public Delincuente(int x, int y, int tipo) {
        super(x,y);
        this.tipo=tipo;


    }


}
