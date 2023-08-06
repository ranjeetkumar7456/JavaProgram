package Roopal;

public class longestPalindromeExample {

    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return str.substring(start, start + maxLength);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    private static String findLongestPalindromicSubstring(String input) {
        if(input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            palindrom[j][j] = true;
            for(int i = 0; i < j; i++) {
                if(input.charAt(i) == input.charAt(j) && (j-i <= 2 || palindrom[i+1][j-1])) {
                    palindrom[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return input.substring(startIndex, endIndex+1);
    }

    public static String getLongestPalindrome(String s) {
        int n = s.length();
        int index  = -1, palindromeLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int isPalindrome = 1;
                for (int k = i; k <= j; k++) {
                    if (s.charAt(k) != s.charAt(j - (k - i))) {
                        isPalindrome = 0;
                    }
                }
                if (isPalindrome == 1 && j - i + 1 > palindromeLength) {
                    index = i;
                    palindromeLength = j - i + 1;
                }
            }
        }
        String ans = "";
        for (int i = index; i < index + palindromeLength; i++) {
            ans += s.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "babad";
        //String result = longestPalindrome(str);
        //System.out.println(result);  // Output: "bab"


        //System.out.println(findLongestPalindromicSubstring(str));

        System.out.println(getLongestPalindrome(str));
    }
}
