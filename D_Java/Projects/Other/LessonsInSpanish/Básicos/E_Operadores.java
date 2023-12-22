package Básicos;

public class E_Operadores {
    public static void main(String[] args) {
        int a = 32, b = 189;

        //Aritmeticos:
            System.out.println(a+b);//Suma
            System.out.println(a-b);//Resta
            System.out.println(a*b);//Multiplicacion
            System.out.println(a/b);//Division
            System.out.println(a%b);//Resto
        //End Aritmeticos.

        boolean c = true, d = false, e = true;

        //Logicos:
            System.out.println(c==d);//Igual
            System.out.println(c!=d);//Diferente
            System.out.println(a>b);//Mayor
            System.out.println(a>=b);//Mayor o igual
            System.out.println(a<b);//Menor
            System.out.println(a<=b);//Menor o igual
            System.out.println(c && d);//Y logico (AND)
            System.out.println(d || e);//O logico (OR)
            System.out.println(!d);//No logico (NOT)

        //End Logicos.

        String cad1 ="Hola ", cad2 = "Mundo ";
        char ss = '!';

        //Compuestas:
            System.out.println(a++);//Postincremento
            System.out.println(++a);//Preincrementor
            System.out.println(a--);//Postdecremento
            System.out.println(--a);//Predecremento
            a += 7;//Lo mismo que a = a + 7. Se puede hacer con todos los operadores aritmeticos.
            System.out.println(cad1+cad2+a+ss);//Concatenacion. + pasa a concatenar si hay presencia de string o caracter.
        //End Compuestas.
    
    }
}
