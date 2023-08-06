package InterviewQuestion;

public class FibonacciSeriesExample
{
    public static int fibonacci(int n)
    {
        if (n <= 1)
        {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void generateFibonacciSeries(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        int nextNumber;

        for (int i = 0; i < n; i++) {
            if (i <= 1)
            {
                nextNumber = i; // The first two numbers are 0 and 1
            }
            else
            {
                nextNumber = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = nextNumber;
            }
            System.out.print(nextNumber + " ");
        }
    }

    public static void main(String[] args)
    {
        int count = 10; // Number of terms to generate

        /*System.out.println("Fibonacci Series:");
        for (int i = 0; i < count; i++)
        {
            System.out.print(fibonacci(i) + " ");
        }*/

        generateFibonacciSeries(10);
    }


}
