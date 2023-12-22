package Intermedio.C_HerenciaYPolimorfismo;

public class Golondrina extends Pajaro implements Printable{
    
    public Golondrina() {
        super(50.50, 0.5, false);
    }

    @Override
    public void print(){
        System.out.println("Soy una golondrina");
    }
}
