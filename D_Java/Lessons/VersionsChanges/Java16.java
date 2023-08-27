package VersionsChanges;

public class Java16 {
    
    public static void main(String[] args) {

        ///Patterns matching\\\
        Object obj = "Hello, Java 16!";
        if (obj instanceof String str && str.length() > 10) {
            System.out.println("Long string: " + str);
        }
    }

    ///Functions into others\\\
    static double calculate(double a, double b) {
        DoubleOperation sum = () -> a + b;
        DoubleOperation product = () -> a * b;
        DoubleOperation finalResult = () -> sum.calculate() + product.calculate();
        return finalResult.calculate();
    }
    interface DoubleOperation{
        public double calculate();
    }
}
