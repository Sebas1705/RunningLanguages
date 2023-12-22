package Almacenes;

import Partidas.Partida;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Almacen_Partidas implements Serializable{
    
    //Constantes:
    private static final long serialVersionUID = 3;
    //End Constantes.
    
    //Variables:
    private ArrayList<Partida> partidas;
    //End Variables.
    
    //Constructor:
    public Almacen_Partidas(){
        partidas = new ArrayList<>();
    }
    //End Constructor.

    //Métodos públicos:
    public void cargarFichero(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream entrada = new ObjectInputStream (new FileInputStream(nombreFichero));
        Almacen_Partidas almacen = (Almacen_Partidas) entrada.readObject();
        partidas = almacen.partidas;
        entrada.close();
    }
    public void grabarFichero(String nombreFichero) throws FileNotFoundException, IOException{
        ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(nombreFichero));
        salida.writeObject(this);
        salida.close();
    }
    public boolean añadirPartida(Partida nuevoPartida){
        //La partida solo se podra añadir si no existe ya
        //Si podemos añadir devolvemos true, sino false
        return partidas.add(nuevoPartida);
    }
    public boolean borrarPartida(Partida PartidaABorrar){
        //El jugador solo se borrara si aparece en el almacen, devolviendo asi true, 
        //en caso contrario o si no se puede eliminar por otro motivo, se devolvera false
        return partidas.remove(PartidaABorrar);
    }
    public Partida recuperarPartida(LocalDateTime fecha){
        for(Partida p : partidas){
            if(p.getFecha().equals(fecha)){
                return p;
            }
        }
        return null;
    }
    public Partida recuperarPartida(String fecha){
        for(Partida p : partidas){
            if(p.getFecha().toString().equals(fecha)){
                return p;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for(Partida p : partidas){
            sb.append(
                      "+--------------------------------------+\n"+
                      "|Resumen partida nº "+counter+":\n"+
                      "|Fecha: "+p.getFecha()+"|\n"+
                      "|Jugador1: "+p.getJugador1().getNombre()+"|\n"+
                      "|Jugador2: "+p.getJugador2().getNombre()+"|\n"+
                      "|Rosco1: "+p.getRosco1().toString()+"|\n"+
                      "|Rosco2: "+p.getRosco2().toString()+"|\n"+
                      "+--------------------------------------+\n"+
                      "\n"
            );
            counter++;
        }
        return sb.toString();
    }
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:

    //End Gets.
    
    //Sets:

    //End Sets.
}