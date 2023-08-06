package Java8_NaveenAutomation;

import java.util.function.Function;

public class FunctionalInterfaceConcept {

    /*
    Interface Function<T,R> Type parameter
    T  -- Type of the input
    R  -- Type of output
    */

    public static void main(String[] args) {
        Function<String,Integer> func = x -> x.length();
        int len = func.apply("This is Java 8");
        System.out.println(len);

        Function<Integer,Integer> func1 = x -> x*2;

        // Chaining function
        int result = func.andThen(func1.andThen(func1)).apply("This is Java 8");
        System.out.println(result);

    }
}
