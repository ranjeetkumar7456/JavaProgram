package Java.dataStructure;

import java.util.Scanner;

public class AnagramChecker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Getting the input string from the user
        System.out.print("Enter the First String : ");
        String s1 = scanner.nextLine();
        System.out.print("Enter the second String : ");
        String s2 = scanner.nextLine();

        if (checkAnagram(s1, s2))
            System.out.println(s1 + " and " + s2 + " are Anagrams");
        else
            System.out.println(s1 + " and " + s2 + " are NOT Anagrams");
        scanner.close();
    }

    public static boolean checkAnagram(String s1, String s2)
    {
        // Remove all the white space, convert to lower case & character array
        char[] arr1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        if (arr1.length != arr2.length)
            return false;

        int xor = 0;

        for (int i = 0; i < arr1.length; i++)
        {
            xor ^= arr1[i] ^ arr2[i];
        }

        return xor == 0? true: false;
    }
}