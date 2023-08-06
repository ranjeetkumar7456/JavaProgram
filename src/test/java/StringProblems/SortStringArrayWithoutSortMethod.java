package StringProblems;

import java.util.Arrays;

public class SortStringArrayWithoutSortMethod {

    public static void bubbleSort_String(String[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                {
                    // Swap elements if they are in the wrong order
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int i =0;i<arr.length;i++)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
        for (String data : arr)
        {
            System.out.println(data + " ");
        }
    }

    public static void bubbleSort_Integer(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Swap elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i =0;i<arr.length;i++)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
        for (Integer data : arr)
        {
            System.out.print(data + " ");
        }
    }
    public static void main(String[] args)
    {
        String[] strPlaces = {"banana", "apple", "orange", "grape", "pineapple"};
        int[] intArray = {7, 3, 9, 5, 1};

        bubbleSort_String(strPlaces);
        bubbleSort_Integer(intArray);
    }
}