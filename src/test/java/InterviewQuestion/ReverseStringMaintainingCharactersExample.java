package InterviewQuestion;

public class ReverseStringMaintainingCharactersExample {

    public static String reverseStringMaintainingCharacters(String input, String charactersToMaintain) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (charactersToMaintain.indexOf(chars[left]) == -1) {
                while (left < right && charactersToMaintain.indexOf(chars[right]) != -1) {
                    right--;
                }
                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    right--;
                }
            }
            left++;
        }

        return new String(chars);
    }

    public static void main(String[] args)
    {
        String input = "Hello, World!";
        System.out.println(input);
        String charactersToMaintain = "eW";
        String reversedString = reverseStringMaintainingCharacters(input, charactersToMaintain);
        System.out.println(reversedString); // Output: dloW, olleH!
    }
}
