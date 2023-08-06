package InterviewQuestion;


// Java program to 	Given an array of strings, find the common prefix.

public class CommonPrefix {
    public static String findCommonPrefix(String[] strings)
    {
        if (strings == null || strings.length == 0)
        {
            return "";
        }

        String prefix = strings[0];

        for (int i = 1; i < strings.length; i++)
        {
            while (!strings[i].startsWith(prefix))
            {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }



    public static String findCommonPrefix_1(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strings) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLength; i++)
        {
            char currentChar = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++)
            {
                if (strings[j].charAt(i) != currentChar)
                {
                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
        }

        return prefix.toString();
    }
/*
    In this program, we have an array of strings named strings. We define a method called findCommonPrefix() that takes this array as input and returns the common prefix as a string.

    In the findCommonPrefix() method, we first check if the input array is null or empty. If so, we return an empty string since there is no common prefix.

            Next, we find the minimum length among all the strings in the array using a for loop.

            Then, we iterate through each character position from 0 to the minimum length. We compare the character at that position in the first string with the corresponding character in the remaining strings. If any character differs, we return the current prefix found so far. Otherwise, we append the current character to the prefix.

    Finally, we return the common prefix as a string.

    When you run this program with the provided input, the output will be:

    mathematica
    Copy code
    Common Prefix: app

    */

    public static String findCommonPrefix_2(String[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return "";
        }

        String firstString = arr[0];
        int commonPrefixLength = 0;

        for (int i = 0; i < firstString.length(); i++)
        {
            char currentChar = firstString.charAt(i);

            for (int j = 1; j < arr.length; j++)
            {
                if (i >= arr[j].length() || arr[j].charAt(i) != currentChar)
                {
                    return firstString.substring(0, commonPrefixLength);
                }
            }

            commonPrefixLength++;
        }

        return firstString.substring(0, commonPrefixLength);
    }


/*
    In this program, we have a method findCommonPrefix() that takes an array of strings as input and returns the common prefix.

    First, we handle edge cases: if the array is null or empty, we return an empty string as there is no common prefix in that case.

    We initialize firstString with the first string from the array and commonPrefixLength as 0.

    Next, we iterate over the characters of firstString using a for loop. For each character at index i, we compare it with the corresponding character at the same index in the other strings. If we find a mismatch or if i is beyond the length of any of the strings, we return the substring of firstString from index 0 to commonPrefixLength as the common prefix.

    If we reach the end of the loop without finding a mismatch, we increment commonPrefixLength to include the current character in the common prefix.

            Finally, we return the substring of firstString from index 0 to commonPrefixLength as the common prefix.

    In the main() method, we create an array of strings and call findCommonPrefix() to get the common prefix. We then print the common prefix using System.out.println().

    When you run this program with the provided input, the output will be:

    Common Prefix: app

    */

    public static String findCommonPrefix_3(String[] arr)
    {
        /*if (arr.length == 0) { return ""; }: The method starts by checking if the input array arr is
        empty. If it is, there are no strings to compare, so the method returns an empty string "".*/
        if (arr.length == 0)
        {
            return "";
        }
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            while (arr[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void findCommonPrefix_4(String[] arr)
    {
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            while (!arr[i].startsWith(prefix))
            {
                prefix = prefix.substring(0, prefix.length() - 1);    // removing last character
                if (prefix.isEmpty())
                {
                    System.out.println("not found any prefix");
                }
            }
        }
        if(!prefix.isEmpty())
        {
            System.out.println("Common prefix is : "+prefix);
        }

    }

   /*
   prefix = prefix.substring(0, prefix.length() - 1):
   Inside the loop, the prefix is shortened by removing the last character using the substring method.
   This step is performed to check for shorter common prefixes in subsequent iterations.

   if (prefix.isEmpty()) { return ""; }:
   If the prefix becomes empty during the loop, it means there is no common prefix among all the strings.
   In such a case, the method returns an empty string "" to indicate that there is no common prefix.

*/
    public static void main(String[] args)
    {
        String[] arr = {"apple", "app", "aptitude", "append"};

        findCommonPrefix_4(arr);

    }
}
