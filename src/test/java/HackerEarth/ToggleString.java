package HackerEarth;

import java.util.Scanner;

public class ToggleString
{
    public static String convertString(String str)
    {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++)
        {
            char ch = charArray[i];
            if (Character.isUpperCase(ch))
            {
                charArray[i] = Character.toLowerCase(ch);
            }
            else if (Character.isLowerCase(ch))
            {
                charArray[i] = Character.toUpperCase(ch);
            }
        }
        return new String(charArray);
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String converted = convertString(input);
        System.out.println(converted);

        scanner.close();
    }
}

//   input - abcdE
//   output -ABCDe