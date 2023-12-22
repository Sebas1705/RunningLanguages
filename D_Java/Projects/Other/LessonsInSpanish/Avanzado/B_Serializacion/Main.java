package Avanzado.B_Serializacion;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "Avanzado/B_Serializacion/datos.data";
            Almacen_Casas ac = new Almacen_Casas(10);

            //Guardar:
            // ac.añadirCasa(new Casa(200.20, 3));
            // ac.añadirCasa(new Casa(400.20, 2));
            // ac.añadirCasa(new Casa(500.20, 1));
            // ac.añadirCasa(new Casa(600.20, 5));
            // ac.añadirCasa(new Casa(2100.20, 3));
            // ac.añadirCasa(new Casa(500.20, 4));
            // ac.añadirCasa(new Casa(2100.20, 10));
            // ac.añadirCasa(new Casa(100.20, 2));
            // ac.añadirCasa(new Casa(50.20, 2));
            // ac.añadirCasa(new Casa(20.20, 1));
            // System.out.println(ac.toString());
            // ac.guardar(path);

            //Cargar:
            ac.cargar(path);
            System.out.println(ac.toString());
            System.out.println("SerialVersionUID: "+ac.getSerial());
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
