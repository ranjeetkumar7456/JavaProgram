package Roopal;

import java.util.HashMap;
import java.util.Map;

public class String_CompressionNDecompression {

    /*Explanation:

    1. We define a method called compressString that takes a String parameter and returns the compressed string.
    2. We create a StringBuilder called compressed to build the compressed string.
    3. We initialize a variable called count to keep track of the number of consecutive characters.
    4. We iterate over the characters of the input string using a for loop, except for the last character
       (since we compare each character with the next one).
    5. If the current character is the same as the next character, we increment the count variable.
    6. If the current character is different from the next character, we append the current character
    and its count to the compressed string, and reset the count to 1.
    7. After the loop ends, we append the last character and its count to the compressed string.
    8. Finally, we compare the lengths of the original string and the compressed string. If the compressed string is shorter, we return it. Otherwise, we return the original string.
    9. In the main method, we provide a test case where str is set to "aabbbccccdd".
    10. We call the compressString method with the test case string and print the original and compressed strings.


    In this example, the output will be:

    arduino
    Copy code
    Original String: aabbbccccdd
    Compressed String: a2b3c4d2
    */
        public static String compressString(String str)
        {
            StringBuffer compressed = new StringBuffer();
            int count = 1;

            for (int i = 0; i < str.length()-1; i++)
            {
                if (str.charAt(i) == str.charAt(i + 1))
                {
                    count++;
                }
                else
                {
                    compressed.append(str.charAt(i)).append(count);
                    count = 1;
                }
            }

            // Append the last character and its count
            compressed.append(str.charAt(str.length() - 1)).append(count);

            // Return the compressed string only if it is shorter than the original
            return (compressed.length() < str.length()) ? compressed.toString() : str;
        }

        // 2nd way

    public static String compressString1(String str) {
        char[] charArray = str.toCharArray();
        StringBuffer compressed = new StringBuffer();
        int count = 1;

        for (int i = 0; i < charArray.length - 1; i++)
        {
            if (charArray[i] == charArray[i + 1])
            {
                count++;
            }
            else
            {
                compressed.append(charArray[i]).append(count);
                count = 1;
            }
        }

        // Append the last character and its count
        compressed.append(charArray[charArray.length - 1]).append(count);

        // Return the compressed string only if it is shorter than the original
        return (compressed.length() < charArray.length) ? compressed.toString() : str;
    }



    /*
    Explanation:

    1. We define a method called decompressString that takes a compressed string as a
       parameter and returns the decompressed string.
    2. We create a StringBuilder called decompressed to build the decompressed string.
    3. We initialize a variable called count to store the number of repetitions of the
       current character.
    4. We iterate over the characters of the compressed string using a for loop.
    5. For each character, we check if it is a digit using the Character.isDigit() method.
    6. If the current character is a digit, we update the count by multiplying it by 10
       and adding the numeric value of the digit.
    7. If the current character is not a digit, it means we have encountered a character
       that needs to be repeated. We iterate count times and append the current character to
       the decompressed string.
    8. After the loop ends, we return the decompressed string.
    9. In the main method, we provide a test case where compressedStr is set to "a2b3c4d2".
    10. We call the decompressString method with the compressed string and print
        the compressed and decompressed strings.


    In this example, the output will be:

    Compressed String: a2b3c4d2
    Decompressed String: aabbbccccdd
    */

    public static String decompressString(String str) {
        StringBuilder decompressed = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (Character.isDigit(currentChar))
            {
                count = count * 10 + (currentChar - '0');   //(currentChar - '0'): This part of the expression converts the digit character
                                                            // currentChar to its corresponding numeric value
            }
            else
            {
                for (int j = 0; j < count; j++)
                {
                    decompressed.append(currentChar);
                }
                count = 0;
            }
        }

        return decompressed.toString();
    }



    /*(currentChar - '0'): This part of the expression converts the digit character currentChar
    to its corresponding numeric value. In Java, characters representing digits have consecutive
    Unicode values, where the character '0' has the numeric value 48, '1' has the numeric value 49,
    '2' has the numeric value 50, and so on. When you subtract the character '0' from a digit character,
    you get its numeric value. For example:

    If currentChar is '0', then (currentChar - '0') will be 48 - 48, which equals 0.
    If currentChar is '1', then (currentChar - '0') will be 49 - 48, which equals 1.
    If currentChar is '9', then (currentChar - '0') will be 57 - 48, which equals 9.
    count * 10: This part of the expression multiplies the existing count value by 10.
    This is done to handle multi-digit numbers in the compressed string. As the loop processes
    each digit character, it needs to consider its position within the number. For example, if
    the digit characters are '1', '2', and '3', the resulting count should be 123, not 6. By
    multiplying the existing count by 10 before adding the new digit value, the correct number is
    obtained.

    Putting it all together, the expression count = count * 10 + (currentChar - '0'); updates the
    count variable with the correct value based on the digit characters encountered in the compressed
    string.
*/
    public static String compressString_UsingHashMap(String str) {
        StringBuilder compressed = new StringBuilder();
        char[] charArray = str.toCharArray();

        // Create a map to store character frequency
        Map<Character, Integer> charCount = new HashMap<>();

        // Count the frequency of each character
        for (char c : charArray) {
            charCount.put(c, charCount.get(c) + 1);
        }

        // Compress the string using character frequency
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            compressed.append(entry.getKey()).append(entry.getValue());
        }

        // Return the compressed string only if it is shorter than or equal to the original
        return (compressed.length() < str.length()) ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String str = "aabbbccccdd";
        System.out.println("Original String: " + str);
        System.out.println("Compressed String: " + compressString(str));
        System.out.println("=========");
        String compressedStr = "a2b3c4d2";
        System.out.println("Compressed String: " + compressedStr);
        System.out.println("Decompressed String: " + decompressString(compressedStr));

        //System.out.println("Decompressed String: " + compressString_UsingHashMap(str));
    }

}
