package Sorting;

import java.util.Arrays;

public class BubbleSortOptimize
{
    public static void bubbleSort(int array[])              // perform the bubble sort
    {
        int size = array.length;
        for (int i = 0; i < (size-1); i++)                 // loop to access each array element
        {
            boolean swapped = false;                       // check if swapping occurs
            for (int j = 0; j < (size-i-1); j++)           // loop to compare adjacent elements
            {
                if (array[j] > array[j + 1])               // compare two array elements. // change > to < to sort in descending order
                {
                    int temp = array[j];                   // swapping occurs if elements // are not in the intended order
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)                                   // no swapping means the array is already sorted // so no need for further comparison
            {
                break;
            }
        }
    }
    public static void main(String args[])
    {
        int[] data = { -2, 45, 0, 11, -9 };
        // call method using the class name
        BubbleSortOptimize.bubbleSort(data);

        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}
