package Roopal;

import java.util.ArrayList;
import java.util.List;

public class Permutations_of_a_string {

    public static String printPermutn(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return "";
        }

        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch);
        }
        return str;
    }


    /*public static String printPermutn1(String str)
    {
        if (str.length() == 0) {
            System.out.print(" ");
            return "";
        }

        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String result = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutn1(result);
        }
        return str;
    }*/

    public static String permutation(String str)
    {
        if (str == null || str.length() == 0)
        {
            return "";
        }
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++)
        {
            for (int j = result.size() - 1; j >= 0 ; j--)
            {
                String s1 = result.remove(j);
                for (int k = 0; k <= s1.length(); k++)
                {
                    result.add(s1.substring(0, k) + str.charAt(i) + s1.substring(k));
                }
            }
        }
        System.out.println(result);
        return str;
    }


    public static String printPermutn3(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return "";
        }

        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutn3(ros, ans + ch);
        }
        return str;
    }



    // Driver code
    public static void main(String[] args)
    {
        String s = "ABC";
        //printPermutn3(s,"");
        ///System.out.println();
        //System.out.println(permutation(s));
        printPermutn(s,"");
    }
}
