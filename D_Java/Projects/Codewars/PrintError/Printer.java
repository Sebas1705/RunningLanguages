package PrintError;

public class Printer {
    public static String printerError(String s) {
        int count = 0, max = s.length();
        for(char c : s.toCharArray()) if(c>109||c<97) count++;
        return count+"/"+max;
    }
}
