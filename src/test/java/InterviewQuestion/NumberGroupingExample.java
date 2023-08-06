package InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class NumberGroupingExample
{
    public static void numberGrouping(int[] numbers)
    {
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        for (int number : numbers)
        {
            if (number >= 0)
            {
                positiveNumbers.add(number);
            }
            else
            {
                negativeNumbers.add(number);
            }
        }

        System.out.println("Positive numbers: " + positiveNumbers);
        System.out.println("Negative numbers: " + negativeNumbers);
    }
    public static void main(String[] args) {
        int[] numbers = {5, -3, -1, 0, 2, -4, 7, 8, -6};

        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        numberGrouping(numbers);


    }
}
