package Básicos;

public class O_ForEach {
    public static void main(String[] args) {
        String frase = "Hola Mundo";

        for(char c: frase.toCharArray()){
            System.out.print("-"+c);
        }
    }
}
