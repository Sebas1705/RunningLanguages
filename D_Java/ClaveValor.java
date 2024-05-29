
public class ClaveValor <KT,CT extends ArrayClass<? extends Number>> {

    public KT clave;
    public CT valor;

    public ClaveValor(KT clave, CT valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public static void main(String[] args) {
        ClaveValor<String,ArrayClass<Double>> claveValor;
    }
}