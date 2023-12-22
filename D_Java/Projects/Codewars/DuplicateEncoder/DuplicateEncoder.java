package DuplicateEncoder;

public class DuplicateEncoder {
	
    static String encode(String word){
        int[] contChars = new int[255];
        StringBuilder sb = new StringBuilder();
        char[] caracters = word.toUpperCase().toCharArray();
        for(char c : caracters)contChars[c]++;
        for(char c : caracters){
            if(contChars[c]>=2) sb.append(")"); 
            else sb.append("(");
        }
        return sb.toString();
    }
}
