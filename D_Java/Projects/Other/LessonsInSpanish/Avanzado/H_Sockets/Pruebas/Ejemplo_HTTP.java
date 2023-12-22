package Avanzado.H_Sockets.Pruebas;

import java.io.*;
import java.net.*;

public class Ejemplo_HTTP {

    public static void main(String args[]) {
        
		BufferedReader entrada = null;
		PrintStream salida = null;
		Socket s = null;
		String datos;
		URL url;

		try {
			s=new Socket("hipertexto.info", 80);
			entrada=new BufferedReader(new InputStreamReader(s.getInputStream()));
			salida=new PrintStream(s.getOutputStream());
		
			salida.println("GET /");
				
			// Bucle para leer y presentar las líneas de la web hasta que se recibe un null      
			while( (datos = entrada.readLine())!=null ) {
				System.out.println(datos);
			}
		
			url=new URL("http","hipertexto.info",80,"/");
			System.out.println("Protocolo:"+url.getProtocol());
			System.out.println("Host:"+url.getHost());
			System.out.println("Puerto:"+url.getPort());
			System.out.println("Path:"+url.getPath());
			System.out.println("Fichero:"+url.getFile());
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}