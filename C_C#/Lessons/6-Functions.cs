using static System.Console;

namespace Lessons
{
    public class Functions
    {
        public static void ExMain(string[] args){
            printSomething("WOW");
        }

        static void printSomething(string something){
            Write(something+Sum(3,5));
            Write(Sum(2,3,2,4,2,3));
        }
        static int Sum(int x,int y,int z=0){
            return x + y + z;
        }
        static int Sum(params int[] x){
            return x.Sum();
        }
        static int Max(int i1, int i2){
            return i1>i2 ? i2 : i1;
        }
    }
}