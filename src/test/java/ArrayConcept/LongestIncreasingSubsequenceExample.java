package ArrayConcept;

public class LongestIncreasingSubsequenceExample
{
    public static int findLongestIncreasingSubsequenceLength(int[] array)
    {
        int n = array.length;
        int[] dp = new int[n];

        // Initialize the dynamic programming array with 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Compute the lengths of the longest increasing subsequences
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum length from the dynamic programming array
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};
        int length = findLongestIncreasingSubsequenceLength(array);
        System.out.println("Length of the longest increasing subsequence: " + length);
    }
}
