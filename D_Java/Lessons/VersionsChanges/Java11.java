package VersionsChanges;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java11 {
    
    public static void main(String[] args) {
        
        //Var in lambdas:
        Arrays.asList("Hello","Goodbye","World").forEach((var a)->System.out.println(a));

        //New in java.concurrent:
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        future.thenAccept(result -> System.out.println("Result: " + result));

        //New methods for stream:
        List takeWhileResult = Stream.of(1, 2, 3, 4, 5).takeWhile(value -> value < 3).collect(Collectors.toList());
        System.out.println(takeWhileResult);
        
        List dropWhileResult = Stream.of(1, 2, 3, 4, 5).dropWhile(value -> value < 3).collect(Collectors.toList());
        System.out.println(dropWhileResult);
        
        List iterateResult = Stream.iterate(1L, n  ->  n  + 1).limit(10).collect(Collectors.toList());
        System.out.println(iterateResult);
        
        String example = "example";
        List ofNullableResult = Stream.ofNullable(example).collect(Collectors.toList());
        System.out.println(ofNullableResult);
        
        String nullExample = null;
        List ofNullableNullResult = Stream.ofNullable(nullExample).collect(Collectors.toList());
        System.out.println(ofNullableNullResult);
    }
}
