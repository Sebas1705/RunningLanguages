package Básicos;

public class N_Switch {
    public static void main(String[] args) {
        
        byte menu = 1;

        switch(menu){
            case 0:
            System.out.println("Menu0");
            break;
            case 1:
            System.out.println("Menu1");
            break;
            default:
            System.out.println("NoMenu");
        }
    }
}
