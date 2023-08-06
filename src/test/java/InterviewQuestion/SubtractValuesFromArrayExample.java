package InterviewQuestion;

import java.util.Arrays;



// Given an array, subtract a number M from every odd index and N from every even index.
public class SubtractValuesFromArrayExample
{
    public static void subtractValues(int[] array, int M, int N)
    {
        for (int i = 0; i < array.length; i++)
        {
            if ((i + 1) % 2 == 0)
            {
                // Even index (index + 1 is divisible by 2)
                array[i] -= N;
            }
            else
            {
                // Odd index
                array[i] -= M;
            }
        }
    }
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6};
        int M = 2;
        int N = 3;

        subtractValues(array, M, N);

        System.out.println("Result: " + Arrays.toString(array));
    }
}
