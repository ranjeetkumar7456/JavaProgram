package InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersExample {
    public static List<Integer> findPrimeNumbers(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (isPrime(number))
            {
                primeNumbers.add(number);
            }
        }

        return primeNumbers;
    }

    public static boolean isPrime(int number)
    {
        boolean status = true;
        if (number <= 1)
        {
            status =false;
            return status;
        }

        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                status =false;
                return status;
            }
        }

        return status;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(15);
        numbers.add(23);
        numbers.add(10);
        numbers.add(31);

        List<Integer> primeNumbers = findPrimeNumbers(numbers);

        System.out.println("Prime numbers: " + primeNumbers);
    }
}
