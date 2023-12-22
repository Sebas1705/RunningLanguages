package Básicos;

public class C_TiposDeDatosBasicos {
    public static void main(String[] args) {
        
        //Enteros:
            //Int: 4 bytes de almacenamiento. 
            //Limites: -2,147,483,648 hasta 2,147,483,647.
            //Codificado: Complemento a dos.
            int i = 2147483647;
            System.out.println("Int: "+i);
            //---------------------------------------------------------------------------//
            //Short: 2 bytes de almacenamiento. 
            //Limites: -32,768 hasta 32,767. 
            //Codificado: Complemento a dos.
            short s = 32767;
            System.out.println("Short: "+s);
            //---------------------------------------------------------------------------//
            //Long: 8 bytes de almacenamiento. 
            //Limites: -9,223,372,036,854,775,808 hasta 9,223,372,036,854,775,807 con prefijo l o L. 
            //Codificado: Complemento a dos.
            long l = 9223372036854775807L;
            System.out.println("Long: "+l);
            //---------------------------------------------------------------------------//
            //Byte: 1 byte de almacenamiento. 
            //Limites: -128 hasta 127.
            //Codificado: Complemento a dos.
            byte b = 127;
            System.out.println("Byte: "+b);
        //End Enteros.

        //Decimales: 
            //Float: 4 bytes de almacenamiento. 
            //Limites:  1.4E-45 hasta 3.4028235E38 con prefijo f o F. "E" significa exponente, por lo que 1.4E-45 es lo mismo que 1.4 * 10^-45.
            //Codificado: precisión simple.
            float f = 3.4028235E38F;
            System.out.println("Float: "+f);
            //---------------------------------------------------------------------------//
            //Double: 8 bytes de almacenamiento. 
            //Limites: 4.9E-324 hasta 1.7976931348623157E308.
            //Codificado: precisión doble.
            double d = 1.7976931348623157E308;
            System.out.println("Double: "+d);
        //End Decimales.

        //Otros: 
            //Char: 2 bytes de almacenamiento. 
            //Limites:  0 hasta 127. Se puede poner como numero Ej.: char c = 65 que es lo mismo que poner char c = 'A'.
            //Codificado: tabla ASCII.
            char c1 = 65; 
            char c2 = 'A';
            System.out.println("Char: "+c2+c1);
            //---------------------------------------------------------------------------//
            //Boolean: 1 bit de almacenamiento. 
            //Limites:  true or false.
            //Codificado: 1 o 0.
            //Valor nulo: true.
            boolean bo = true;
            System.out.println("Boolean: "+bo);
            //---------------------------------------------------------------------------//
            //String: "ilimitado" de almacenamiento. 
            //Limites:  lo largo que quieras. Se concatenan haciendo uso del +. Ej.: String nueva = cad1 + cad2.
            //Codificado: "char0/char1/char2/.../charN-1".
            String st = "CADENA";
            String nueva = st + "cadena" + 'A' + c2;
            System.out.println("String: "+nueva);
        //End Otros.
    }
}
