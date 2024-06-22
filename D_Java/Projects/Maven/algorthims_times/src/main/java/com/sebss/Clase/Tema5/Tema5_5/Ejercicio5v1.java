package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ejercicio5v1 {

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

	// Posible intercalaci�n problem�tica por la cual esta soluci�n es err�nea:
	// S�lo hay un escritor bloqueado, esperando a que todos los lectores actuales terminen.
	// Cuando el �ltimo lector termina, desbloquea a dicho escritor. �se escritor tiene ahora
	// que competir para adquirir el cerrojo. Compite con posibles lectores que est�n esperando
	// bajo su condici�n (en inicioLectura) o con posibles lectores que est�n esperando para
	// entrar en la secci�n cr�tica en inicioLectura, o con posibles escritores que est�n
	// esperando para entrar en la secci�n cr�tica en inicioEscritura. Cualquiera de ellos puede
	// entrar en la secci�n cr�tica, no tiene por qu� ser el escritor que acabamos de desbloquear.
	// Supongamos que entra un lector que estaba esperando al principio de la secci�n cr�tica.
	// Dicho lector llegar� al while de inicioLectura y no se bloquear�, pues ambas condiciones
	// del while est�n a falso (�ya no hay ning�n escritor bloqueado en su condici�n, pues el que 
	// hab�a est� despierto y esperando para entrar!), por lo tanto el lector no se bloquea y
	// consigue acceder a la base de datos, col�ndose por delante del escritor despertado y por
	// lo tanto violando el principio del esquema lectores-escritores. Otra cosa que podr�a pasar
	// es que, en vez de adquirir el cerrojo el escritor al que acabamos de despertar, adquiere
	// el cerrojo un nuevo escritor que estaba esperando para entrar al principio de la secci�n
	// cr�tica, en inicioEscritura. Dicho escritor no se bloquear� en su condici�n y por lo tanto
	// adquirir� directamente la base de datos, col�ndose por delante del escritor que hemos
	// despertado. Esto �ltimo (que un nuevo escritor se adelante a otro que estaba antes) no
	// supone ning�n problema de cara a los requisitos, pero no est� mal saberlo.
	
	public void inicioLectura() {
		lock.lock();
		try {
			try {
				while (escritoresBD || lock.hasWaiters(escritoresCond)) {
					lectoresCond.await();
				}
			} catch (InterruptedException e) {
			}
			numLectoresBD++;
		} finally {
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
			try {
				while (numLectoresBD > 0 || escritoresBD) {
					escritoresCond.await();
				}
			} catch (InterruptedException e) {
			}
			escritoresBD = true;
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
		new Ejercicio5v1().exec();
	}
	
	private void sleep() {
		try {
			Thread.sleep((long) (Math.random()*500));
		} catch (InterruptedException e) {}
	}
}
