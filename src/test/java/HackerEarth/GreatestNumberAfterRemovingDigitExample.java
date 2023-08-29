package HackerEarth;

import java.util.Scanner;

public class GreatestNumberAfterRemovingDigitExample
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int N = scanner.nextInt();

        System.out.print("Enter the number of digits in each integer: ");
        int m = scanner.nextInt();

        int[] numbers = new int[N];

        System.out.println("Enter " + N + " integers with " + m + " digits each:");
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Largest numbers after removing one digit:");

        for (int num : numbers) {
            int maxNumber = Integer.MIN_VALUE;

            for (int i = 0; i < m; i++) {
                int tempNum = removeDigit(num, i);
                maxNumber = Math.max(maxNumber, tempNum);
            }

            System.out.println(maxNumber);
        }
    }

    public static int removeDigit(int num, int digitIndex) {
        String numStr = Integer.toString(num);
        String newNumStr = numStr.substring(0, digitIndex) + numStr.substring(digitIndex + 1);
        return Integer.parseInt(newNumStr);
    }
}
