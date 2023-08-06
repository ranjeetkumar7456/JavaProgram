package Roopal;

public class RemoveAllVowelsFromString {
    public static void removeVowel(String input)
    {
        String newInputString = input.replaceAll("[AEIOUaeiou]", "");
        System.out.println("The string without vowels...");
        System.out.println(newInputString);
    }

    public static void main(String[] args) {
        removeVowel("Java Concept Of The Day");
    }
}
