

public class F_Functions {
    
    public static void main(String[] args) {
        function();
        parameter(2,4.0);
        int x = 2;
        System.out.println("Sum(2,4): "+sum(x,4));
        System.out.println("Sum(2,3,4): "+sum(2,3,4));
        System.out.println("SumPointed(1,2,3,4,5,6,7,8,9): "+sumPointed(1,2,3,4,5,6,7,8,9));

        //Reference methods: className::functionName
        System.out.println("DoOperation(1.0,4.0,reference): "+doOperation(1.0,4.0,F_Functions::sub));

        //Lambda for parameters:
        System.out.println("DoOperation(1.0,4.0,lambda): "+doOperation(1.0,4.0,(a,b)->a-b));
    }

    //Function void
    public static void function(){
        System.out.println("Something to do");
    }

    //Parameter function
    public static void parameter(int i,double b){
        System.out.println(i+" "+b);
    }
    
    //Return function
    public static int sum(int a1,int a2){return a1+a2;}
    public static double sub(double a,double b){return a-b;}

    //Overload function
    public static int sum(int a1,int a2,int a3){return a1+a2+a3;}

    //Pointed params
    public static int sumPointed(int a1,int...aN){
        int total=a1;
        for(int i:aN) total+=i;
        return total;
    }

    //Functional interface for parameters as methods
    public interface Operation{
        double function(double a1,double a2);
    }

    public static double doOperation(double a1,double a2,Operation operation){
        return operation.function(a1,a2);
    }

    //Trinary operations:
    public static String isGreaterThan(int a1,int a2){
        return a1 > a2 ? "Yes it is" : "No it isn't";
    }

}
