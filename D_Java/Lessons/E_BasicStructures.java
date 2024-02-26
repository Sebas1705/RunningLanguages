
public class E_BasicStructures {
    
    public static void main(String[] args) {
        
        //if:
        System.out.println("---------If-----------\n");
        int a=3;
        if(a==2){
            System.out.println("Twice\n");
        }else if(a==1){
            System.out.println("Once\n");
        }else{
            System.out.println("a is "+a+"\n");
        }

        //Switch:
        System.out.println("-------SWITCH--------\n");
        switch(a){
            case 1:
                System.out.println("a is 1\n");
                break;//Break out actual struct.
            case 2:
                System.out.println("a is 2\n");
                break;
            default:
                System.out.println("a is "+a+"\n");
                break;
        }

        //While:
        System.out.println("--------WHILE---------\n");
        while(a<6){
            a++;
            if(a==5)continue; //Jump to next repetition of loop
            System.out.println(a+"\n");
        }

        //Do_While:
        System.out.println("-------DO_WHILE--------\n");
        do{
            a++;
            if(a==9)continue;
            if(a==13)break;
            System.out.println(a+"\n");
        }while(a<=14);

        //For:
        System.out.println("---------FOR----------\n");
        for(int i=0;i<3;i++){
            System.out.println(a+"\n");
        }

        //Foreach:
        System.out.println("-------FOR-EACH-------\n");
        String[] strs={"hi","hello","mmm"};
        for(String i : strs){
            i+="hshsh";
            System.out.println(i);
        }    
    }
}
