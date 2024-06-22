package com.sebss.Clase.Tema5.Tema5_3;

public class Ejercicio1 {

	private volatile boolean producido = false;
	private volatile double producto;

	public void productor() {
		producto = Math.random();
		producido = true;
	}

	public void consumidor() {
		while (!producido);
		System.out.println("Producto: " + producto);
	}

	public void exec() {
		new Thread( ()->productor() ).start();
		new Thread( ()->consumidor() ).start();
	}

	public static void main(String[] args) {
		new Ejercicio1().exec();
	}
}
