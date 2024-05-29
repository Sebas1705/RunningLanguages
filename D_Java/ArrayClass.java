
public class ArrayClass <Type> {

    public Type[] array;

    public ArrayClass(Type... elements) {
        array = elements;
    }

    public Type get(int index){
        return array[index];
    }

    public void print(){
        for(Type e : array){
            System.out.println(e);
        }
    }

    public void insertLast(Type[] elements){
        Type[] piv = array;
        array = (Type[]) new Object[piv.length+elements.length];
        System.arraycopy(piv, 0, array, 0, piv.length);
        System.arraycopy(elements, 0, array, piv.length, elements.length);
    }

    public void insertLastWithPoint(Type... elements){
        Type[] piv = array;
        array = (Type[]) new Object[piv.length+elements.length];
        System.arraycopy(piv, 0, array, 0, piv.length);
        System.arraycopy(elements, 0, array, piv.length, elements.length);
    }

    static class Trabajador{
        public int id;
        public String nombre;
        public Trabajador(int id, String nombre){
            this.id = id;
            this.nombre = nombre;
        }
        @Override
        public String toString() {
            return "Trabajador{" + "id=" + id + ", nombre=" + nombre + '}';
        }
        public void imprimirComoTrabajador(){
            System.out.println(nombre+"("+id+")");
        }
    }

    static class ArrayDeTrabajadores extends ArrayClass<Trabajador>{
        public ArrayDeTrabajadores(Trabajador... trabajadores){
            super(trabajadores);
        }
        @Override
        public void print(){
            for(Trabajador t : array) t.imprimirComoTrabajador();
        }
    }



    public static void main(String[] args) {
        /*ArrayClass<Boolean> lista = new ArrayClass<>(true,false,false,true,false);
        lista.print();
        System.out.println("-------------------------------------------");
        lista.insertLastWithPoint(true,true,true,true,true,true,true,true,true);
        lista.print();
        System.out.println("-------------------------------------------");
        lista.insertLast(new Boolean[]{false,true,true,true,true,true,true,true,false});
        lista.print();

        */ArrayClass<String> listaDeNombres = new ArrayClass<>("true","hola");
        listaDeNombres.print();
        listaDeNombres.insertLastWithPoint("Hola","Adios");
        listaDeNombres.print();

        ArrayDeTrabajadores lista = new ArrayDeTrabajadores(new Trabajador(18,"Pedro"),new Trabajador(19,"Mario"));
        lista.print();
    }
}