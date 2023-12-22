package Kata;

public class Kata {
    public static int findShort(String s) {
        int shortTemp = 0;
        String[] words = s.split(" ");
        for(String word : words)
            if(word.length() < shortTemp || shortTemp == 0) 
                shortTemp = word.length();
        return shortTemp;   
    }
}
