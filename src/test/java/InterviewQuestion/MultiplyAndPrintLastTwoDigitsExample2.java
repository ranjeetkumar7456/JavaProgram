package InterviewQuestion;

import java.util.Random;

public class MultiplyAndPrintLastTwoDigitsExample2
{

    public static void MultiplyAndPrintLastTwoDigits(int N,int M)
    {

        int[] numbers = new int[N];
        Random random = new Random();

        // Generate random two-digit numbers
        for (int i = 0; i < N; i++) {
            numbers[i] = random.nextInt(90) + 10;
        }

        // Multiply each number by M and print the last two digits
        for (int i = 0; i < N; i++) {
            int product = numbers[i] * M;
            int lastTwoDigits = product % 100;
            System.out.println(lastTwoDigits);
        }
    }
    public static void main(String[] args)
    {
        MultiplyAndPrintLastTwoDigits(3,15);

       /* float number =77;
        System.out.println(number/100);
        System.out.println(number%100);*/
    }
}
