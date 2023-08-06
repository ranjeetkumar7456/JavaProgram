package InterviewQuestion;

import java.util.HashSet;

public class RemoveDuplicatesExample {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        HashSet<Character> uniqueChars = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (uniqueChars.add(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "Hello, World!";
        String result = removeDuplicates(input);
        System.out.println("Result: " + result);
    }


}
