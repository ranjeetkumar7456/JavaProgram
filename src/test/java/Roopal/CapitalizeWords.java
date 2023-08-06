package Roopal;

public class CapitalizeWords {
    public static void capitalize_Words(String sentence) {
        StringBuilder result = new StringBuilder();

        // Split the sentence into words using space as the delimiter
        String[] words = sentence.split(" ");

        for (String word : words) {
            // Capitalize the first letter of each word
            char firstChar = Character.toUpperCase(word.charAt(0));
            String restOfWord = word.substring(1);

            // Append the capitalized word to the result
            result.append(firstChar).append(restOfWord).append(" ");
        }

        // Remove the extra space at the end of the result and return it
        //return result.toString().trim();
        System.out.println(result.toString().trim());
    }

    public static String capitalizeLetter(String inputString, int indexToCapitalize) {
        if (indexToCapitalize < 0 || indexToCapitalize >= inputString.length()) {
            System.out.println("Invalid index.");
            return inputString;
        }

        char[] chars = inputString.toCharArray();
        chars[indexToCapitalize] = Character.toUpperCase(chars[indexToCapitalize]);

        return String.valueOf(chars);
    }

    public static String capitalizeEachWord(String inputString, int indexToCapitalize) {
        String[] words = inputString.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (indexToCapitalize >= 0 && indexToCapitalize < word.length()) {
                char[] chars = word.toCharArray();
                chars[indexToCapitalize] = Character.toUpperCase(chars[indexToCapitalize]);
                word = String.valueOf(chars);
            }
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String str = "this is a sample sentence";
        //String capitalizedSentence = capitalize_Words(str);
        //System.out.println(capitalize_Words(str));
        capitalize_Words(str);

        System.out.println(capitalizeLetter(str,0));
        System.out.println(capitalizeEachWord(str,3));


    }
}
