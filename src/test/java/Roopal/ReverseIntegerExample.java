package Roopal;

import java.sql.SQLOutput;

public class ReverseIntegerExample {
    public static void reverseIntegerNotMaintainingZero(int input)
    {
        int inputNumber = input;
        int rev=0;
        while(inputNumber>0)
        {
            rev = rev*10+inputNumber%10;
            inputNumber=inputNumber/10;
        }
        System.out.println(rev);
    }

    public static void reverseIntegerMaintainingZero(int input)
    {
        String inputNumber = String.valueOf(input);
        char[] number= inputNumber.toCharArray();

        for(int i =inputNumber.length()-1;i>=0;i--)
        {
            System.out.print(number[i]);
        }


    }

    public static void main(String[] args) {

        //reverseIntegerNotMaintainingZero(12345);
        reverseIntegerMaintainingZero(1234510);
        System.out.println();
        reverseIntegerNotMaintainingZero(1234510);

    }
}
