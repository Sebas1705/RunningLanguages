package ConvertStringToCamelCase;

public class Solution{
    public static String toCamelCase(String s){
        String[] words = s.split("[-_]");
        String result = "";
        boolean first = true;
        for(String w : words){
            char[] array = w.toCharArray();
            if(!first) array[0] = Character.toUpperCase(array[0]);
            first = false;
            for(char c : array) result += c;
        }
        return result;
    }
}
