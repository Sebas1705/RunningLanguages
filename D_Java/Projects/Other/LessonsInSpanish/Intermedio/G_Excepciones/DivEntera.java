package Intermedio.G_Excepciones;

public class DivEntera {
    
    private int denominador, divisor, resto, cociente;

    public DivEntera(int denominador, int divisor) throws ExceptionNotDivisibleByZero{
        if(divisor == 0) throw new ExceptionNotDivisibleByZero("No se puede dividir entre cero melón");
        this.denominador = denominador;
        this.divisor = divisor;
        this.resto = denominador%divisor;
        this.cociente = denominador/divisor;
    }

    public int getDenominador() {return denominador;}
    public int getDivisor() {return divisor;}
    public int getResto() {return resto;}
    public int getCociente() {return cociente;}
}
