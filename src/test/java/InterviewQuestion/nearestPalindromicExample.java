package InterviewQuestion;

public class nearestPalindromicExample
{
    public static boolean isPalindrome(long num) {
        String numStr = Long.toString(num);
        String reversedNumStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedNumStr);
    }

    public static long findNearestPalindrome(long num)
    {
        long smaller = num - 1;
        while (!isPalindrome(smaller)) {
            smaller--;
        }

        long larger = num + 1;
        while (!isPalindrome(larger)) {
            larger++;
        }

        return (num - smaller) < (larger - num) ? smaller : larger;
    }

    public static void main(String[] args)
    {
        long input = 134;
        long nearestPalindrome = findNearestPalindrome(input);
        System.out.println("Nearest Palindrome: " + nearestPalindrome); // Output: 111
    }
}
