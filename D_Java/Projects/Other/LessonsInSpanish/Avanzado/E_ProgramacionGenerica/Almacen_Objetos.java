package Avanzado.E_ProgramacionGenerica;

import java.util.ArrayList;

public class Almacen_Objetos{
    
    ArrayList<Object> lista;
    private int n, lenght;

    public Almacen_Objetos(int lenght){
        this.lenght = lenght;
        this.n = 0;
        this.lista = new ArrayList<Object>();
    }

    public void añadirObjeto(Object o) throws Exception{
        if(n == lenght) throw new Exception("Almacen Lleno");
        lista.add(o);
        n++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Lista Objetos:\n");
        if(n != 0) for(int i = 0; i < n; i++) sb.append((i+1)+"-"+lista.get(i).toString()+"\n");
        else sb.append("Vacia\n");
        sb.append("Fin Lista.\n");
        return sb.toString();
    }


    public ArrayList<Object> getLista(){return lista;}
    public int getLenght(){return lenght;}
    public int getN(){return n;}
}
