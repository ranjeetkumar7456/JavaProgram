package InterviewQuestion;

public class ReverseStringWithSpecialCharsExample
{
    public static void reverseStringWithSpecialChars(String input)
    {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right)
        {
            if (!Character.isLetterOrDigit(charArray[left]))
            {
                left++;
            } else if (!Character.isLetterOrDigit(charArray[right]))
            {
                right--;
            }
            else
            {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        System.out.println(String.valueOf(charArray)); //String(charArray);
    }

    public static void main(String[] args)
    {
        String input = "a,b$c";
        System.out.println("Actual String : ");
        System.out.println(input);
        System.out.println("Reverse String is :");
        reverseStringWithSpecialChars(input); // Output: c,b$a
    }
}
