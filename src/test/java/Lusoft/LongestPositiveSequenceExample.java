package Lusoft;

import java.util.Arrays;


public class LongestPositiveSequenceExample
{
    /*Program to print longest positive number from input 1,2,3,-3,5,6,7,8,9,-1,2,3. The output will be 5,6,7,8,9.*/

    public static void LongestPositiveSequence(int[] numbers)
    {
        int currentLength = 0;
        int maxLength = 0;
        int startIndex = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] > 0)
            {
                currentLength++;
                if (currentLength > maxLength)
                {
                    maxLength = currentLength;
                    startIndex = i - maxLength + 1;
                }
            }
            else
            {
                currentLength = 0;
            }
        }

        int[] longestSequence = Arrays.copyOfRange(numbers, startIndex, startIndex + maxLength);
        System.out.println("Longest positive sequence: " + Arrays.toString(longestSequence));
    }

    public static void main(String[] args)
    {
        int[] numbers = {1,2,3,-3,5,6,7,8,9,-1,2,3};
        LongestPositiveSequence(numbers);
    }

}