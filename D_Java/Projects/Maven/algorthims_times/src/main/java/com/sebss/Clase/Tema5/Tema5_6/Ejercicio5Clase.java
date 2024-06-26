package com.sebss.Clase.Tema5.Tema5_6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ejercicio5Clase {
    
    private static int NUM_TIPOS_PIEZAS = 3;
	private static int NUM_ROBOTS = 3;

	private AlmacenPiezas almacen = new AlmacenPiezas(NUM_TIPOS_PIEZAS);

	private double fabricarPieza(int tipoPieza) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
		double pieza = tipoPieza + Math.random();
		System.out.println(Thread.currentThread().getName() + ": " + pieza);
		return pieza;
	}

	private void montarPieza(int tipoPieza, double pieza) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 500));
		System.out.println(Thread.currentThread().getName() + ": " + pieza);
	}

	public void maquina(int numMaquina, int tipoPieza) {
		try {
			while (true) {
				double pieza = fabricarPieza(tipoPieza);
				almacen.almacenarPieza(tipoPieza, pieza);
			}
		} catch (InterruptedException e) {
		}
	}

	public void robot(int numRobot) {
		try {
			while (true) {
				for (int i = 0; i < NUM_TIPOS_PIEZAS; i++) {
					double pieza = almacen.recogerPieza(i);
					montarPieza(i, pieza);
				}
				System.out
						.println("---> " + Thread.currentThread().getName() + " Producto montado");
			}
		} catch (InterruptedException e) {
		}
	}

	public void exec() {
		for (int i = 0; i < NUM_TIPOS_PIEZAS; i++) {
			int numMaquina = i;
			new Thread(() -> maquina(numMaquina, numMaquina), "Maquina-" + numMaquina).start();
		}
		for (int i = 0; i < NUM_ROBOTS; i++) {
			int numRobot = i;
			new Thread(() -> robot(numRobot), "Robot-" + numRobot).start();
		}
	}

	public static void main(String[] args) {
		new Ejercicio5Clase().exec();
	}

	public class AlmacenPiezas {

		public static int MAX_PIEZAS = 5;
		
		private List<BlockingQueue<Double>> colas;
		
		public AlmacenPiezas(int numTiposPieza) {
			colas = new ArrayList<BlockingQueue<Double>>();
			for(int i=0; i<numTiposPieza; i++){
				colas.add(new LinkedBlockingQueue<Double>(MAX_PIEZAS));
			}
		}
	
		public void almacenarPieza(int tipoPieza, double pieza) throws InterruptedException {
			colas.get(tipoPieza).put(pieza);	
		}
	
		public double recogerPieza(int tipoPieza) throws InterruptedException {
			return colas.get(tipoPieza).take();
		}
	
	}
}
