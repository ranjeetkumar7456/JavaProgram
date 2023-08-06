package InterviewQuestion;

public class LongestPalindromeExample {
    public static String findLongestPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < input.length(); i++)
        {
            for (int j = i; j < input.length(); j++)
            {
                if (isPalindrome(input, i, j) && (j - i + 1) > maxLength)
                {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

        return input.substring(start, start + maxLength);
    }

    /*
    The given code finds the longest palindrome substring in a given input string.

    findLongestPalindrome Method:

    This method takes a string input as input and returns the longest palindrome substring found in the input string.
    It first checks if the input string is null or empty. If so, it returns an empty string, as there is no valid palindrome to find.
    It initializes two variables maxLength and start to keep track of the maximum palindrome length found so far and the starting
    index of the longest palindrome substring, respectively.

    It uses two nested loops to find all possible substrings of the input string. The outer loop iterates through each character
    in the input string (from index 0 to the end).

    The inner loop iterates through each character starting from the current outer loop index to the end of the string. This way,
    it considers all possible substrings that start at the current index.

    Inside the inner loop, it calls the isPalindrome method to check if the current substring (from index i to j) is a palindrome.
    The isPalindrome method returns true if the substring is a palindrome; otherwise, it returns false.

    If the substring is a palindrome and its length (j - i + 1) is greater than the current maximum palindrome length (maxLength),
    it updates the maxLength and start variables with the new values.

    After the loops complete, it returns the longest palindrome substring found in the input string by using the substring method
    to extract the substring from the original input string using the start index and the calculated maxLength.

    isPalindrome Method:

    This method takes a string input and two integers start and end as input and returns a boolean value indicating whether the
    substring from index start to end is a palindrome or not.

    It uses a while loop to check if the characters at the start and end indices are equal. If they are not equal, it returns
    false, indicating that the substring is not a palindrome.

    The loop continues until the start index becomes greater than or equal to the end index, which means that the entire substring
    has been checked for palindrome property.

    If the loop completes without finding any unequal characters, it means the substring is a palindrome, and the method returns true.
    Overall, the findLongestPalindrome method uses two nested loops to consider all possible substrings of the input string and the
    isPalindrome method to verify if a given substring is a palindrome. The method returns the longest palindrome substring found in
    the input string.


*/



    public static boolean isPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static String findLongestPalindrome1(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        int n = input.length();
        boolean[][] dp = new boolean[n][n];

        // Single character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLength = 1;

        // Check for palindromes of length 2 or more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (input.charAt(i) == input.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        // Update the longest palindrome
                        if (len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }

        // Extract the longest palindrome substring
        return input.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = findLongestPalindrome(input);
        System.out.println("Longest Palindrome: " + longestPalindrome);
        System.out.println("Longest Palindrome: " + findLongestPalindrome1(input));
    }
}
