package Avanzado.D_Colecciones.Sets;

import java.util.*;


public class C_TreeSet {
    
    /**
     *  Caracteristicas:
     *  es ordenado
     *  poco eficiente
     */
    
    public static void main(String[] args) {

        TreeSet<Integer> hs = new TreeSet<Integer>();

        for(int i = 100; i > 0; i--) hs.add(i);

        //Como las listas tienen funciones parecidas

        hs.remove(20);
        

        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()) System.out.print("/"+it.next()+"/");


        hs.add(10);

        System.out.println(hs);
    }
}
