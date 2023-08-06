package ArrayConcept;

import java.util.Scanner;

public class LongestPositiveSequenceInArrayExample
{
    public static void LongestPositiveSequenceInArray(int[] arr)
    {
        int maxLength = 0;
        int currentLength = 0;
        int startIndex = -1;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 0)
            {
                currentLength++;
                if (currentLength > maxLength)
                {
                    maxLength = currentLength;
                    startIndex = i - currentLength + 1;
                }
            }
            else
            {
                currentLength = 0;
            }
        }

        if (startIndex != -1)
        {
            System.out.print("Longest positive sequence: ");
            for (int i = startIndex; i < startIndex + maxLength; i++)
            {
                System.out.print(arr[i]);
                if (i < startIndex + maxLength - 1)
                {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        else
        {
            System.out.println("No positive sequence found.");
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, -3, 5, 6, 7, 8, 9, -1, 2, 34,5,6,7,5};
        int[] arr1 = {1,2,3,-3,5,6,7,8,9,-1,2,3};
        LongestPositiveSequenceInArray(arr1);

    }

    //1,2,3,-3,5,6,7,8,9,-1,2,3
}
