package Intermedio.C_HerenciaYPolimorfismo;

public class Main {
    public static void main(String[] args) {
        
        Pajaro p1 = new Halcon();
        Pajaro p2 = new Golondrina();

        Pajaro[] lista = {p1, p2};
        Printable t;

        for(Pajaro p : lista) {
            p.mostrarDatos();
            if(p instanceof Halcon) t = (Halcon) p;
            else t = (Golondrina) p;
            // t = (p instanceof Halcon)?(Halcon)p:(Golondrina)p;
            t.print();
        }
    }
}
