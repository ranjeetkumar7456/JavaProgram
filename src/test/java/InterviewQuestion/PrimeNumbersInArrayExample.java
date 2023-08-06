package InterviewQuestion;

public class PrimeNumbersInArrayExample
{
    public static boolean isPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] arr = {4, 7, 12, 17, 22, 29, 36, 41}; // Example array

        System.out.println("Prime numbers in the array:");
        for (int num : arr)
        {
            if (isPrime(num))
            {
                System.out.println(num);
            }
        }
    }


}
