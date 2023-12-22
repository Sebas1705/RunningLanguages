package Básicos;

import java.util.Random;

public class P_Random {
    public static void main(String[] args) {
        
        //Objeto:
            Random rand = new Random();
            System.out.println("Random objeto: "+Math.abs(rand.nextInt()%100));//Da un random de int, se puede manejar el random usando %.
        //End Objeto.

        //Estatico:
            int random = (int) (Math.random()*100);//Da un double entre 0.0 y 1.0, sin contar el ultimo.
            System.out.println("Random estatico: "+random);
        //End Estatico.
    }
}
