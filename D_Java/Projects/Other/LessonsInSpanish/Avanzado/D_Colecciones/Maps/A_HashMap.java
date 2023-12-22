package Avanzado.D_Colecciones.Maps;

import java.util.*;

public class A_HashMap {
    
    /**
     *  Caracteristicas:
     *  no ordenacion
     *  eficiente
     */
    
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for(int i = 100; i > 0; i--) map.put(i, generateString((int)(Math.random()*5+5)));
        
        System.out.println(map);

        System.out.println("\n\nElemento con clave 20: "+map.get(20));

    }

    public static String generateString(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append((char)((int)(Math.random()*25+97)));
        return sb.toString();        
    }
}
