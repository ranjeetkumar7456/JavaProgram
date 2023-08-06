package ArrayConcept;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmileysCountExample
{
    public static int countSmileys(String input)
    {
        // Define the regular expression pattern for smileys
        String regex = "(:\\)|:\\D)";

        // Create a Pattern object using the regex
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object to find matches in the input string
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        // Find and count all occurrences of smileys
        while (matcher.find())
        {
            count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        String input = "Hello! How are you :) I am great :D";
        int smileysCount = countSmileys(input);
        System.out.println("The count of smileys is: " + smileysCount);
    }
}
