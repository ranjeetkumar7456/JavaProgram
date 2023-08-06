package ArrayConcept;

import java.util.Scanner;

public class CreditCardType
{
    public static String getCardType(String cardNumber)
    {
        // Extract the first four digits from the card number
        String firstFourDigits = cardNumber.substring(0, 4);
        int sumFirstFour = 0;
        for (int i = 0; i < firstFourDigits.length(); i++)
        {
            char digitChar = firstFourDigits.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            sumFirstFour += digit;
        }
        // Determine the card type based on the sum
        String cardType = (sumFirstFour == 16) ? "Visa" : "Mastercard";
        return cardType;
    }

    public static void CardType(String cardNumber)
    {
        int correctPin = 1234; // Change this to your desired correct PIN
        int maxAttempts = 3;
        int attempts = 0;
        boolean isCardBlocked = false;
        if (cardNumber.length() == 16 && cardNumber.matches("\\d+"))  // "\\d" - > checks whether is  and 16 didgit
        {
            String firstFourDigits = cardNumber.substring(0, 4);
            int sumFirstFour = 0;
            for (int i = 0; i < firstFourDigits.length(); i++)
            {
                char digitChar = firstFourDigits.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                sumFirstFour += digit;
            }
            // Determine the card type based on the sum
            String cardType = (sumFirstFour == 16) ? "Visa" : "Mastercard";
            System.out.println("The credit card is a " + cardType + ".");
        }
        else
        {
            System.out.println("Invalid credit card number. Please enter a 16-digit number.");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the 16-digit credit card number: ");
        String cardNumber = scanner.nextLine();
        CardType(cardNumber);
    }
}
