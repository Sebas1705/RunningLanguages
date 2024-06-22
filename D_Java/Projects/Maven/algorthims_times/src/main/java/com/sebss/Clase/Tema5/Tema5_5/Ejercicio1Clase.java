package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.Semaphore;

public class Ejercicio1Clase {
    
    private static final int PRODUCTORES = 5;
	private static final int CONSUMIDORES = 3;
	
	private BufferSinc buffer;

	private static void sleepRandom(long max) throws InterruptedException {
		Thread.sleep((long) (Math.random() * max));		
	}

	public void productor() {
		try {
			for (int i = 0; i < 20; i++) {
				sleepRandom(500);
				System.out.println("Producido:"+i);
				buffer.insertar(i);
			}
		} catch (InterruptedException e) {
		}
	}

	public void consumidor() {
		try {
			while (true) {
				int data = buffer.sacar();
				sleepRandom(1000);
				System.out.println("Consumido:"+data);
			}
		} catch (InterruptedException e) {
		}
	}

	public void exec() {

		buffer = new BufferSinc();

		for (int i = 0; i < PRODUCTORES; i++) {
			new Thread(()->productor(),"Productor " + i).start();
		}

		for (int i = 0; i < CONSUMIDORES; i++) {
			new Thread(()->consumidor(),"Consumidor " + i).start();
		}
	}
	
	public static void main(String[] args){
		new Ejercicio1Clase().exec();
	}

    private class BufferSinc {

        private static final int BUFFER_SIZE = 10;
        
        private int[] datos = new int[BUFFER_SIZE];
        private int posInser = 0;
        private int posSacar = 0;
        
        private Semaphore nHuecos = new Semaphore(BUFFER_SIZE);
        private Semaphore nProductos = new Semaphore(0);
        private Semaphore emPosInser = new Semaphore(1);
        private Semaphore emPosSacar = new Semaphore(1);
        
        public void insertar(int dato) throws InterruptedException {		
            nHuecos.acquire();		
            
            emPosInser.acquire();
            datos[posInser] = dato;
            posInser = (posInser+1) % datos.length;
            emPosInser.release();
            
            nProductos.release();
        }
    
        public int sacar() throws InterruptedException {		
            nProductos.acquire();
            
            emPosSacar.acquire();
            int dato = datos[posSacar];
            posSacar = (posSacar+1) % datos.length;
            emPosSacar.release();
            
            nHuecos.release();	
            
            return dato;
        }
    }
}
