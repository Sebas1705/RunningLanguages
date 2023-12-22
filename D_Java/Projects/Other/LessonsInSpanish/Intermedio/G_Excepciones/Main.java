package Intermedio.G_Excepciones;

public class Main {
    
    public static void main(String[] args) {
        try{
            DivEntera de = new DivEntera(17, 0);
            System.out.println("Resultado: "+de.getCociente()+"\nResto: "+de.getResto());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Siempre salgo");
        }

    }
}
