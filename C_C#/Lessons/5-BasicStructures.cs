using static System.Console;

namespace Lessons
{
    public class BasicStructures
    {
        public static void ExMain(string[] args)
        {
            //if:
            Write("---------If-----------\n");
            int a=3;
            if(a==2){
                Write("Twice\n");
            }else if(a==1){
                Write("Once\n");
                goto switch_t; //Go to the next switch_t
            }else{
                Write($"a is {a}\n");
            }

            switch_t:
            //Switch:
            Write("-------SWITCH--------\n");
            switch(a){
                case 1:
                    Write("a is 1\n");
                    break;//Break out actual struct.
                case 2:
                    Write("a is 2\n");
                    break;
                default:
                    Write($"a is {a}\n");
                    break;
            }

            //While:
            Write("--------WHILE---------\n");
            while(a<6){
                a++;
                if(a==5)continue; //Jump to next repetition of loop
                Write($"{a}\n");
            }

            //Do_While:
            Write("-------DO_WHILE--------\n");
            do{
                a++;
                if(a==9)continue;
                if(a==13)break;
                Write($"{a}\n");
            }while(a<=14);

            //For:
            Write("---------FOR----------\n");
            for(int i=0;i<3;i++){
                Write($"{a}\n");
            }

            //Foreach:
            Write("-------FOR-EACH-------\n");
            string[] strs={"hi","hello","mmm"};
            foreach(string c in strs) Write(c);

        }
    }
}
