package Básicos;

public class G_Conversores {
    public static void main(String[] args) {
        
        byte a;
        long l = Math.round(2.13223);

        //Esto no se puede ya que l es un long.
        // a = l; 

        a = (byte) l; //Para solucionarlo solo hay que hacer uso del conversor de la forma "(tipo)"

        float b = (float) 2.3;

        System.out.println(a);
    }
}
