package InterviewQuestion;

public class SumOfDigitsExample {

    public static int sumOfDigits(int number) {
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;  // Get the rightmost digit
            sum += digit;
            number /= 10;  // Remove the rightmost digit
        }

        return sum;
    }
    public static void main(String[] args)
    {
        int number = 12345;
        int sum = sumOfDigits(number);
        System.out.println("Sum of Digits: " + sum);
    }


}
