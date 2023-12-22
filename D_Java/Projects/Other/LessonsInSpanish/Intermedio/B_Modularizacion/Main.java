package Intermedio.B_Modularizacion;

public class Main {
    public static void main(String[] args) {

        //La Modularizacion y encapsulacion son dos tecnicas que vuelven seguro el codigo.
        //Se basan en la creacion de clases y privatizacion de atributos.
        //O sea atributos privados en mayoria y muchas clase conectadas.
        
        Coche c = new Coche(220.20, "Rojo", "Ferrari");
        ExpositorCoche exCoche = new ExpositorCoche(c);

        exCoche.mostrarCoche();

        exCoche.pruebaCoche();
        
    }
}
