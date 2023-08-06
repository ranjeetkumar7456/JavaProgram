package Roopal;

public class Palindrome {

    public static void palindrome_String(String input)
    {
        String reverseStr = "";

        int strLength = input.length();

        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + input.charAt(i);
        }

        if (input.toLowerCase().equals(reverseStr.toLowerCase())) {
            System.out.println(input + " is a Palindrome String.");
        }
        else {
            System.out.println(input + " is not a Palindrome String.");
        }
    }

    public static void palindrome_int(int number)
    {
        int reversedNum = 0, remainder;

        // store the number to originalNum
        int originalNum = number;

        // get the reverse of originalNum
        // store it in variable
        while (number != 0) {
            remainder = number % 10;
            reversedNum = reversedNum * 10 + remainder;
            number /= 10;
        }

        // check if reversedNum and originalNum are equal
        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is Palindrome.");
        }
        else {
            System.out.println(originalNum + " is not Palindrome.");
        }
    }


    public static void main(String[] args) {
        String input = "Radar";

        int number = 3553;
        palindrome_String(input);
        palindrome_int(number);

    }
}
