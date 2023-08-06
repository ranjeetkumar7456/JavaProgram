package Roopal;

public class StringDecompression {

    public static String decompressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder decompressed = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(ch)) {
                decompressed.append(ch);
                i++;
            } else {
                // Read the number
                int count = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    count = count * 10 + (str.charAt(i) - '0');
                    i++;
                }

                // Append the letter count times
                char letter = decompressed.charAt(decompressed.length() - 1);
                for (int j = 1; j < count; j++) {
                    decompressed.append(letter);
                }
            }
        }

        return decompressed.toString();
    }
    public static void main(String[] args) {
        String compressedString = "a2b3c4d2";
        String decompressedString = decompressString(compressedString);
        System.out.println("Decompressed string: " + decompressedString);
    }


}
