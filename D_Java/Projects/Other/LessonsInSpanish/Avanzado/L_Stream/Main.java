package Avanzado.L_Stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void run(){

        //Objetos funcionales:
        //Predicate: lambda que devuelve un booleano 
        //de un solo parametro pasado al generico
        Predicate<Object> hashCodeOver100= x->x.hashCode()>=100;
        //Function: lambda que devuelve un resultado generico 
        //de un solo parametro pasado al generico
        Function<Double,Integer> doubleToInteger= x->Integer.valueOf(String.valueOf(x));

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) list.add(i);

        //Stream es un objeto que te aporta funciones para
        //tus colecciones:
        
        //1-Filter (param: predicate):
        Predicate<Integer> over90 = f->f>=90;
        list.stream()
            .filter(over90)
            .forEach(i->System.out.print("-"+i));
        System.out.println("\n");
        
        
        //2-Map (param: Function):
        Function<Integer, Integer> transform = x->x*x;
        Function<Integer, String> transform2 = x->""+x;
        List<String> listaCuadrados = list.stream()
            .map(transform)
            .map(transform2)
            .collect(Collectors.toList());
        listaCuadrados.forEach(System.out::print);
        System.out.println("\n");
        
        
        //3-Sorted (param: Comparator):
        Comparator<Integer> desc = (a,b)->b-a;
        list.stream()
            .sorted(desc)
            .forEach(System.out::print);
        System.out.println("\n");

        
        //4-Match (param: predicate):
        //anyMatch:
        boolean match1 = list.stream()
            .anyMatch(p->p>=90&&p<=99);
        System.out.println("Algun numero entre 90-99: "+match1);
        System.out.println("\n");

        //allMatch:
        boolean match2 = list.stream()
            .allMatch(p->p>1);
        System.out.println("Todos los numeros mayores que 1: "+match2);
        System.out.println("\n");

        //noneMatch:
        boolean match3 = list.stream()
            .noneMatch(p->p>99);
        System.out.println("Ningun numero mayor a 99: "+match3);
        System.out.println("\n");


        //5-Limit/Skip:
        List<Integer> filteredList = list.stream()
            .skip(2) //Se salta los n primeros
            .limit(5) //Limita a n elementos
            .collect(Collectors.toList());
        filteredList.forEach(System.out::print);
        System.out.println("\n");


        //6-Collectors:
        //GroupBy:
        Map<Integer, List<Integer>> groupMap = list.stream()
            .filter(p->p>90)
            .collect(Collectors.groupingBy(e->e%2));
        System.out.println(groupMap.entrySet());
        System.out.println("\n");

        //Counting:
        Function<Integer, Integer> odd_even = e->e%2;
        Map<Integer, Long> countMap = list.stream()
            .filter(p->p>90)
            .collect(Collectors.groupingBy(
                odd_even, Collectors.counting()
            )
        );
        System.out.println(countMap.entrySet());
        System.out.println("\n");

        //Suma:
        Map<Integer, Integer> sumMap = list.stream()
            .filter(p->p>90)
            .collect(Collectors.groupingBy(
                odd_even, Collectors.summingInt(e->e)//tambien esta avg y varios
            )
        );
        System.out.println(sumMap.entrySet());
        System.out.println("\n");

        //Resumen:
        IntSummaryStatistics summary = list.stream()
            .collect(Collectors.summarizingInt(e->e));
        System.out.println(summary);
        System.out.println("\n");

        //7-reduce (param: function):
        Optional<Integer> sol = list.stream()
            .reduce((a,b)->a+b);
        System.out.println(sol.get());
        System.out.println("\n");
    
    
        
    }

    public static void main(String[] args) {
        run();
    }
}
