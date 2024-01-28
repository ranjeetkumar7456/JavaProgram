package AmazonProgram;

import java.util.HashMap;

public class SubarraySumToZero
{
    public static int[] findSubarraySumToZero(int[] arr)
    {
        // Create a HashMap to store the cumulative sum and its corresponding index.
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        int sum = 0;                                         // Initialize the cumulative sum to zero.

        // Iterate through the array.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];                                     // Add the current element to the cumulative sum.

            // Check if the current element is zero, or if the cumulative sum is zero, or if it exists in the sumMap.
            if (arr[i] == 0 || sum == 0 || sumMap.containsKey(sum))
            {
                int startIndex = (sum == 0) ? 0 : sumMap.get(sum) + 1;
                int endIndex = i;

                // Create a result array and copy the subarray elements to it.
                int[] result = new int[endIndex - startIndex + 1];
                System.arraycopy(arr, startIndex, result, 0, endIndex - startIndex + 1);

                return result;                                                     // Return the subarray with a sum of zero.
            }

            sumMap.put(sum, i); // Store the cumulative sum and its index in the map.
        }

        return new int[0]; // If no subarray is found, return an empty array.
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        int[] subarray = findSubarraySumToZero(arr);

        // Check if a subarray is found and print the result accordingly.
        if (subarray.length > 0)
        {
            System.out.println("Subarray with sum zero found:");
            for (int element : subarray)
            {
                System.out.print(element + " ");
            }
        }
        else
        {
            System.out.println("No subarray with sum zero found.");
        }
    }
}
