package InterviewQuestion;

public class NearestPalindromeExample {

    public static int findNearestPalindrome(int number)
    {
        if (isPalindrom(number))
        {
            return number;
        }

        int smallerPalindrome = number - 1;
        while (!isPalindrome(smallerPalindrome))
        {
            smallerPalindrome--;
        }

        int largerPalindrome = number + 1;
        while (!isPalindrome(largerPalindrome))
        {
            largerPalindrome++;
        }

        if (number - smallerPalindrome <= largerPalindrome - number)
        {
            return smallerPalindrome;
        }
        else
        {
            return largerPalindrome;
        }
    }

    public static boolean isPalindrome(int number)
    {
        String numberString = String.valueOf(number);
        int left = 0;
        int right = numberString.length() - 1;

        while (left < right)
        {
            if (numberString.charAt(left) != numberString.charAt(right))
            {
                return false;
            }
            else
            {
                left++;
                right--;
            }

        }

        return true;
    }
    public static boolean isPalindrom(int number)
    {
        char [] charArray= String.valueOf(number).toCharArray();
        int left =0;
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
    public static void main(String[] args)
    {
        int number = 117;

        int nearestPalindrome = findNearestPalindrome(number);

        System.out.println("Nearest palindrome: " + nearestPalindrome);
    }


}
