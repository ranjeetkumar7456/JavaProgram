package Roopal;

public class StringCompression {
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char prevChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar == prevChar) {
                count++;
            } else {
                compressed.append(prevChar);
                compressed.append(count);
                count = 1;
                prevChar = currentChar;
            }
        }

        // Append the last character and its count
        compressed.append(prevChar);
        compressed.append(count);

        return compressed.toString();
    }

    public static void main(String[] args) {
        String input = "aabbbcccccccdd";
        String compressedString = compressString(input);
        System.out.println("Compressed string: " + compressedString);
    }


}
