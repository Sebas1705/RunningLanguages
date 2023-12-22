package Intermedio.B_Modularizacion;

public class ExpositorCoche {
    
    Coche coche;

    public ExpositorCoche(Coche coche){
        this.coche = coche;
    }

    public void mostrarCoche() {
        if(coche!=null)
            coche.mostrarDatos();
        else 
            System.out.println("Coche vacio");
    }

    public void pruebaCoche() {
        coche.arrancar();
        coche.arrancar();
        coche.parar();
        coche.parar();
    }
}
