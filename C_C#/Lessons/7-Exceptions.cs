using static System.Console;

namespace Lessons
{
    public class Exceptions
    {
        public static void ExMain(string[] args){
            try{
                /*
                    code with possible exception
                */
                string? input = ReadLine() ?? throw new NullReferenceException("Input is null");
                int i = int.Parse(input); //possible format exception and null exception.
            }catch(FormatException e){
                WriteLine("Format exception: " + e.Message);
            }catch(NullReferenceException e){
                WriteLine("Null reference exception: " + e.Message);
            }finally{
                WriteLine("\n\n-->Always work");
            }
        }
    }
}