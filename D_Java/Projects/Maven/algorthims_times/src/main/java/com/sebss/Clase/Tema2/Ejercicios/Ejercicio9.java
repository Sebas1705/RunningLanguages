package com.sebss.Clase.Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;
import es.urjc.etsii.code.concurrency.SimpleSemaphore;

public class Ejercicio9 {
    
    /**
     * a) Se quiere implementar una aplicación para descargar ficheros. La aplicación debe tener la capacidad de
     * descargar un único fichero, pero debe ser capaz de descargar varios fragmentos del fichero de manera
     * concurrente para aprovechar de forma más eficiente la red.
     * Para simplificar la aplicación, consideramos que un fichero se representa en memoria como un array de
     * enteros. Internamente, la aplicación dispone de una serie de procesos que van descargando los diferentes
     * fragmentos del fichero (posiciones del array). Los procesos están ejecutando tres acciones: primero se
     * determina el siguiente fragmento a descargar, a continuación se descarga ese fragmento, y por último se
     * guarda el fragmento descargado en el array que representa el fichero.
     * La solución se puede implementar con espera activa o con semáforos. 
     * b) En la plantilla anterior, la impresión del fichero se realiza en el hilo principal. Se pide implementar el
     * mismo programa de descarga de ficheros pero esta vez la impresión será realizada por el último proceso
     * que guarde un fragmento descargado en el fichero.
    */

    private static final int N_FRAGMENTOS = 100;
    private static final int N_HILOS = 3;
    private static volatile int[] fichero = new int[N_FRAGMENTOS];
    private static volatile int n=0;
    private static volatile boolean mostrado=false;
    private static SimpleSemaphore semaphore = new SimpleSemaphore(1);

    private static int descargarDatos(int numFragmento) {
        sleepRandom(100);
        return numFragmento*2;
    }

    private static void mostrarFichero() {
        println("--------------------------------------------------");
        print("File = [");
        for (int i = 0; i < N_FRAGMENTOS; i++) {
            print(fichero[i]+"");
            if(i!=N_FRAGMENTOS-1)print(",");
        }
        println("]");
    }

    public static void downloader() {
        while(true){
            semaphore.acquire();
            if(n==N_FRAGMENTOS) {
                if(!mostrado) {
                    mostrado=true;
                    mostrarFichero();   
                }
                semaphore.release();
                break;
            }
            int a = n++;
            semaphore.release();
            println(getThreadName()+": Descargando y escribiendo fragmento "+a);
            fichero[a]=descargarDatos(a); 
        }
        //Mientras hay fragmentos que descargar...
        //Descargar los datos del siguiente fragmento
        //Almacenar los datos en el array
    }

    public static void main(String[] args) {
        createThreads(N_HILOS, "downloader");
        startThreadsAndWait();
    }
        
        
}
