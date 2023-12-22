package Avanzado.B_Serializacion;

import java.io.*;
import java.util.ArrayList;

public class Almacen_Casas implements Serializable{
    
    private ArrayList<Casa> lista;
    private int n, lenght;
    private static final long serialVersionUID = 1L;

    public Almacen_Casas(int lenght){
        this.lenght = lenght;
        this.n = 0;
        this.lista = new ArrayList<Casa>();
    }

    public void añadirCasa(Casa c) throws Exception{
        if(n == lenght) throw new ExceptionAlmacenLleno("Almacen Lleno");
        lista.add(c);
        n++;
    }

    public void guardar(String path) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(this);
        oos.close();
    }

    public void cargar(String path){
        try{
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(path));
            Almacen_Casas acs = (Almacen_Casas) oos.readObject();
            this.lista = acs.getLista();
            this.n = acs.getN();
            this.lenght = acs.getLenght();
            oos.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Lista Casas:\n");
        if(n != 0) for(int i = 0; i < n; i++) sb.append((i+1)+"-"+lista.get(i).toString()+"\n");
        else sb.append("Vacia\n");
        sb.append("Fin Lista.\n");
        return sb.toString();
    }

    public ArrayList<Casa> getLista(){return lista;}
    public int getLenght(){return lenght;}
    public int getN(){return n;}
    public long getSerial(){return serialVersionUID;}
}
