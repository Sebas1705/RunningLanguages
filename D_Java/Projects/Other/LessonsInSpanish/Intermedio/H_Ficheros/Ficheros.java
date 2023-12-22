package Intermedio.H_Ficheros;

import java.io.*;

public class Ficheros {
    public static void main(String[] args){
        String path = "C:/Users/sebss/Escritorio/Programacion/Java/VisualStudioCode/CursoPreSpring/Intermedio/H_Ficheros/texto.txt";
        String path2 = "C:/Users/sebss/Escritorio/Programacion/Java/VisualStudioCode/CursoPreSpring/Intermedio/H_Ficheros/texto2.txt";
        int[] datos  = new int[34];
        try {
            //Escritura Caracteres:
                // File f = new File("Intermedio/H_EscrituraFicheros/texto.txt");
                // FileWriter writer = new FileWriter(f);
                // BufferedWriter bw = new BufferedWriter(writer, 2048);
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)), 2048);
                bw.write("Hola Mundo\n");//Escribir depues de borrar.
                bw.append("MENSAJE CUALQUIERA\n");//Escribir a continuacion.
                bw.flush();//Limpia el buffer para que no se llene, pero no se pierde lo escrito.
                bw.append("Hola");
                bw.close();//Cierre del buffer para que escriba y se libere. OBLIGATORIO DE USAR
            //Fin Escritura.

            //Lectura Caracteres:
                // File f = new File("Intermedio/H_EscrituraFicheros/texto.txt");
                // FileReader reader = new FileReader(f);
                // BufferedReader br = new BufferedReader(reader, 2048);
                BufferedReader br = new BufferedReader(new FileReader(new File(path)),2048);
                String line;
                while((line = br.readLine()) != null) System.out.println(line);
                br.close();
            //End Lectura.

            //Lectura bytes:
                FileInputStream fis = new FileInputStream(path);
                int b, cont = 0;
                while((b = fis.read()) != -1){ System.out.print(b+"-");datos[cont++] = b;}
                System.out.println(cont);
                fis.close();
            //Fin Lectura bytes.

            //Escritura bytes:
                FileOutputStream fos = new FileOutputStream(path2);
                int cont2 = 0;
                while(cont2 < 34){fos.write(datos[cont2++]);}
                fos.close();
            //End Escritura bytes.
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        

    }
}
