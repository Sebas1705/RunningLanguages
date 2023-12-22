package Intermedio.E_Enum;


public class Main {
    
    public enum Tallas{
        MUY_GRANDE, GRANDE, MEDIANO, PEQUEÑO, MUY_PEQUEÑO;
    }
    
    public static void main(String[] args) {
    
        Tallas[] tallas = Tallas.values();

        for(Tallas t : tallas) System.out.println(t.toString()+": "+t.ordinal());

        Semana[] semana = Semana.values();

        for(Semana s : semana) System.out.println(s.toString()+": "+s.ordinal());

    }
}
