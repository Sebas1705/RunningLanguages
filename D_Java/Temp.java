
public class Temp {
    
    public static void main(String[] args) {
        int[] e = {1,2,3,2,2,3};

        //Para modificar
        for(int i=0;i<e.length;i++){
            e[i]*=2;
        }

        //Para usar valores
        for(int i: e) {
            System.out.println(i);
        }

        int a = 3;

        if(a<10) System.out.println("Menor");
        else System.out.println("Mayor");
        
        System.out.println((a<10)?"Menor":"Mayor");

        if(a<10){
            System.out.println("Menor");
        }else if(a>10){
            System.out.println("Mayor");
        }else{
            System.out.println("Igual");
        }

        System.out.println((a<10)?"Menor":((a>10)?"Mayor":"Igual"));

    }

}
