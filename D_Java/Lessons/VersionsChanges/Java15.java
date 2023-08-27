package VersionsChanges;

import java.util.regex.Pattern;

public class Java15 {
    
    public static void main(String[] args) {
        
        ///Regex patterns\\\
        Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
        boolean matches = pattern.matcher("123-45-6789").matches();
        System.out.println("Matches: "+matches);

        ///Pattern register\\\
        Object obj = new Circle(5,6);
        if (obj instanceof Circle c) {
            System.out.println(c.toString());
        }
    }

    ///Sealed classes\\\
    static sealed class Shape permits Circle{
        protected int x, y;

        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static final class Circle extends Shape {
        public Circle(int x, int y) {
            super(x, y);
        }
    }
    

}
