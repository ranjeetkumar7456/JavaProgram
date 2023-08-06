package Roopal;

public class SumOfAllDigit {

    public static void sumOfAllDigits(int input)
    {
        int number = input;
        int sum = 0;
        while(number!=0)
        {
            int last_digit = number%10;
            sum = sum+last_digit;
            number = number/10;
        }


        System.out.println("Sum of All digit is : "+sum);
    }

    public static void main(String[] args) {
        int input = 12345;

        sumOfAllDigits(input);
    }
}
