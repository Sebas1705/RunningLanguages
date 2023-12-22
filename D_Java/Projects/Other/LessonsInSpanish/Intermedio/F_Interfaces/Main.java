package Intermedio.F_Interfaces;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Impresora i;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduze impresora (consola o interfaz): ");
        String sel = sc.nextLine();

        switch(sel){
            case "consola":
            i = new ImpresoraConsola();
            i.imprimirHola();
            i.imprimirAdios();
            i.imprimirAlgo("Algo");
            break;
            case "interfaz":
            i = new ImpresoraInterfaz();
            i.imprimirHola();
            i.imprimirAdios();
            i.imprimirAlgo("Algo");
            break;
            default:
            System.out.println("ERROR");
        }

        sc.close();
    }
}
