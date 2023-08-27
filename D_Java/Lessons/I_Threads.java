

public class I_Threads {
    
    public static void main(String[] args) throws InterruptedException {

        final int loops=2;
        final int nThreads=4;
        final Thread threads[]=new Thread[nThreads];

        //Lambda:
        threads[0]=new Thread(()->thread(loops));
        
        //Anonymous interface:
        threads[1]=new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i=0;i<loops;i++) System.out.println(Thread.currentThread().getName()+": "+i);
            }
        });
        
        //Implemented interface:
        MeRunnable m=new MeRunnable(loops);
        threads[2]=new Thread(m);

        //Implemented class:
        threads[3]=new MeThread(loops);

        for(int i=0;i<nThreads;i++)threads[i].start();
        for(int i=0;i<nThreads;i++)threads[i].join();

        
        //Process:
        try{
            new ProcessBuilder("notepad.exe","E:\\Escritorio\\Programacion\\RunningLanguages\\D_Java\\Lessons\\I_Threads.java").start();
        }catch(Exception e) {System.out.println(e.getMessage());}
        
        
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+": program finished successfully...");


    }

    public static void thread(int loops){
        for(int i=0;i<loops;i++)System.out.println(Thread.currentThread().getName()+": "+i);
    }

    static class MeRunnable implements Runnable{
        private int loop;
        public MeRunnable(int loop){this.loop=loop;}
        @Override
        public void run(){
            for(int i=0;i<loop;i++)System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }

    static class MeThread extends Thread{
        private int loop;
        public MeThread(int loop){this.loop=loop;}
        @Override
        public void run(){
            for(int i=0;i<loop;i++)System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
