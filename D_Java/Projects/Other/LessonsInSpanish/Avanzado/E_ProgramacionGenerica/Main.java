package Avanzado.E_ProgramacionGenerica;

import Avanzado.E_ProgramacionGenerica.Objetos.*;

public class Main {
    
    
    public static void main(String[] args){
        //Almacen totalmente generico:
        Almacen_Objetos ao = new Almacen_Objetos(4);
        try {
            ao.añadirObjeto(new Avion("Boing", 600.20));
            ao.añadirObjeto(new Casa(200.9, 4));
            ao.añadirObjeto(new Avion("Boing", 700.20));
            ao.añadirObjeto(new Casa(300.9, 5));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(ao);

        //Almacen semiGenerico:
        Almacen<Avion> a1 = new Almacen<Avion>(2);
        try {
            a1.añadirObjeto(new Avion("Boing", 600.20));
            a1.añadirObjeto(new Avion("Boing", 700.20));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(a1);

        Almacen<Casa> a2 = new Almacen<Casa>(2);
        try {
            a2.añadirObjeto(new Casa(200.9, 4));
            a2.añadirObjeto(new Casa(300.9, 5));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //Metodo generico:
        System.out.println(getString(a2));
    }

    public static <T> String getString(T element){return element.toString();}
    
}
