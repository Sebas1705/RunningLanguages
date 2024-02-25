

public class Main {
    
    public static void main(String[] args) {

        //Polimorfismo: muchas formas => un mismo objeto puede tomar tantas formas como herede
        Persona[] personas = {
            new Persona("Laro",19),
            new Trabajador("Pepe",20,"Construcción")
        };
        if(personas[1] instanceof Trabajador){
            Trabajador t = (Trabajador)personas[1];
            t.trabajar();
        }


        Printable[] ps ={
            new Persona(),
            new Trabajador(),
            new Persona(),
            new Trabajador()
        };

        for(Printable p:ps){
            if(p instanceof Trabajador){
                ((Trabajador)p).trabajar();
            }
            
            if (p instanceof Persona){
                ((Persona)p).andar();
            }
            
            if(p instanceof Workable){
                ((Workable)p).doABreakfast();
            }
            
            p.printInConsole();
        }

        // Forma f = new Forma();
        Forma p = new Cuadrado();
        System.out.println(p.perimetro());
        System.out.println(p.area());
    }
}
