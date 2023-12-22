package Intermedio.C_HerenciaYPolimorfismo;

public class Pajaro {
    
    private double velocidad;
    private double altura;
    private boolean depredadora;

    public Pajaro(double velocidad, double altura, boolean depredadora){
        this.velocidad = velocidad;
        this.altura = altura;
        this.depredadora = depredadora;
    }

    public void mostrarDatos(){
        System.out.println("Velocidad: " + velocidad+ "\nAltura: " + altura+ "\nDepredadora: " + depredadora);
    }
}
