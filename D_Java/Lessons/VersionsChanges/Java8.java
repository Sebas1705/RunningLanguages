package VersionsChanges;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8 {
    

    public static void main(String[] args) {
        
        //Lambdas:
        List<String> names = Arrays.asList("Juan", "Maria", "Carlos");
        
        //before:
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        //after:
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2)); //Anonymous implementation for interfaces

        //Functional interfaces:

        // Consumer<String> c=(s)->System.out.println(s);  // T -> void
        // Predicate<Integer> p=(i)->i<0;                  // T -> boolean
        // Supplier<Double> d=()->Math.PI*100;             // void -> T  
        // UnaryOperator<Integer> u=(i)->i*12121;          // T -> T
        // BinaryOperator<String> b=(s1,s2)->s1.concat(s2);// String,String -> String
        // MyFunctional m=(i)->String.valueOf(i);

        //Streams:
        /*
         * Inter operations:
         * filter(Predicate<T> predicate)
         * map(Function<T, R> mapper): Transform all element as mapper says
         * flatMap(Function<T, Stream<R>> mapper): Transform elements into a stream and then transform in a unique stream
         * distinct(): Eliminate duplicates
         * sorted()
         * limit(long maxSize): Limit to maxSize elements
         * skip(long n): skip first n elements
         * 
         * Final operations:
         * forEach(Consumer<T> action): Do an action for each element
         * collect(Collector<T, A, R> collector): collect a stream in a collection
         * count(): number of elements
         * anyMatch(Predicate<T> predicate): Verify if someone matches the predicate
         * allMatch(Predicate<T> predicate): Verify if all match the predicate
         * noneMatch(Predicate<T> predicate): Verify if none match the predicate
         * findFirst(): first element
         * findAny(): anyone element
         */

        List<String> names2 = Arrays.asList("Juan", "Maria", "Carlos", "Ana", "Luis");

        List<String> namesFiltered = names2.stream()
            .filter(name -> name.length() > 4)
            .map(name -> name.toUpperCase())
            .collect(Collectors.toList());

        System.out.println(namesFiltered);


        //Reference methods:
        List<String> words = new ArrayList<String>(Arrays.asList("apple","banana","cherry"));

        //Static methods:
        words.forEach(System.out::println); // words.forEach(s -> System.out.println(s));

        // instance's methods:
        String example = "Hello, world!";
        words.add("example");
        words.forEach(example::startsWith); // words.forEach(s -> example.startsWith(s));

        // Reference implementation
        words.sort(String::compareToIgnoreCase);

        // Reference construction
        List<Integer> lengths = words.stream().map(StringUtil::stringLength).collect(Collectors.toList());

    }

    @FunctionalInterface
    static interface MyFunctional{
        public String execute(int a);
    }

    //Default Functions:
    static interface Example{
        public String run();
        public default void print(){
            System.out.println("SSSSSSSSSSSS");
        } 
    }

    static class StringUtil{
        public static int stringLength(String s){return s.length();}
    }
}
