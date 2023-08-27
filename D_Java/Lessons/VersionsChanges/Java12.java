package VersionsChanges;

public class Java12 {
 
    public static void main(String[] args) {
        
        ///Switch relational\\\:
        String str="Monday";

        //Return switch:
        System.out.println(switch (str) {
            case "Monday","Tuesday","Wednesday" -> "Beginning of week";
            case "Thursday" -> "Just nothing";
            case "Friday","Sunday","Saturday" -> "Weekend!!!!";
            default -> "Error";
        });

        //Functional switch:
        switch (str){
            case "Monday" -> System.out.println("Hola");
            default -> System.out.println("Nothing");
        }


        
    }
}
