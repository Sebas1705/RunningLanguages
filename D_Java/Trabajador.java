
//Herencia -> una clase recicla de otra, recicla tanto caracteristicas como forma
public class Trabajador extends Persona implements Workable {
    
    private String nombreDelTrabajo;
    
    public Trabajador(String nombre,int edad,String nombreDelTrabajo) {
        super(nombre,edad);
        this.nombreDelTrabajo=nombreDelTrabajo;
    }
    public Trabajador() {
        this("TrabajadorPorDefecto",18,"Parado");
    }
    

    public String getNombreDelTrabajo(){
        return nombreDelTrabajo;
    }

    public void trabajar(){
        System.out.println(id+": Empieza a trabajar...");
    }

    @Override
    public void workInATemporalyJob(String jobName){
        System.out.println("Trabajando: "+jobName);
    }
    @Override
    public void doABreakfast(){
        System.out.println("Merendando");
    }
}
