package Básicos;

public class T_TresPuntosYTernario{
    public static void main(String[] args) {
        
        //Operador ternario:
        // (condicion) ? resuladoSiTrue : resuladoSiFalse;
        boolean sel = true;
        System.out.println((sel) ? "-True" : "-False");

        //Tres puntos uso:
        System.out.println(suma(1,2));
        System.out.println(suma(1,2,3));
        System.out.println(suma(1,2,5,4));
    }

    public static int suma(int... elementos){
        int total = 0;
        for(int i : elementos) total += i;
        return total;
    }
}