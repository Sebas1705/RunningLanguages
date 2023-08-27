package VersionsChanges;
public class Java10 {
    
    public static void main(String[] args) {
        
        //Var (implicit creation of a variable):
        var v = 9; //Created as an integer
        //v="Hola"; //Error for typing
        System.out.println(v);

        //Thread local (local variables for multiple threads without interferences):
        ThreadLocal<Integer> localValue=ThreadLocal.withInitial(()->10);
        System.out.println(localValue.get());

    }
}
