package HackerEarth;

import java.util.Scanner;

public class ATMCardValidation {
    public static void tryOTPValiation()
    {
        String correctPin = "1234";
        int attempts = 0;

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Main loop for PIN validation
        while (attempts < 3) {
            // Get PIN input from the user
            System.out.print("Please enter your PIN: ");
            String enteredPin = scanner.nextLine();

            // Check if the entered PIN is correct
            if (enteredPin.equals(correctPin)) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                int remainingAttempts = 3 - attempts;
                System.out.println("Wrong PIN! " + remainingAttempts + " attempts remaining.");
            }
        }

        // If all attempts are used up
        if (attempts == 3) {
            System.out.println("Your card is blocked. Please contact your bank.");
        }

        // Close the Scanner
        scanner.close();
    }
    public static void main(String[] args) {
        tryOTPValiation();
    }
}
