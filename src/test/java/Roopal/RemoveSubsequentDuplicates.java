package Roopal;

public class RemoveSubsequentDuplicates {
    public static String removeSubsequentDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        char prevChar = str.charAt(0);
        result.append(prevChar);

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != prevChar) {
                result.append(currentChar);
                prevChar = currentChar;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String inputString = "aaabbcccdeee";
        String uniqueString = removeSubsequentDuplicates(inputString);
        System.out.println("Unique set of characters: " + uniqueString);
    }


}
