package RgbToHex;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        return numToHex(r)+numToHex(g)+numToHex(b);
    }
    public static String numToHex(int number){
        // assert: 0<=number<=255
        if(number<0) return "00";
        else if(number>255) return "FF";
        int mod=number%16;
        number/=16;
        return ((number<10)?""+number:""+((char)(number+55)))+((mod<10)?""+mod:""+((char)(mod+55)));
    }
}
