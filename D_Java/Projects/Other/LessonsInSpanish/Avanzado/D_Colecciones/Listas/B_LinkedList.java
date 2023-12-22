package Avanzado.D_Colecciones.Listas;

import java.util.*;

public class B_LinkedList {

    //Complejidades de tiempo:
    //1-Insert last index: O(1)
    //2-Insert at given index: O(N)
    //3-Search by value: O(N)
    //4-Get by index: O(N)
    //5-Remove by value: O(N)
    //6-Remove by index: O(N)
    //Preferible en 1,2,5,6

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        for(int i = 0; i < 100; i++) lista.add((int)(Math.random()*100+1));//Añadir a lista

        lista.set(30, 0);//Cambiar en la lista

        Iterator<Integer> it = lista.listIterator();//Recorer lista con pivote, tambien se puede usar el for each
        while(it.hasNext()) System.out.print("/"+it.next()+"/");

        System.out.println("\n\nElemento nº10: "+lista.get(10));
        System.out.println("Elemento nº30: "+lista.get(30));
        System.out.println("Elemento nº0: "+lista.get(0));
        System.out.println("Elemento nº90: "+lista.get(90)+"\n\n");


        Collections.sort(lista);
        for(int i : lista) System.out.print("/"+i+"/");
    }
}
