package Lusoft;

import java.util.Scanner;

public class CreditCardType
{
    public static void creditCardNumber(String cardNumber)
    {
        long card = Long.valueOf(cardNumber);
        if(cardNumber.length()!=16)
        {
            System.out.println("Invalid card number");
        }
        else
        {
            int sum = 0;
            for (int i = 0; i < 4; i++)
            {
                sum += Character.getNumericValue(cardNumber.charAt(i));
            }

            if (sum == 16)
            {
                System.out.println("Credit Card Type: VISA");
            }
            else
            {
                System.out.println("Credit Card Type: MasterCard");
            }
        }

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the 16-digit credit card number: ");
        String cardNumber = scanner.nextLine();
        creditCardNumber(cardNumber);

    }
}