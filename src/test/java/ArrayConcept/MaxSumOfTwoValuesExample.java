package ArrayConcept;

public class MaxSumOfTwoValuesExample
{
    public static int findMaxSumOfTwoValues(int[] array)
    {
        if (array == null || array.length < 2)
        {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                int sum = array[i] + array[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 2, 3,6,3,7,9,6,3,7,9,3,4,56,7};
        int maxSum = findMaxSumOfTwoValues(array);
        System.out.println("Maximum sum of two values: " + maxSum);
    }
}
