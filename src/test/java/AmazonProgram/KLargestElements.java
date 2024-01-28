package AmazonProgram;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
Given an array of integers ‘arr’ of size n, which is analogous to a continuous stream of integers input,
find K largest elements from a given stream of numbers. Use java program
*/

public class KLargestElements
{
    public static void findKLargest(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);        // Min-Heap to maintain the K largest elements

        for (int num : arr)
        {
            if (minHeap.size() < k)
            {
                minHeap.offer(num); // Add the first K elements to the min-heap
            }
            else if (num > minHeap.peek())
            {
                minHeap.poll(); // Remove the smallest element from the min-heap
                minHeap.offer(num); // Add the new element if it's larger
            }

            System.out.print("K Largest Elements: ");
            for (int element : minHeap)
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] findKLargest(int[] arr, int n, int k)
    {
        int[] kLargest = new int[k];

        if (k > n)
        {
            return kLargest;  // Return an empty array if k is greater than n
        }

        for (int i = 0; i < k; i++)
        {
            kLargest[i] = arr[i];
        }

        Arrays.sort(kLargest);

        for (int i = k; i < n; i++)
        {
            if (arr[i] > kLargest[0])
            {
                kLargest[0] = arr[i];
                Arrays.sort(kLargest);
            }
        }

        return kLargest;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 7, 11, 5, 27, 14, 8};
        int k = 3; // Find the 3 largest elements

        findKLargest(arr, k);

        System.out.println("========================");
        int[] kLargest = findKLargest(arr, arr.length, k);

        System.out.print("K Largest Elements: ");
        for (int element : kLargest)
        {
            System.out.print(element + " ");
        }
    }
}
