package Avanzado.G_Threads.B_CreacionDeHilos;

public class MiRunnable implements Runnable {


    private int x;

    public MiRunnable(int x){
        this.x = x;
    }

    @Override
    public void run() {
        while(x >= 0){
            System.out.println((x--));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
