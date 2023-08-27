namespace Lessons
{
    public class Threads{
        public static void ExMain(string[] args){
            Thread thread= new Thread(CountDown);
            Thread thread1= new Thread(()=>{ //Lambda function
                while(thread.IsAlive){
                    Thread.Sleep(500);
                    Console.WriteLine("Waiting thread..");
                }
            });
            thread.Start();
            thread1.Start();
            thread.Join();
            thread1.Join();
        }

        private static void CountDown(){
            for(int i=0;i<10;i++){
                Console.WriteLine("CD: "+i);
                Thread.Sleep(1000);
            }
        }
    }
}