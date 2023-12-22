package Básicos;

public class Q_Arrays {
    public static void main(String[] args) {
        
        //Los arrays pueden ser multi-dimensionales.
        //Por ejemplo:
        int[] array = new int[2]; //Array unidimensional (lista) con longitud 2.
        //int[][] array2 = new int[2][2];//Array de dos dimensiones (matriz) de longitud 2x2.
        //int[][][] array3 = new int[2][2][2];//Array tridimensional (listas de listas de listas).

        //Para dar valores se accede a una posicion y se asigna como si fuera una variable normal.
        array[0] = 2;
        array[1] = 3;
        //Como tiene longitud dos, sus posiciones son 0 y 1
        //Cualquier array de longitud n tiene posiciones de 0 a n-1.

        //Tambien se puede inicializar en la declaracion asi: 
        int[] lista = {1,2,3,4,5,6};
        // int[][] lista2 = {{3,4},{1,2}};
        // int[][][] lista3 = {{{1,2},{3,4},{5,6}},{{7,8},{9,0},{1,2}}};

        System.out.println("Longitud de la lista: "+array.length);
        System.out.println("Elemento 0: "+array[0]);
        System.out.println("Elemento 1: "+array[1]);

        for(int a : lista) System.out.println(a);
    }
}
