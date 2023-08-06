package InterviewQuestion;

public class fintAverageOfPrimeNumberExample {

    public static void findPrimeAverage(int countOfPrimeNumber)
    {
        int count = 0;
        int sum = 0;
        int number = 2; // Starting number

        while (count < countOfPrimeNumber) {
            if (isPrime(number)) {
                sum += number;
                count++;
            }
            number++;
        }
        double average = (double) sum / count;
        System.out.println("Average of the first "+ countOfPrimeNumber+" prime numbers: " + average);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
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
        findPrimeAverage(15);
    }


}
