package InterviewQuestion;

//Remove the subsequent duplicate characters in a string until you get a unique set of characters

public class RemoveSubsequentDuplicatesExample {

    public static String removeSubsequentDuplicates(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);

            if (currentChar != previousChar) {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "aabbccddeeffgg";
        String result = removeSubsequentDuplicates(input);
        System.out.println("Result: " + result);
    }


}
