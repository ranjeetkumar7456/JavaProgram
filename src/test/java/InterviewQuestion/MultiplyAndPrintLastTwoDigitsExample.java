package InterviewQuestion;


//Given an array of N random two-digit numbers, multiply each number with M and print the last 2 digits of each product

import java.util.Random;

public class MultiplyAndPrintLastTwoDigitsExample {

    static int N,M;
    //int M;

    public static void MultiplyAndPrintLastTwoDigits(int[] arr, int multiplier)
    {
        // Multiply each number with the multiplier and print the last two digits
        for (int i = 0; i < arr.length; i++) {
            int product = arr[i] * multiplier;
            int lastTwoDigits = product % 100;
            System.out.println(lastTwoDigits);
        }

    }

    public static void MultiplyAndPrintLastTwoDigits1(int[] arr, int multiplier)
    {
        for(int i=0;i<arr.length;i++)
        {
            while(arr[i]>=10 && arr[i]<= 99)
            {
                Random random = new Random();
                int randomIndex = random.nextInt(arr.length);
                int randomNumber = arr[randomIndex];
                int product = randomNumber * multiplier;
                int lastTwoDigits = product % 100;
                System.out.println(lastTwoDigits);
            }
        }
    }

   /* public static int getRandomIndex(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }*/

    public static void main(String[] args) {
        int[] arr = {12, 34, 56, 78, 90};
        int multiplier = 5;
        //MultiplyAndPrintLastTwoDigits(arr,multiplier);

       /* // Multiply each number with the multiplier and print the last two digits
        for (int i = 0; i < numbers.length; i++) {
            int product = numbers[i] * multiplier;
            int lastTwoDigits = product % 100;
            System.out.println(lastTwoDigits);
        }*/

        MultiplyAndPrintLastTwoDigits1(arr,15);
    }
}
