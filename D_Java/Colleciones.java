import java.util.*;

public class Colleciones {
    
    public static void main(String[] args) {
        
        List<Integer> list; //List es una interfaz [2,2,3,4,5,6]

        list = new ArrayList<>(); //lista de objetos guardados de forma consecutiva 
        // mas rapido en la creacion, pero mas lento en el acceso

        list = new LinkedList<>(); //lista de objetos guardados de forma no consecutiva
        // mas lento en la creacion, pero mas rapido en el acceso 

        list = new Vector<>(); //lista de objetos teniendo en cuenta el tamaño
        // mas rapido en tamaños grandes

        //Funciones:
        list.add(2);
        list.add(2,3);
        list.addAll(list);
        System.out.println(list);
        list.get(2);
        list.remove(2);
        list.clear();
        list.size();
        list.contains(10);
        

        //Listas personalizadas
        Stack<Integer> stack = new Stack<>(); //lista de objetos que sigue la politica LIFO 
        //LIFO last in first out: ultimo en entrar primero que sale Ej.: pila de platos
        stack.push(2);// add(0,2)
        stack.pop();       // remove(0)
        stack.peek();      // get(0)  
        stack.isEmpty();   // size()==0

        Queue<Integer> queue = new Queue<>(); //lista de objetos que sigue la politica FIFO 
        //FIFO first in first out: primero en entrar primero que sale Ej.: cola de gente
        queue.add(3); // add(queue.size(),3)
        queue.remove(); // remove(0) or Exception
        queue.poll();   // remove(0) or null
        queue.peek();   // get(0)


        Set<Integer> set; //Set es una interfaz [2,3,4,5,6] que no admite duplicados

        set = new HashSet<Integer>(); //Hash table as a set (no add order) // ventaja en velocidad de acceso
        set = new LinkedHashSet<Integer>(); //HashSet with order of addition // ventaja en espacio pero menor velocidad que hashset
        set = new TreeSet<Integer>(); //Tree (red-black) as a set with a natural ordering or with a comparator personalized // ventaja es en espacio
        
        set.add(10);
        set.remove(10);
        set.contains(10);
        set.size();
        set.clear();
    }
}
