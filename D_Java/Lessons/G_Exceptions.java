
public class G_Exceptions {

    //Personal exception
    static class DivisionException extends Exception {
        public DivisionException(String message){super(message);}
        public DivisionException(){super();}
    }

    public static void main(String[] args) {
        try{
            System.out.println("Div(3,0): "+div(3,0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Always executed");
        }
    }

    public static double div(double x, double y) throws G_Exceptions.DivisionException{
        if(y==0) throw new DivisionException("Not divisible by zero [DivisionException]");
        else return x/y;
    }
}
