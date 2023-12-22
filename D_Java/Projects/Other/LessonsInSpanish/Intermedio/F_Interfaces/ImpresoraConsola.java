package Intermedio.F_Interfaces;

public class ImpresoraConsola implements Impresora{

    @Override
    public void imprimirHola() {
        System.out.println("Hola buenas");
    }

    @Override
    public void imprimirAdios() {
        System.out.println("Hasta luego");
    }

    @Override
    public void imprimirAlgo(String algo) {
        System.out.println(algo);
    }
    
}
