package Avanzado.E_ProgramacionGenerica;

import java.util.ArrayList;



public class Almacen<T>{
    
    private ArrayList<T> lista;
    private int n, lenght;

    public Almacen(int lenght){
        this.lenght = lenght;
        this.n = 0;
        this.lista = new ArrayList<T>();
    }

    public void añadirObjeto(T o) throws Exception{
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

    public T get(int index){return lista.get(index);}

    public ArrayList<T> getLista(){return lista;}
    public int getLenght(){return lenght;}
    public int getN(){return n;}

}
