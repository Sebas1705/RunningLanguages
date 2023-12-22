package Avanzado.G_Threads.B_CreacionDeHilos;

public class Main {
    public static void main(String[] args){
        
        // Thread hilo1 = new Thread(new MiRunnable(10));
        // hilo1.start();
        // Thread hilo2 = new Thread(new MiRunnable(10));
        // hilo2.start();

        ThreadPropio[] hilos = {
            new ThreadPropio(),
            new ThreadPropio(),
            new ThreadPropio(),
            new ThreadPropio()
        };

        for(Thread t: hilos){
            t.start();
            try {
                t.join();//join obliga a la espera de terminar
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
}
