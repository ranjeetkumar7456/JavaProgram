package HackerEarth;

import java.util.Scanner;

public class PalindromeCheckExample
{
    static boolean checkPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;

        while (left < right)
        {
            if (str.charAt(left) != str.charAt(right))
            {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If the loop completes without returning false, it's a palindrome
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // Input string

        boolean isPalindrome = checkPalindrome(input);
        if (isPalindrome)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }

        scanner.close();
    }
}


