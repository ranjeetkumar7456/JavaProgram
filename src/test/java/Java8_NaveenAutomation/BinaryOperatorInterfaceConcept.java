package Java8_NaveenAutomation;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorInterfaceConcept {

    /*All Superinterfaces:
    BiFunction<T,T,T>
    Functional Interface:
    This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.

    @FunctionalInterface
    public interface BinaryOperator<T>
            extends BiFunction<T,T,T>
  Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
  This is a specialization of BiFunction for the case where the operands and the result are all of the same type.

  This is a functional interface whose functional method is BiFunction.apply(Object, Object).*/


    public static void main(String[] args) {

        // BinaryOperator example

        BinaryOperator<Integer> func =(x1,x2)->x1+x2;
        int i = func.apply(20,20);
        System.out.println(i);

        // BiFunction Operator example

        BiFunction<Integer,Integer,Integer> func1 = (x1,x2) -> x1-x2;

        int j = func1.apply(30,20);
        System.out.println(j);


    }





}
