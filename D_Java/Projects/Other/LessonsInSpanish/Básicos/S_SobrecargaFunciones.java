package Básicos;

public class S_SobrecargaFunciones {
    public static void main(String[] args) {
        System.out.println(suma(1,23,4,2));
        System.out.println(suma(23,42,1));
        System.out.println(suma(1,1));
    }

    public static int suma(int op1, int op2){return op1 + op2;}
    public static int suma(int op1, int op2, int op3){return op1 + op2 + op3;}
    public static int suma(int op1, int op2, int op3, int op4){return op1 + op2 + op3 + op4;}
}
