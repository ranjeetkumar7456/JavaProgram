package HackerEarth;

import java.util.Scanner;

public class LargestNumberAfterRemovalExample
{
    public static String buildLargestNumber(String number, int k)
    {
        StringBuilder result = new StringBuilder();
        int remainingDigits = number.length() - k;

        for (int i = 0; i < number.length(); i++)
        {
            char digit = number.charAt(i);
            while (result.length() > 0 && result.charAt(result.length() - 1) < digit && k > 0)
            {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            if (result.length() < remainingDigits)
            {
                result.append(digit);
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.next(); // Input number as a string
        int k = scanner.nextInt(); // Number of digits to remove

        String largestNumber = buildLargestNumber(number, k);
        System.out.println(largestNumber);

        scanner.close();
    }
}
