package Intermedio.B_Modularizacion;

//Palabras que definen acceso: public >> - >> protected >> private 
//public se usa para declarar un acceso global
//no poner nada da un acceso de paquete
//protected da un acceso unico por herencia
//private da un acceso unico en objeto


//La clase coche define un objeto coche el cual se inicializara en main
public class Coche {
    
    //Los atributos de un objeto por seguridad son privados
    //Atributos:
    private static final int nRuedas = 4;
    private double velocidad;
    private String color, marca;
    private String estado = "PARADO";

    //Crea el espacio en memoria e inicializa el objeto.
    //Constructor:
    public Coche(double velocidad, String color, String marca) {
        //this hace referencia al propio objeto. Y el punto accede a sus atributos y metodos.
        this.velocidad = velocidad;
        this.color = color;
        this.marca = marca;
    }

    //Metodos publicos:
    public void mostrarDatos(){
        System.out.println("Tu coche tiene una velocidad punta de "+getVelocidad()+"km/h\n"+"Su color es "+getColor()+", y su marca "+getMarca()+".");
    }
    public void arrancar(){
        if(estado.equals("PARADO")){
            printMoviendo();
            this.estado = "MOVIENDOSE";
        }else{
            printYaEstaMoviendo();
        }
    }
    public void parar(){
        if(estado.equals("PARADO")){
            printYaEstaParado();
        }else{
            printParando();
            this.estado = "PARADO";
        }
    }

    //Metodos privados:
    private void printMoviendo(){
        System.out.println("Moviendose");
    }
    private void printYaEstaMoviendo(){
        System.out.println("Ya esta moviendose");
    }
    private void printYaEstaParado(){
        System.out.println("Ya esta parado");
    }
    private void printParando(){
        System.out.println("Parando");
    }

    //Getters:
    public static int getNRuedas(){return nRuedas;}
    public double getVelocidad(){return velocidad;}
    public String getColor(){return color;}
    public String getMarca(){return marca;}
    public String getEstado(){return estado;}
    
    //Setters:
    public void setVelocidad(double velocidad){this.velocidad = velocidad;}
}
