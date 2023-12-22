/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partidas;

import Almacenes.Almacen_Palabras;
import Exceptions.EPalabraNoValidaException;
import Exceptions.EPartidaNoValidaException;
import Exceptions.ERoscoNoValidoException;
import Interfaz.PanellJugarPartida;
import Jugadores.Jugador;
import Palabras.Palabra;
import static Partidas.Rosco.ABECEDARIO;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.swing.JDialog;

public class Partida implements Serializable {

    //Constantes:
    public static final int PRECIO_ESTANDAR = 5;
    public static final String INSTRUCIONES = "Bienvenidos a partida!\nCada uno de los jugadores puede dar dos vueltas al rosco para resolver todas las letras. \n"
            + "Los jugadores disponen de un turno, que mantendrán mientras acierten. Si fallan, o “pasan \n"
            + "palabra”, el turno pasa al otro jugador. Sin embargo, en la segunda vuelta no podrán “pasar \n"
            + "palabra”, tendrán que contestar o acumularán un error. En la segunda vuelta, además, no \n"
            + "se cede el turno.\n"
            + "En el rosco, el color verde significa palabra acertada; el color rojo, palabra fallada;"
            + "el color azul, palabra actual; y el color negro, palabra aplazada o no contestada";
    //End Constantes.

    //Variables:
    private int precio;
    private int numPalabras;
    private LocalDateTime fecha;
    private Jugador jugador1;
    private Jugador jugador2;
    private Rosco rosco1;
    private Rosco rosco2;
    //End Variables.

    //Constructor:
    public Partida(int precio, int numPalabras, Jugador jugador1, Jugador jugador2, Almacen_Palabras almacen) throws EPartidaNoValidaException, ERoscoNoValidoException, EPalabraNoValidaException {
        if (precio < 0) {
            throw new EPartidaNoValidaException("La partida no puede tener un precio negativo");
        }
        if (jugador1 == null || jugador2 == null) {
            throw new EPartidaNoValidaException("La partida debe tener 2 jugadores no nulos");
        }
        this.precio = precio;
        this.numPalabras = numPalabras;
        this.fecha = LocalDateTime.now();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        Palabra[] palabrasJ1 = new Palabra[numPalabras];
        for (int i = 0; i < numPalabras; i++) {
            Palabra palabraActual = almacen.getPalabra(ABECEDARIO[i]);
            //No podemos crear un rosco con alguna palabra a null
            if (palabraActual == null || almacen.localizarLetra(String.valueOf(ABECEDARIO[i])).size() < 2) {
                throw new ERoscoNoValidoException("El almacen proporcionado no contiene las suficientes palabras. Fallo producido en las palabras que comienzan con: " + ABECEDARIO[i]);
            }
            palabrasJ1[i] = palabraActual.copiar();
        }
        this.rosco1 = new Rosco(numPalabras, palabrasJ1);
        Palabra[] palabrasJ2 = new Palabra[numPalabras];
        for (int i = 0; i < numPalabras; i++) {
            Palabra palabraActual = almacen.getPalabra(ABECEDARIO[i]);
            //No podemos crear un rosco con alguna palabra a null
            if (palabraActual == null || almacen.localizarLetra(String.valueOf(ABECEDARIO[i])).size() < 2) {
                throw new ERoscoNoValidoException("El almacen proporcionado no contiene las suficientes palabras. Fallo producido en las palabras que comienzan con: " + ABECEDARIO[i]);
            }
            while (palabrasJ1[i].equals(palabraActual)) {
                palabraActual = almacen.getPalabra(ABECEDARIO[i]);
            }
            palabrasJ2[i] = palabraActual.copiar();
        }
        this.rosco2 = new Rosco(numPalabras, palabrasJ2);
    }

    //End Constructor.
    //Métodos públicos:
    public Jugador getGanador() {
        //En caso de empate devuelve null
        if (rosco1.getNumAciertos() == rosco2.getNumAciertos()) {
            //En caso de empate miramos los puntos
            //Si tambien hay empate devolvemos null
            if (rosco1.getNumFallos() == rosco2.getNumFallos()) {
                return null;
            } else if (rosco1.getNumFallos() > rosco2.getNumFallos()) {
                return jugador1;
            } else {
                return jugador2;
            }
        } else if (rosco1.getNumAciertos() > rosco2.getNumAciertos()) {
            return jugador1;
        } else {
            return jugador2;
        }
    }

    public void jugar(JDialog padre) throws EPartidaNoValidaException {
        PanellJugarPartida panel;
        panel = new PanellJugarPartida(padre, true, this);
        panel.setTitle("Partida de " + jugador1.getNombre() + " vs " + jugador2.getNombre());
        panel.setVisible(true);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Partida otra = (Partida) o;
        return (fecha.equals(otra.fecha));
    }

    @Override
    public String toString() {
        String nombreGanador = "";
        if (this.getGanador() == null) {
            nombreGanador = "Empate";
        } else {
            nombreGanador = this.getGanador().getNombre();
        }
        return ("+--------------------------------------+\n"
                + "| Resumen partida:\n" + " | GANADOR: " + nombreGanador + " |\n"
                + "| Fecha: " + this.getFecha().toString() + " |\n"
                + "| Jugador1: " + this.getJugador1().getNombre() + " |\n"
                + "| Jugador2: " + this.getJugador2().getNombre() + " |\n"
                + "| Rosco1: " + this.getRosco1().toString() + " |\n"
                + "| Rosco2: " + this.getRosco2().toString() + " |\n"
                + "+--------------------------------------+\n"
                + "\n");
    }
    //End Métodos públicos.

    //Métodos privados:
    //End Métodos privados.
    //Gets:
    public int getPrecio() {
        return this.precio;
    }

    public int getNumPalabras() {
        return this.numPalabras;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getJugador2() {
        return this.jugador2;
    }

    public Rosco getRosco1() {
        return this.rosco1;
    }

    public Rosco getRosco2() {
        return this.rosco2;
    }

    public Partida getPartida() {
        return this;
    }
    //End Gets.

    //Sets:
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNumPalabras(int numPalabras) {
        this.numPalabras = numPalabras;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setRosco1(Rosco rosco1) {
        this.rosco1 = rosco1;
    }

    public void setRosco2(Rosco rosco2) {
        this.rosco2 = rosco2;
    }
    //End Sets.

}
