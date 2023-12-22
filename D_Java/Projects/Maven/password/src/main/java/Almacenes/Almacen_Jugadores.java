package Almacenes;

import Jugadores.Jugador;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Almacen_Jugadores implements Serializable{
    
    //Constantes:
    private static final long serialVersionUID = 1;
    //End Constantes.
    
    //Variables:
    private ArrayList<Jugador> jugadores;
    //End Variables.
    
    //Constructor:
    public Almacen_Jugadores(){
        jugadores = new ArrayList<>();
    }
    //End Constructor.
    
    //Métodos públicos:
    public void cargarFichero(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream entrada = new ObjectInputStream (new FileInputStream(nombreFichero));
        Almacen_Jugadores almacen = (Almacen_Jugadores) entrada.readObject();
        jugadores = almacen.getJugadores();
        entrada.close();
    }
    public void grabarFichero(String nombreFichero) throws FileNotFoundException, IOException{
        ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(nombreFichero));
        salida.writeObject(this);
        salida.close();
    }
    public void exportarClasificacionTXT(String nombreFichero) throws IOException{
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)));
        salida.println(this.stringClasificacion(true));
        salida.close();
    }
    public String stringClasificacion(boolean por_puntos){
        //Si pasamos true, el arrayList se ordenara automaticamente por puntos de los jugadores.
        if(por_puntos){
            ArrayList<Jugador> clasificacion = jugadores;
            Collections.sort(clasificacion, new Comparator<Jugador>() {
                @Override
                public int compare(Jugador p1, Jugador p2) {
                        return new Integer(p2.getPuntos()).compareTo(new Integer(p1.getPuntos()));
                }
            });
            return stringJugadores(clasificacion, "Clasificación");
        }else{
            return stringJugadores(jugadores, "Jugadores");
        }
    }
    public boolean añadirJugador(Jugador nuevoJuagdor){
        //El jugador solo se podra añadir si no existe ya
        //Si podemos añadir devolvemos true, sino false
        return jugadores.add(nuevoJuagdor);
    }
    public boolean borrarJugador(Jugador jugadorABorrar){
        //El jugador solo se borrara si aparece en el almacen, devolviendo asi true, 
        //en caso contrario o si no se puede eliminar por otro motivo, se devolvera false
        return jugadores.remove(jugadorABorrar);
    }
    public boolean existeJugador(String nombre){
        //Buscamos si existe por su nombre que lo identifica.
        //Si se existe devuelve true, si no false
        for(Jugador j : jugadores){
            if(nombre.equals(j.getNombre())) return true;
        }
        return false;
    }
    public Jugador recuperarJugador(String nombre){
        //Buscamos el jugador con nombre.
        //Y lo devolvemos, si no esta directamente null.
        if(existeJugador(nombre)){
            for(Jugador j : jugadores){
                if(nombre.equals(j.getNombre())){
                    return j;
                }
            }
        }
        return null;
    }
    public String jugadoresInfo(){
        StringBuilder sb = new StringBuilder();
        for(Jugador j : jugadores){
            sb.append(j.mostrarHistorial());
        }
        return sb.toString();
    }
    public String[] arrayStringListaJugadores(){
        String[] array = new String[jugadores.size()];
        int counter = 0;
        for(Jugador j : jugadores){
            array[counter] = j.getNombre();
            counter++;
        }
        return array;
    }
    //End Métodos públicos.

    //Métodos privados:
    private String stringJugadores(ArrayList<Jugador> a, String titulo){
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+titulo+":");
        int posicion = 1;
        for(Jugador j : a){
            sb.append("\n"+posicion+"-"+j.getNombre()+":"+j.getPuntos());
            posicion++;
        }
        return sb.toString();
    }
    //End Métodos privados.
    
    //Gets:
    public ArrayList<Jugador> getJugadores() {return this.jugadores;}
    //End Gets.
    
    //Sets:
    public void setJugadores(ArrayList<Jugador> jugadores){this.jugadores = jugadores;}
    //End Sets.
    
}
