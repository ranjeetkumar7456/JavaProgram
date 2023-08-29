package ArrayConcept;

import java.util.Scanner;

public class NearestPalindromeExample
{
    public static boolean isPalindrom(int number)
    {
        char[] charArray= String.valueOf(number).toCharArray();
        int left=0;
        int right = charArray.length-1;
        while(left<right)
        {
            if(charArray[left]!=charArray[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int nearestPalindrom(int number)
    {
        if(isPalindrom(number))
        {
            return number;
        }
        int smallestPalindrom= number-1;
        while(!isPalindrom(smallestPalindrom))
        {
            smallestPalindrom--;
        }

        int largestPalindrome = number+1;
        while(!isPalindrom(largestPalindrome))
        {
            largestPalindrome++;
        }
        if(number - smallestPalindrom<largestPalindrome - number)
        {
            return smallestPalindrom;
        }
        else
        {
            return largestPalindrome;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //int number=19;
        int number = sc.nextInt();
        int nearestPalindromNumber = nearestPalindrom(number);
        System.out.println("Nearest Palindrom of "+number+" is : "+nearestPalindromNumber);
    }
}
