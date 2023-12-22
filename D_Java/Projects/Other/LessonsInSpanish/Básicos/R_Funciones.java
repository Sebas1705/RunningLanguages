package Básicos;

//Comentarios de archivos
/**
 * @author sebssgarcia502580@gmail.com
 * @version 1.0
 */

public class R_Funciones {
    public static void main(String[] args) {
        
        funcion2("Hola Mundo");
        int a = 0, b = 2;
        System.out.println("Resultado: "+funcion(a,b));
    }

    //Funciones: palabra public hace referencia a su acceso externo (mas adelante, por ahora se puede omitir).
    //La palabra static se usa para funciones que su funcion no depende de atributos de clase no estaticos.
    //La definicion se hace: tipoValorRetorno nombreFuncion(operandos(0, 1 o muchos)).
    public static int funcion(int op1, int op2){
        return op1 + op2;
    }

    //Comentarios de funciones:

    /**
     * Descripcion de la funcion: 
     * Esta funcion imprime la cadena de texto que se pasa como parametro, y devuelve 1 al terminar
     * de ejecutar.
     * 
     * @param s : String que se quiere imprimir.
     * @return entero que representa el funcionamiento del metodo.
     * 
     */
    public static int funcion2(String s){
        System.out.println(s);
        return 1;
    }
}
