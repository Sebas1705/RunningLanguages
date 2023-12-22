package Square_Every_Digit;

public class SquareDigit {
    public int squareDigits(int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : String.valueOf(n).toCharArray()) sb.append((int) Math.pow(Integer.parseInt(c+""), 2));
        return Integer.parseInt(sb.toString()); 
    }
}
