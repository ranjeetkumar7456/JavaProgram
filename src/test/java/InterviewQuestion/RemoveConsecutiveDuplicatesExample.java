package InterviewQuestion;

public class RemoveConsecutiveDuplicatesExample {

    public static String removeConsecutiveDuplicates(String input)
    {
        if (input == null || input.isEmpty())
        {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        char prevChar = '\0';  // Initialize with a null character

        for (char currentChar : input.toCharArray())
        {
            if (currentChar != prevChar)
            {
                sb.append(currentChar);
                prevChar = currentChar;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String input = "aabbbcabcbb";
        String result = removeConsecutiveDuplicates(input);
        System.out.println("Result: " + result);
    }

}
