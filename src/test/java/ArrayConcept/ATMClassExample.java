package ArrayConcept;

import java.util.Scanner;

public class ATMClassExample
{
    public static void ATMPinCodeValidation()
    {
        int correctPin = 1234; // Change this to your desired correct PIN
        int maxAttempts = 3;
        int attempts = 0;
        boolean isCardBlocked = false;

        Scanner scanner = new Scanner(System.in);

        while (attempts < maxAttempts && !isCardBlocked)
        {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == correctPin)
            {
                System.out.println("PIN correct. Access granted.");
                break;
            }
            else
            {
                attempts++;
                System.out.println("PIN incorrect. Remaining attempts: " + (maxAttempts - attempts));

                if (attempts == maxAttempts)
                {
                    isCardBlocked = true;
                    System.out.println("Card blocked. Please contact your bank.");
                }
            }
        }

        scanner.close();
    }
    public static void main(String[] args)
    {
        ATMPinCodeValidation();

    }
}
