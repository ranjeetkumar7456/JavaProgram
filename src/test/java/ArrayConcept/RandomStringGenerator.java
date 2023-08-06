package ArrayConcept;

import java.util.Random;

public class RandomStringGenerator
{

    //Program to generate a random string (OTP) in format A23DR, B45GH, C87LK, etc.
    public static String generateRandomString() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        Random random = new Random();

        char letter1 = letters.charAt(random.nextInt(letters.length()));
        char digit1 = digits.charAt(random.nextInt(digits.length()));
        char digit2 = digits.charAt(random.nextInt(digits.length()));
        char letter2 = letters.charAt(random.nextInt(letters.length()));
        char letter3 = letters.charAt(random.nextInt(letters.length()));

        return "" + letter1 + digit1 + digit2 + letter2 + letter3;
    }

    public static void main(String[] args) {
        int numberOfStrings = 5; // You can change this to generate a different number of random strings

        for (int i = 0; i < numberOfStrings; i++) {
            String randomString = generateRandomString();
            System.out.println(randomString);
        }
    }


}
