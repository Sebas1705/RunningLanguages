package Avanzado.D_Colecciones.Sets;

import java.util.*;

public class A_HashSet {

    /**
     *  Caracteristicas:
     *  rapida
     *  no duplicados
     *  no ordenacion
     *  no acceso aleatorio
     */
    
    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<Integer>();

        for(int i = 100; i > 0; i--) hs.add(i);

        //Como las listas tienen funciones parecidas

        hs.remove(20);
        

        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()) System.out.print("/"+it.next()+"/");


        hs.add(10);

        System.out.println(hs);
    }
}
