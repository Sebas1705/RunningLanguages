package Intermedio.A_ClasesYObjetos;

//Nombramos a la clase main la que se encargara de ejutar la funcion main.
public class Main {
    public static void main(String[] args) {
        
        Coche c = new Coche(220.20, "Rojo", "Ferrari");

        c.mostrarDatos();

        c.arrancar();
        c.arrancar();
        c.parar();
        c.parar();
    }
}
