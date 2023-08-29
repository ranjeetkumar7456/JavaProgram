package CodebytePractice;


 /*   Bracket Combinations
    Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
    and return the number of valid combinations that can be formed with num pairs of parentheses. For example,
    if the input is 3, then the possible combinations of 3 pairs of parenthesis, namely: ()()(), are ()()(), ()(()), (())(), ((())),
    and (()()). There are 5 total combinations when the input is 3, so your program should return 5.

    Examples
       Input: 3
       Output: 5
       Input: 2
       Output: 2

  */

import java.util.Scanner;

public class BracketCombinationsExample
{
    public static int BracketCombinations(int num)
    {
        if (num == 0)
        {
            return 1; // Base case: 1 combination with zero pairs of parentheses
        }

        int count = 0;
        for (int i = 0; i < num; i++)
        {
            count += BracketCombinations(i) * BracketCombinations(num - 1 - i);
        }
        return count;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(s.nextInt()));
    }

}
