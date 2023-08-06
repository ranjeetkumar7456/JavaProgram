package ArrayConcept;

import java.util.*;

public class RemoveDuplicateFromArray {

    public static void removeDuplicateUsingSortMethod(int[] arr)
    {
        Arrays.sort(arr);

        int len = arr.length;
        int j = 0;

        //Traverse an array
        for (int i = 0; i < len - 1; i++) {

            //if value present at i and i+1 index is not equal
            if (arr[i] != arr[i + 1])
            {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[len - 1];

        for (int k = 0; k < j; k++) {
            System.out.print(arr[k] + " ");
        }

    }

    public static void removeDuplicateUsingSimpleLoop(int[] arr) {
        int len = arr.length;
        int j = 0;
        int[] tempArr = new int[len];

        // Traverse the array and copy non-duplicate elements to the tempArr
        for (int i = 0; i < len; i++)
        {
            boolean isDuplicate = false;
            for (int k = 0; k < j; k++)
            {
                if (arr[i] == tempArr[k])
                {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate)
            {
                tempArr[j++] = arr[i];
            }
        }

        // Copy the non-duplicate elements from tempArr back to the original arr
        for (int i = 0; i < j; i++)
        {
            arr[i] = tempArr[i];
        }

        // Print the array after removing duplicates
        for (int k = 0; k < j; k++) {
            System.out.print(arr[k] + " ");
        }
    }



    public static void removeDuplicateUsingHashing(int arr[]) {

        //Declare a hashmap
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;

        //Traverse an array
        for (int i = 0; i < len - 1; i++) {
            //If key is already present in a map
            if (map.containsKey(arr[i])) {
                //Increment it's count
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
               /*
                If it's not present in a map
                then put a key and it's initial count 1
               */
                map.put(arr[i], 1);
            }
        }

        //Print Each Key
        map.forEach((k, v) -> System.out.print(k + " "));
    }

    public static void removeDuplicateUsingSet(int arr[]) {

        //Declare set
        Set st = new HashSet<>();
        int len = arr.length;

        //Traverse an array and add element in a set
        for (int i = 0; i < len - 1; i++) {
            //It only add unique value
            st.add(arr[i]);
        }

        //Print each element
        st.forEach(elem -> System.out.print(elem + " "));
    }

    public static int removeDuplicates(int a[], int n)
    {
        // if(array size if 0 or 1 array is already sorted)
        if (n == 0 || n == 1) {
            return n;
        }

        int j = 0;

        // check if the ith element is not equal to
        // the (i+1)th element, then add that element
        // at the jth index in the same array
        // which indicates that te particular element
        // will only be added once in the array
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }

        a[j++] = a[n - 1];

        return j;
    }

    public static void removeDuplicateFromArray(int[] arr)
    {
        int n = arr.length;
        int m = 0;

        for (int i = 0; i < n; i++) {
            m = Math.max(m, arr[i]);
        }

        // creating the frequency array
        int[] f = new int[m + 1];

        // incrementing the value at a[i]th index
        // in the frequency array
        for (int i = 0; i < n; i++)
        {
            f[arr[i]]++;
        }

        for (int i = 0; i < m + 1; i++)
        {

            // if the frequency of the particular element
            // is greater than 0, then print it once
            if (f[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void removeDuplicate_UsingLoop(int[] arr)
    {
        int index=0;
        int count;
        int[] newArray= new int[arr.length];
        System.out.println("Before removing duplicate from the array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        // removing duplicate
        for(int i=0;i<arr.length;i++)
        {
            count=0;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    count=count+1;
                    break;
                }

            }
            if(count==0)
            {
                newArray[index]=arr[i];
                index++;
            }
        }
        for(int i=0;i<index;i++)
        {
            arr[i]=newArray[i];
        }
        System.out.println();
        System.out.println("After removing duplicate from the array");
        for(int i=0;i<index;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void removeDuplicatess(int a[], int n)
    {
        int[] res = new int[n];
        int j = 0;
        Arrays.sort(a);
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                res[j++] = a[i];
            }
        }
        res[j++] = a[n - 1];
        for (int i = 0; i < j; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 4, 4, 5, 6, 8, 7};
        System.out.println("1. Using SortMethod");
        removeDuplicateUsingSortMethod(arr);
        System.out.println();
        System.out.println("2. Using HashMap");
        removeDuplicateUsingHashing(arr);
        System.out.println();
        System.out.println("3. Using HashMap");
        removeDuplicateUsingSet(arr);
        System.out.println();
        System.out.println("4. with using any method");
        int a[] = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6};

        int n = a.length;

        int j = 0;

        // the function will modify the array a[]
        // such that the starting j elements
        // will be having all unique elements
        // and no element will be appearing more than
        // once
        j = removeDuplicates(a, n);

        // printing array elements
        for (int i = 0; i < j; i++)
            System.out.print(a[i] + " ");

        System.out.println();
        System.out.println("5. without using loop");
        removeDuplicate_UsingLoop(arr);
        System.out.println();
        System.out.println("6. RemoveDuplicate");
        int a1[] = {1,2,1,2,3,4,5,6,4,4,5,5};
        int n1 = a.length;
        removeDuplicatess(a1, n1);
        System.out.println();
        System.out.println("7. RemoveDuplicate");
        removeDuplicateUsingSimpleLoop(a1);


    }

}
