using static System.Console;
namespace Lessons{
    class Types{
        public static void ExMain(string[] args){
            
            //By Value:
            
            //--Primitives:

            //---Integers:

            //----Signed:
            sbyte a=-12;         //1 Byte
            short b=2292;       //2 Byte
            int c=-19292929;     //4 Byte
            long d=192922929;   //8 Byte
            
            //----Unsigned:
            byte e=199;         //1 Byte
            ushort f=1;         //2 Byte
            uint g=2;           //4 Byte
            ulong h=2;          //8 Byte    

            //---Floats:

            float i=202.2220F;  //4 Bytes
            double j=29.9292922;//8 Bytes
            decimal k=0.292292M;//12-16 bytes (32 and 64 bit systems)

            //---Booleans:

            bool l=true;        //1 Byte
            bool n=false;

            //--Structures:
            string str=$"{a}|{b}|{c}|{d}|{e}|{f}|{g}|{h}|{i}|{j}|{k}|{l}"; //2 bytes per character
            char m='a'; //2 bytes
            WriteLine(str+$"|{m}");


            //Operands:
            //Operands(numbers):
            WriteLine($"a+b={a+b}");//Add
            WriteLine($"a-b={a-b}");//Sub
            WriteLine($"a*b={a*b}");//Mult
            WriteLine($"a/b={a/b}");//Div
            WriteLine($"a%%b={a%b}");//Rest
            WriteLine($"a^b={a^b}");//bitwise xor
            WriteLine($"a&b={a&b}");//bitwise and
            // WriteLine($"a|b={a|b}");//bitwise or
            WriteLine($"~a={~a}");//bitwise complement
            WriteLine($"a<<b={a<<b}");//shift left
            WriteLine($"a>>b={a>>b}");//shift right
            WriteLine($"sizeof(int)={sizeof(int)}");//sizeof

            //Conditionals(true or false):
            WriteLine($"n&&l={n&&l}");//and
            WriteLine($"n||l={n||l}");//Or
            WriteLine($"!n={!n}");//Not
            WriteLine($"n==l={n==l}");//Equal
            WriteLine($"n!=l={n!=l}");//Not equal
            WriteLine($"a<b={a<b}");//Less than
            WriteLine($"a<=b={a<=b}");//Less than or equal
            WriteLine($"a>b={a>b}");//Greater than
            WriteLine($"a>=b={a>=b}");//Greater than or equal

            //Assignation operator
            a+=4;//a=a+4 with al operators
            --a;//Predecrement
            a--;//Postdecrement
            ++a;//Preincrement
            a++;//Postincrement


            //Const:
            const float PI = 3.1415F;
            //PI = 1.122323;//Error
            WriteLine($"{PI.ToString("0.00")}",PI);
            WriteLine($"{PI:0.00}",PI);
            const string MSG = "HIIIII";
            WriteLine($"Hello {MSG,10}");//spaces(- left)

            //Parsers:
            int x = 101010110;
            long y = (long) x;
            WriteLine(x+"\nNumber: ");
            // int p=int.Parse(ReadLine());

            //Implicit declaration:
            var hi="hi";
            WriteLine(hi);

            //Arrays:
            int[] array = {0,10,20,302,201,0};//Array declarator and initialize
            array[1]=1;//Access to element i from array

            int[,] array2D={{1,2,3},{2,5,6}};
            array2D[1,2]=3;

            var arrAnonymous= new []{3,1,2};
            int[] arrayVoid=new int[10];


        }
    }
}