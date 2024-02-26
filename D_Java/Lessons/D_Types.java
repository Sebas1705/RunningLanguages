
public class D_Types {
    
    public static void main(String[] args) {
        
        //Integers:

            int i = 2147483647; //4 bytes | -2,147,483,648 to 2,147,483,647 | Two's complement
            System.out.println("Int: "+i);

            short s = 32767;
            System.out.println("Short: "+s); //2 bytes | -32,768 to 32,767 | Two's complement

            long l = 9223372036854775807L; //8 bytes | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (L or l) | Two's complement
            System.out.println("Long: "+l);

            byte by = 127; //1 byte | -128 to 127 | Two's complement
            System.out.println("Byte: "+by);
        
        //End Integers.

        //Decimals: 
            
            float f = 3.4028235E38F; //4 bytes | 1.4E-45 to 3.4028235E (f or F, E as exponent) | Simple precision 
            System.out.println("Float: "+f);

            double dou = 1.7976931348623157E308; //8 bytes | 4.9E-324 to 1.7976931348623157E308 | double precision
            System.out.println("Double: "+dou);

        //End Decimals.

        //Others: 

            char c1 = 65; //2 bytes | 0 to 127 or 'char' | ASCII table
            char c2 = 'A';
            System.out.println("Char: "+c2+c1);

            boolean bo = true; //1 bit | true or false | 1 o 0
            System.out.println("Boolean: "+bo);

            String st = "STRING"; //unlimited (2 bytes per char) | concat with + | "c1|c2|c1|.."
            String newStr = st + "string" + 'A' + c2;
            System.out.println("String: "+newStr);

        //End Others.


        //Operands:

        int a = 32, b = 189;

        //Arithmetics:

            System.out.println(a+b);//Sum
            System.out.println(a-b);//Subtract
            System.out.println(a*b);//Multiply
            System.out.println(a/b);//Division
            System.out.println(a%b);//Mod

        //End Arithmetics.

        boolean c = true, d = false, e = true;

        //Logics:

            System.out.println(c==d);//Equal
            System.out.println(c!=d);//Not equal
            System.out.println(a>b);//Greater
            System.out.println(a>=b);//Greater or equal
            System.out.println(a<b);//Minor
            System.out.println(a<=b);//Minor or equal
            System.out.println(c&&d);//AND
            System.out.println(d||e);//OR
            System.out.println(!d);//NOT

        //End Logics.

        String cad1 ="Hola ", cad2 = "Mundo ";
        char ss = '!';

        //Compound:

            System.out.println(a++);//Postincrement 
            System.out.println(++a);//Preincrement
            System.out.println(a--);//Postdecrement
            System.out.println(--a);//Predecrement
            a += 7; //Compress operation
            System.out.println(cad1+cad2+a+ss);//Concat
        
        //End Compound.

        //Const:
        
            final double PI = 3.14;
            System.out.println(PI);

        //End const.

        //Parsers:

            int number = 2;
            double x = (double) number;
            System.out.println("Parser: "+x);

        //End parsers.

        //Implicit:

            var hola = 2;
            System.out.println(hola);

        //End implicit.

        //Arrays:

            int[] array; 
            array = new int[]{0,10,20,302,201,0};//Array declarator and initialize
            array[1]=1;//Access to element i from array

            int[][] array2D={{1,2,3},{2,5,6}};
            array2D[1][2]=3;

            int[] arrayVoid=new int[10];
            arrayVoid[3]=1000;

        //End arrays.
    }    
}
