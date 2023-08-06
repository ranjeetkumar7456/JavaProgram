package StringProblems;

import java.util.Scanner;

import java.lang.*;


public class StringDecompression {

    public static void decompress(String compressedString)
    {
        int index = 0;
        int numReps = 0;
        char nextChar = ' ';

        while (index < compressedString.length())
        {
            numReps = 0;
            char c = compressedString.charAt(index);
            if (!Character.isDigit(c))
            {
                nextChar = c;
                index++;
            }
            else
            {
                while (Character.isDigit(c))
                {
                    int temp = Integer.parseInt(""+c);
                    numReps = (numReps*10) + temp;
                    index++;
                    if (index >= compressedString.length()) break;
                    c = compressedString.charAt(index);
                }
                for (int i =0; i<numReps; i++)
                {
                    System.out.print(nextChar);
                }
            }
        }
    }

    public static void main(String[] args) {
        decompress("d5s6h3m5s");
    }
}