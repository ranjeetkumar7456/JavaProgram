package Roopal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargestElementInTheArray {
    public static int secondLargest(int[] input)
    {
        int firstLargest, secondLargest;

        //Checking first two elements of input array

        if(input[0] > input[1])
        {
            //If first element is greater than second element

            firstLargest = input[0];

            secondLargest = input[1];
        }
        else
        {
            //If second element is greater than first element

            firstLargest = input[1];

            secondLargest = input[0];
        }

        //Checking remaining elements of input array

        for (int i = 2; i < input.length; i++)
        {
            if(input[i] > firstLargest)
            {
                //If element at 'i' is greater than 'firstLargest'

                secondLargest = firstLargest;

                firstLargest = input[i];
            }
            else if (input[i] < firstLargest && input[i] > secondLargest)
            {
                //If element at 'i' is smaller than 'firstLargest' and greater than 'secondLargest'

                secondLargest = input[i];
            }
        }

        return secondLargest;
    }

    public static int getSecondLargest(int[] a){
        int total = a.length;
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[total-2];
    }

    public static void main(String[] args)
    {
        //System.out.println(secondLargest(new int[] {45, 51, 28, 75, 49, 42}));
        //System.out.println(getSecondLargest(new int[] {45, 51, 28, 75, 49, 42}));

        int[] array = {45, 51, 28, 75, 49, 42};
        System.out.print("Second biggest number in array is:");
        Arrays.stream(array)
                .sorted()
                .limit(array.length-1)
                .skip(array.length-2)
                .forEach(System.out::println);

    }
}
