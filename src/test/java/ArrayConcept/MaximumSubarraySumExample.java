package ArrayConcept;

public class MaximumSubarraySumExample
{
    //Max Subarray sum means continous sub array whose sum is maximum
    public static int findMaximumSubarraySum(int[] array)
    {
        int maxSum = array[0];
        int currentSum = array[0];

        for (int i = 1; i < array.length; i++)
        {
            currentSum = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args)
    {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr ={34, -50, 42, 14, -5, 86};
        int maxSum = findMaximumSubarraySum(array);
        System.out.println("Maximum subarray sum: " + maxSum);
    }
}
