package Básicos;

public class B_Variables {

    public static void main(String[] args) {
        
        /*Para crear una variable se indica el tipo de dato, su apodo y se asigna el valor. tipo apodo = valor; */
        int var1 = 0;

        //Tambien se puede hacer la declaracion (tipo dato;) y la inicializacion por separado (dato = valor;)
        int var2;
        var2 = 0;
        var2 = 2;
        System.out.println(var2+"|"+var1);

        //Multideclaracion:
        int a, b = 2, c, d = 4;
        a = 1;
        c = 2;
        System.out.println(a+b+c+d);
    }
}
