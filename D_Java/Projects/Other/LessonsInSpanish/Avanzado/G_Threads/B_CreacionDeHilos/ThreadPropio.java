package Avanzado.G_Threads.B_CreacionDeHilos;

public class ThreadPropio extends Thread {

    public ThreadPropio(){
        super();
    }

    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println("Hola mundo "+i+"; Hilo: "+getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
