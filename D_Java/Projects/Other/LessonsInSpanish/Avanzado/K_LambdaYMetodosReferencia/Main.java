package Avanzado.K_LambdaYMetodosReferencia;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++)list.add(i);
        
        
        //Formas de mostrar:
        //Comun:
        for(int i=0;i<list.size();i++)System.out.print(list.get(i));
        System.out.println();
       
        //For each:
        for(int i : list)System.out.print(i);
        System.out.println();
        
        //Lambda:
        // (parametros pasados) -> (accion a realizar)
        //For each recortado con lambda:
        list.forEach(i->System.out.print(i));
        System.out.println();

        //Metodos a referencia:
        //Solo si en la expresion lambda los parametros que 
        //se recogen son los mismos y en el mismo orden 
        //q los de la accion
        //For each recortado con referencia:
        list.forEach(System.out::print);
        System.out.println();

        //Extra:
        //Lambda como implementacion de una interfaz
        //Solo en caso de que la interfaz tenga un solo metodo
        Collections.sort(list,(a,b)->b-a);
        System.out.println(list);
    }


}
