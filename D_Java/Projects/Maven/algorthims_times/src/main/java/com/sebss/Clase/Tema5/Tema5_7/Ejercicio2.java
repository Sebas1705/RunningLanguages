package com.sebss.Clase.Tema5.Tema5_7;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio2 {

	private ConcurrentMap<String, String> duplicates = new ConcurrentHashMap<String, String>();

	private ExecutorService executor = Executors.newFixedThreadPool(20);

	private AtomicInteger numTasks = new AtomicInteger();

	public void findConcurrent(File root) {

		try {

			System.out.println("Exploring dir " + root);

			for (File file : root.listFiles()) {
				
				if (file.isDirectory()) {
					
					numTasks.incrementAndGet();					
					executor.submit(() -> findConcurrent(file));
					
				} else {
					
					String path = duplicates.putIfAbsent(file.getName(), file.getAbsolutePath());
					
					if (path != null) {
						System.out.println("Found duplicate file: " + file.getName());
						System.out.println("    " + path);
						System.out.println("    " + file.getAbsolutePath());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (numTasks.decrementAndGet() == 0) {
			executor.shutdown();
		}
	}

	private void find(File dir) {

		numTasks.incrementAndGet();
		executor.submit(() -> findConcurrent(dir));
		
		try {
			executor.awaitTermination(50, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) {
		new Ejercicio2().find(
				new File("/home/mica/Data/Docencia/Asignaturas/PC/2014-2015/ws/EjerciciosClaseT5"));
	}

}
