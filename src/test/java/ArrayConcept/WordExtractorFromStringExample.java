package ArrayConcept;

public class WordExtractorFromStringExample {
    public static String extractWord(String input, String targetWord) {
        StringBuilder extracted = new StringBuilder();
        int targetIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == targetWord.charAt(targetIndex)) {
                extracted.append(currentChar);
                targetIndex++;
                if (targetIndex == targetWord.length()) {
                    break;
                }
            }
        }

        return extracted.toString();
    }

    public static void main(String[] args) {

         String inputString = "ahceclionlxoautomat";
         String inputString1 = "jsgdsjhfdkrndakfpnfohljnxhdejhggfekjfglhot";
         String targetWord = "hellozghjgh";
        String targetWord1 = "ranjeet";

         String result = extractWord(inputString, targetWord);
         System.out.println("Extracted word: " + result);
         System.out.println("===========================");
        System.out.println("Extracted word: " + extractWord(inputString1, targetWord1));

    }
}
