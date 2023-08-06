package InterviewQuestion;

public class findFactorial
{
    public static long findFactorial(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * findFactorial(n - 1);
        }
    }

    public static void main(String[] args)
    {
        int number = 5; // Replace 5 with any other positive integer to find its factorial
        long factorial = findFactorial(number);
        System.out.println("The factorial of " + number + " is: " + factorial);
    }
}
