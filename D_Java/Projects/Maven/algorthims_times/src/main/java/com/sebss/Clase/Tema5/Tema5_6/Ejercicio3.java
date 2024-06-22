package com.sebss.Clase.Tema5.Tema5_6;

import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        GestorViajes gestor = new GestorViajes();
        long inicio = System.currentTimeMillis();
        gestor.darDeAlta(new Viaje("Barcelona","Madrid",3));
        gestor.darDeAlta(new Viaje("Barcelona","Bilbao",2));
        Viaje v = new Viaje("Madrid","Bilbao",1.5);
        gestor.darDeAlta(v);
        gestor.darDeBaja(v);
        System.out.println("\nCiudades con viajes:");
        gestor.getCiudadesConViajes().forEach(System.out::println);
        System.out.println("\nViajes con origen Barcelona:");
        gestor.getViajesConOrigen("Barcelona").forEach(System.out::println);
        System.out.println("\nViajes con destino Bilbao:");
        gestor.getViajesConDestino("Bilbao").forEach(System.out::println);
        long fin = System.currentTimeMillis();
        System.out.println("\n----------------------------------------");
        System.out.println("Tiempo de ejecución: "+(fin-inicio)+" milisegundos");
    }

    public static record Viaje(String origen,String destino,double duracionHoras){}
    public static class GestorViajes{
        
        private Set<Viaje> viajes;

        public GestorViajes(){
            viajes=new HashSet<Viaje>();
        }

        public boolean darDeAlta(Viaje v){
            return viajes.add(v);
        }    
        public boolean darDeBaja(Viaje v){
            return viajes.remove(v);
        }    
        
        public Set<Viaje> getViajesConOrigen(String origen){
            return viajes.stream().filter(viaje->viaje.origen.equals(origen)).collect(Collectors.toSet());
        }
        public Set<Viaje> getViajesConDestino(String destino){
            return viajes.stream().filter(viaje->viaje.destino.equals(destino)).collect(Collectors.toSet());
        }
        public Set<String> getCiudadesConViajes(){
            Set<String> ciudades = new HashSet<String>();
            viajes.forEach(x->{ciudades.add(x.origen);ciudades.add(x.destino);});
            return ciudades;
        }

        public Set<Viaje> getViajes(){return viajes;}
    }
}
