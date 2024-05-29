
public class G_Exceptions {

    //Personal exception
    static class DivisionException extends Exception {
        public DivisionException(String message){super(message);}
        public DivisionException(){super();}
    }

    static class NonNegativeNumbersException extends Exception {
        public NonNegativeNumbersException(String message){super(message);}
        public NonNegativeNumbersException(){super();}
    }

    public static void main(String[] args) {
        int x=9;
        int y=0;
        try{
            System.out.println(div(x,y));
        }catch(DivisionException e){
            System.out.println(e.getMessage());
            System.out.println(div(x,y+1));
        }
       


        // try{
        //     System.out.println("Div(3,0): "+div(3,0));
        // } catch (DivisionException e) {
        //     System.out.println(e.getMessage());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally{
        //     System.out.println("Always executed");
        // }

        // int a = 2;
        // int b = -1;
        // boolean ejecutado=false;
        // do{
        //     try{
        //         System.out.println(sum_non_negative_numbers(a,b));
        //         ejecutado=true;
        //     }catch(NonNegativeNumbersException e){
        //         System.out.println(e.getMessage());
        //         a = Math.abs(a);
        //         b = Math.abs(b);
        //     }catch(Exception e){
        //         e.printStackTrace();
        //     }
        // }while(!ejecutado);
    }

    public static double div(double x, double y) throws DivisionException{
        if(y==0) throw new DivisionException();
        else return x/y;
    }

    public static int sum_non_negative_numbers(int a,int b) throws NonNegativeNumbersException{
        if(a<0||b<0) throw new NonNegativeNumbersException("Not valid negative number as arguments\n");
        return a+b;

        
    }
}
