package Básicos;

public class J_If {
    public static void main(String[] args) {
        
        boolean condicion = false, condicion2 = true;
        int a = 22, b = 33;

        //Condicion original
        if(condicion){
            System.out.println("Se cumplio la condicion");
        }
        //Otra condicion, solo se ejecuta si la primera es falsa.
        else if(condicion2){
            System.out.println("Se cumplio la condicion2");
        }
        //Contracondicion, solo se ejecuta si la original y las otras condiciones resultan falsas.
        else{
            System.out.println("No se cumplio las condiciones");
        }


        if(!(a<b && a!=b)) 
            System.out.println("Hola");
        else if(a>b) 
            System.out.println("Adios");
        else 
            System.out.println("No hay saludo");
    }
}
