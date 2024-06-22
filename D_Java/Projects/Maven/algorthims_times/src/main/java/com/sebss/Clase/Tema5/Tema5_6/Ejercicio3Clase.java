package com.sebss.Clase.Tema5.Tema5_6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Ejercicio3Clase {
    
    public static void main(String[] args) {
		GestorViajes gv = new GestorViajes();
        long inicio = System.currentTimeMillis();
		gv.addViaje(new Viaje("Madrid","Barcelona",4));
		gv.addViaje(new Viaje("Sevilla","Madrid",5));
		gv.addViaje(new Viaje("Toledo","Barcelona",10));
		gv.addViaje(new Viaje("Madrid","Córdoba",7));
		gv.addViaje(new Viaje("Barcelona","Burgos",9));
		System.out.println("Ciudades en las que hay viajes:");
		System.out.println(gv.getCiudades());
		System.out.println("Viajes desde Madrid:");
		System.out.println(gv.getViajesOrigen("Madrid"));
		System.out.println("Viajes hacia Barcelona:");
		System.out.println(gv.getViajesDestino("Barcelona"));		
		System.out.println("Viajes:");
		System.out.println(gv.getViajes());
        long fin = System.currentTimeMillis();
        System.out.println("\n----------------------------------------");
        System.out.println("Tiempo de ejecución: "+(fin-inicio)+" milisegundos");
    }

    public static record Viaje(String origen, String destino, float duracion){}
    public static class GestorViajes {

        private List<Viaje> viajes = new ArrayList<Viaje>();
        private Map<String, List<Viaje>> viajesPorOrigen = new HashMap<>();
        private Map<String, List<Viaje>> viajesPorDestino = new HashMap<>();
        private Set<String> ciudades = new HashSet<>();

        public void addViaje(Viaje viaje) {
            viajes.add(viaje);
            put(viajesPorOrigen, viaje.origen(), viaje);
            put(viajesPorDestino, viaje.destino(), viaje);
            ciudades.add(viaje.origen());
            ciudades.add(viaje.destino());
        }

        private void put(Map<String, List<Viaje>> ciudadesViajes, String ciudad, Viaje viaje) {

            List<Viaje> viajes = ciudadesViajes.get(ciudad);
            if (viajes == null) {
                viajes = new ArrayList<Viaje>();
                ciudadesViajes.put(ciudad, viajes);
            }
            viajes.add(viaje);
        }

        public Collection<Viaje> getViajesOrigen(String origen) {
            return viajesPorOrigen.get(origen);
        }

        public Collection<Viaje> getViajesDestino(String destino) {
            return viajesPorDestino.get(destino);
        }

        public Collection<String> getCiudades() {
            return ciudades;
        }

        public Collection<Viaje> getViajes() {
            return viajes;
        }

    }
}
