package ArrayConcept;

/*
  We have a list of integers 1-99. We need to find a missing number.
  How to find and also should calculate the time complexity. Use java program

To find the missing number in a list of integers from 1 to 99, you can use the following approach:

Calculate the expected sum of all numbers from 1 to 99 using the arithmetic sum formula: n*(n+1)/2, where n is the highest number (99 in this case).
Calculate the actual sum of the numbers in your list.
Subtract the actual sum from the expected sum. The result will be the missing number.
Here's a Java program to implement this approach:


*/

public class FindMissingNumber
{
    public static void main(String[] args)
    {
        // Create an array of integers from 1 to 99 with one missing number
        int[] numbers = new int[99];
        for (int i = 0, num = 1; i < 99; i++, num++)
        {
            // Skip the missing number (e.g., 42 in this case)
            if (num == 42)
            {
                num++;
            }
            numbers[i] = num;
        }

        // Calculate the expected sum
        int n = 99;
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum
        int actualSum = 0;
        for (int num : numbers)
        {
            actualSum += num;
        }

        // Find the missing number
        int missingNumber = expectedSum - actualSum;

        // Print the missing number
        System.out.println("The missing number is: " + missingNumber);
    }
}
