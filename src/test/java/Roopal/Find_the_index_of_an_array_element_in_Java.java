package Roopal;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Find_the_index_of_an_array_element_in_Java {

    // 1. Using Linear Search
    public static int findIndex_Linear_Search(int arr[], int t)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    // 2. Using Binary search

    public static int findIndex_Binary_Search(int arr[], int t)
    {

        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

    // 3. Using Guava

    public static int findIndex_Guava(int arr[], int t)
    {
        return Ints.indexOf(arr, t);
    }

    // 4. Using Stream API

    public static int findIndex_Stream_API(int arr[], int t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }

    // 5. Using ArrayList

    public static int findIndex_ArrayList(int arr[], int t)
    {
        // Creating ArrayList
        ArrayList<Integer> clist = new ArrayList<>();

        // adding elements of array
        // to ArrayList
        for (int i : arr)
            clist.add(i);

        // returning index of the element
        return clist.indexOf(t);
    }

    // 6. Using Recursion
    public static int index_Recursion(int arr[], int t, int start)
    {

        // base case when
        // start equals the length of the
        // array we return -1
        if(start==arr.length)
            return -1;

        // if element at index start equals t
        // we return start
        if(arr[start]==t)
            return start;

        // we find for the rest
        // position in the array
        return index_Recursion(arr,t,start+1);
    }

    public static void main(String[] args) {
        int[] my_array = { 4, 6, 1, 3, 2,5 , 7, 8, 9 };

        // find the index of 5

        System.out.println("// 1. Using Linear Search");
        System.out.println("Index position of 5 is: "+ findIndex_Linear_Search(my_array, 5));
        System.out.println("// 2. Using Binary search");
        System.out.println("Index position of 5 is: "+ findIndex_Binary_Search(my_array, 5));
        System.out.println("// 3. Using Guava");
        System.out.println("Index position of 5 is: "+ findIndex_Guava(my_array, 5));
        System.out.println("// 4. Using Stream API");
        System.out.println("Index position of 5 is: "+ findIndex_Stream_API(my_array, 5));
        System.out.println("// 5. Using ArrayList");
        System.out.println("Index position of 5 is: "+ findIndex_ArrayList(my_array, 5));
        System.out.println("// 6. Using Recursion");
        System.out.println("Index position of 5 is: "+ index_Recursion(my_array, 5,0));
    }
}
