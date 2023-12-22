package DigitalRoot;

public class DigitalRoot {
    public static int digital_root(int n){
        boolean out = false;
        int temp = n;
        String s;
        while(!out){
            s = String.valueOf(temp);
            temp = 0;
            for(char c : s.toCharArray()){
                temp+=Integer.valueOf(c);
            }
            out = temp<10;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(digital_root(12));
    }
}
