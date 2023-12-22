package Intermedio.C_HerenciaYPolimorfismo;

public class Halcon extends Pajaro implements Printable{
    
    public Halcon() {
        super(100.50, 1, true);
    }

    @Override
    public void print(){
        System.out.println("Soy un halcon");
    }
}
