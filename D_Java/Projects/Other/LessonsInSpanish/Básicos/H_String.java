package Básicos;

public class H_String {


    public static void main(String[] args) {
        /* Como string es un  objeto este tiene comandos*/

        //Hay dos formas de declarar:
        String a = "horllaaaaaa", b = new String("Buenas");
        String c = "horllaaaaaa";

        //Comandos:

        System.out.println(a.length());//Longitud de la cadena
        System.out.println(a.charAt(3));//Caracter en la posicion 3, se empieza por el 0.
        System.out.println(a.substring(0,2));//SubString desde la posicion 0 a la 2.
        System.out.println(b.equals("hola"));//Devuelve un boolean si son iguales.
        System.out.println(a.equalsIgnoreCase("HORLLAAAAAA"));//Devuelve un boolean si son iguales ignorando minusculas y mayusculas.
    }
    
}
