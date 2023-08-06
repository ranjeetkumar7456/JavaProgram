package StringProblems;

import java.util.Scanner;

public class   StringCompression {
    public static void main(String[] args)
    {
        StringCompression str = new StringCompression();
        String s1,s2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string (you can include space as well)");
        s1 = in.nextLine();
        //Trim all the spaces of the string using replaceAll method
        s2 = s1.replaceAll("\\s","");
        str.Compression(s2);
    }


    //Create a Java Method Compression to compress the string
    public static String Compression(String s)
    {
        int count = 1;
        StringBuilder sb = new StringBuilder();

//Below for loop counts all characters of the string apart from the last one
//The last character won't get appended by the class StringBuilder here as it
//does not enter the for loop once the length completes the count
        for (int i = 1; i < s.length()-1 ; i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
            {
                count++;
            }
            else
            {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }
//Count the last character of the string
        if (s.length() > 1)
        {
            //Compare the last two characters of the string
            if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2))
            {
                count++;
            }
            else
            {
                sb.append(s.charAt(s.length() - 2));
                sb.append(count);
                count = 1;
            }
            sb.append(s.charAt(s.length() - 1));
            sb.append(count);
        }
        s = sb.toString();
        System.out.println("The compressed string along with the counts of repeated characters is:" + "\n" +s);
        return s;
    }
}

