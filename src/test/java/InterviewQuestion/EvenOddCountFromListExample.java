package InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class EvenOddCountFromListExample {
    public static void countEvenOdd(List<Integer> numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int number : numbers)
        {
            if (number % 2 == 0)
            {
                evenCount++;
            }
            else
            {
                oddCount++;
            }
        }

        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
    }

    public static void countEvenOdd1(List<Integer> numbers)
    {
        int evenCount = 0;
        int oddCount = 0;

        for (int i=0;i< numbers.size();i++)
        {
            if (numbers.get(i) % 2 == 0)
            {
                evenCount++;
            }
            else
            {
                oddCount++;
            }
        }

        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        countEvenOdd1(numbers);
    }
}
