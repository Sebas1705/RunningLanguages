package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ejercicio5v2 {

	private ReentrantLock lock = new ReentrantLock();

	// Para que los escritores esperen antes de empezar a escribir
	private Condition escritoresCond = lock.newCondition(); 

	// Para que los lectores esperen antes de empezar a leer
	private Condition lectoresCond = lock.newCondition();
	
	// Cuantos lectores hay ahora leyendo
	private int numLectoresBD = 0; 

	// Si hay un escritor ahora escribiendo (s�lo puede haber un escritor
	// a la vez escribiendo, por lo tanto no es necesario contarlos como s�
	// hacemos con los lectores en "numLectoresBD"
	private boolean escritoresBD = false; 

	// Nos indica que hay un escritor que se qued� esperando en su condici�n,
	// fue despertado y ahora est� esperando para entrar en su secci�n cr�tica.
	// Deber�a evitar que un lector que est� esperando para entrar en la secci�n
	// cr�tica de "inicioLectura" se cuele por delante de un escritor que estaba
	// bloqueado en su condici�n y fue despertado. Esto ocurre porque alguien 
	// que haya sido despertado de su bloqueo en una condici�n no tiene m�s
	// prioridad para entrar en la secci�n cr�tica que otro proceso que est�
	// esperando para entrar en la misma secci�n cr�tica (ya sea en otra 
	// condici�n o en el m�todo lock()). Sin embargo, como veremos en un
	// comentario en el m�todo inicioEscritura, esta soluci�n a�n es incorrecta
	// porque a�n un lector puede seguir col�ndose por delante de un escritor
	private boolean hayEscritorPreparado = false;
	
	public void inicioLectura() {
		lock.lock();
		try {
			while (escritoresBD || lock.hasWaiters(escritoresCond) || hayEscritorPreparado) 
				lectoresCond.await();
			numLectoresBD++;			
		} catch (InterruptedException e) {}			
		finally {
			lock.unlock();
		}
	}

	public void finLectura() {
		lock.lock();
		try {
			numLectoresBD--;
			if (numLectoresBD == 0 && lock.hasWaiters(escritoresCond)) {
				escritoresCond.signal();
			}
		} finally {
			lock.unlock();
		}
	}

	public void inicioEscritura() {
		lock.lock();
		try {
			hayEscritorPreparado=true;					
			try {
				while (numLectoresBD > 0 || escritoresBD) escritoresCond.await();
			} catch (InterruptedException e) {}
			escritoresBD = true;

			/* Supongamos que el �ltimo escritor que estaba bloqueado en su condici�n
			 * fue desbloqueado pero no accedi� a la secci�n cr�tica. Si un lector
			 * bloqueado a la entrada de inicioLectura toma la secci�n cr�tica, se 
			 * bloquear� en su condici�n debido a la nueva variable "hayEscritorPreparado",
			 * o sea que eso no es problema. El problema es que, en vez de entrar el 
			 * escritor desbloqueado, entre a la secci�n cr�tica un nuevo escritor que
			 * estaba esperando al inicio de inicioEscritura. Dicho escritor no se bloquear�
			 * en la condici�n, y llegar� hasta aqu�. Y, como vemos en la siguiente
			 * instrucci�n, pondr� "hayEscritorPreparado" a falso, pues ya no hay ning�n
			 * escritor bloqueado en la condici�n (el que estaba bloqueado, fue desbloqueado
			 * y actualmente est� esperando para entrar en la secci�n cr�tica). Cuando este
			 * nuevo escritor termine, un lector nuevo podr� acceder a la secci�n cr�tica,
			 * pues "hayEscritorPreparado" estar� a false, col�ndose por delante de nuestro
			 * primer escritor, que a�n sigue desbloqueado en su condici�n y esperando para
			 * acceder a la secci�n cr�tica. Por lo tanto, esta soluci�n sigue siendo err�nea */
			if (!lock.hasWaiters(escritoresCond)) hayEscritorPreparado=false;
		} finally {
			lock.unlock();
		}
	}

	public void finEscritura() {
		lock.lock();
		try {
			escritoresBD = false;
			if (lock.hasWaiters(escritoresCond)) {
				escritoresCond.signal();
			} else {
				lectoresCond.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

	public void lector() {
		while (true) {
			inicioLectura();
			System.out.println("Leer datos 1");
			sleep();
			System.out.println("Leer datos 2");
			finLectura();
			System.out.println("Procesar datos");
			sleep();
		}
	}

	public void escritor() {
		while (true) {
			System.out.println("Generar datos");
			inicioEscritura();
			System.out.println("Escribir datos 1");
			sleep();
			System.out.println("Escribir datos 2");
			finEscritura();
			sleep();
		}
	}

	public void exec() {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> lector()).start();
		}

		for (int i = 0; i < 3; i++) {
			new Thread(() -> escritor()).start();
		}
	}

	public static void main(String[] args) {
		new Ejercicio5v2().exec();
	}
	
	private void sleep() {
		try {
			Thread.sleep((long) (Math.random()*500));
		} catch (InterruptedException e) {}
	}
}
