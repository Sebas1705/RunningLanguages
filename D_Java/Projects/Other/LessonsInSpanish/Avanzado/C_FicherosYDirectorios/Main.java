package Avanzado.C_FicherosYDirectorios;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        File f = new File("Avanzado");
        
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.isAbsolute());
        
        System.out.println("*"+f.getName()+"*");
        System.out.println(imprimirSubArbol(f.getAbsolutePath(), 1, "\t"));

        File f2 = new File("Avanzado/C_FicherosYDirectorios/HolaBuenas.txt");
        // f2.mkdir();//Crear directorio.
        f2.createNewFile();//Crear archivo
        
    }

    public static String imprimirSubArbol(String path, int tab, String separador){
        File fPadre = new File(path);
        int tabs = tab;
        StringBuilder sb = new StringBuilder();
        String[] lista = fPadre.list();
        if(lista != null){
            for(String s : lista){
                for(int i = 0; i < tabs; i++) sb.append(separador);
                sb.append("|-");
                File fHijo = new File(path, s);
                if(fHijo.isFile()){
                    sb.append("File: "+s+"\n");
                }else if(fHijo.isDirectory()){
                    sb.append("Directory: "+s+"\n");
                    sb.append(imprimirSubArbol(fHijo.getAbsolutePath(), tabs+1, separador));
                }else{
                    sb.append("Archivo desconocido");
                }
            }
        }
        return sb.toString();
    }
}
