package com.sebss.juegosnake.juego;

public class Civil extends Entidad{
    public static final int YAYA = 0;
    public static final int NINO = 1;
    public static final int CANI = 2;

    public int tipo;

    public Civil(int x,int y,int tipo){
        super(x,y);
        this.tipo=tipo;
    }
}
