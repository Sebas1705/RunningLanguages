package Intermedio.I_ObjetosPrimitivos;

public class Main {
    public static void main(String[] args) {
        

        //Todos los Objetos:
        Byte byteA = 1;
        Integer entero = 1;
        Short corto = 12;
        Double doble = 2.11;
        Float flotante = 1.23f;
        Character caracter = 'c';
        String cadena = "Hola";

        //Se pueden iniciar como un objeto normal por
        // Integer entero2 = new Integer(2); //Aunque es redundante.

        System.out.println(byteA+entero+caracter+corto+doble+flotante+cadena);

        //Como son objetos tienen funciones extras que los normales no:
        System.out.println(Integer.parseInt("2")); //Pasa un valor char o string a numero, hay para todos los otros objetos 
        System.out.println(Double.parseDouble("2.2"));

    }
}
