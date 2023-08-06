package Roopal;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayContains {

    public static boolean arrayContainsValueOrNot(int[] array, int value) {
        boolean status = false;

        for (int n : array)
        {
            if (n == value)
            {
                status = true;
                break;
            }
        }
        return status;
    }


    public static boolean arrayContainsValueOrNot(String[] array, String value) {
        boolean status = false;
        //String searchedValue = "Michael";

        for(String x : array){
            if(x.equals(value)){
                status = true;
                break;
            }
        }
        return status;
    }

    public static void arrayContainsValueOrNotupdated(String[] array, String value) {
        boolean status = false;

        for(String x : array){
            if(x.equals(value))
            {
                status = true;
                break;
            }
        }

        if(status)
        {
            System.out.println(value+ " found in the array");
        }
        else
        {
            System.out.println(value+ " not found in the array");
        }

    }

    public static void arrayContainsValueOrNot_UsingStream(int[] array, int value) {
        boolean found = IntStream.of(array).anyMatch(n -> n == value);

        if(found)
        {
            System.out.println(value + " is found.");
        }
        else
        {
            System.out.println(value + " is not found.");
        }
    }

    public static void arrayContainsValueOrNot_UsingStream_String(String[] array, String value)
    {
        boolean found = Arrays.stream(array).anyMatch(t -> t.equals(value));

        if(found)
        {
            System.out.println(value + " is found.");
        }

        else
        {
            System.out.println(value + " is not found.");
        }
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int value = 3;

        String[] array1 = {"One","Two","Three","Four","Five"};
        String value1= "Four";

        //1.
        System.out.println("//1.............");
        if(arrayContainsValueOrNot(array,value))
        {
            System.out.println("array contains "+value);
        }
        else
        {
            System.out.println("array does not contain "+value);
        }

        //2.
        System.out.println("//2.............");
        if(arrayContainsValueOrNot(array1,value1))
        {
            System.out.println("array contains "+value);
        }
        else
        {
            System.out.println("array does not contain "+value);
        }

        // 3.
        System.out.println("//3.............");
        arrayContainsValueOrNot_UsingStream(array,value);

        //4.
        System.out.println("//4.............");
        arrayContainsValueOrNot_UsingStream_String(array1,value1);

        //5.
        System.out.println("//5.............");
        arrayContainsValueOrNotupdated(array1,value1);
    }
}
