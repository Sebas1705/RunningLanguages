
// Clase -> Plantilla
// Clase principal del archivo solo puede tener public o nada
public class Persona implements Printable{

    // nombre : Pepe
    // edad: 19
    // ...
    //Alias de privacidad: public, - , protected, private

    //Atributos:
    protected int id;
    private String nombre;
    private int edad;

    //Constructor:
    public Persona(String nombre,int edad){
        id = 100201;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona(){ //Constructor por defecto o vacio
        this("NombrePorDefecto",-1);
        id = 1;
    }
    

    //Getters:
    public String getNombre(){return nombre;}
    public int getEdad(){return edad;}

    //Setters:
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    //Metodos:
    public void correr(){
        sayMyName();
        System.out.println(": Empieza a correr...");
    }
    public void andar(){
        sayMyName();
        System.out.println(": Empieza a andar...");
    }

    private void sayMyName(){
        System.out.print(nombre);
    }

    @Override
    public void printInConsole(){
        System.out.print(transformToString());
    }
    @Override
    public String transformToString(){
        String espacios = "";
        for(int i=0; i<n_espacios; i++) espacios +=" ";
        return espacios+id+": "+nombre+" "+edad+"\n";
    }
}
