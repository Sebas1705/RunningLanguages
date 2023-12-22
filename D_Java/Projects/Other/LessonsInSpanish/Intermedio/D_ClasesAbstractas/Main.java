package Intermedio.D_ClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        
        Casa[] lista = new Casa[2];
        lista[0] = new Apartamento(200, 4, 3, true, false);
        lista[1] = new Chalet(150, 3, 4, 2);

        int i = 1;
        for(Casa c : lista) c.mostrarDatos(i++);
        
    }
}
