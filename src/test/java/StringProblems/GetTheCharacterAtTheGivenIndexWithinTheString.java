package StringProblems;

//Write a Java program to get the character at the given index within the String.

public class GetTheCharacterAtTheGivenIndexWithinTheString {

    public static void GetTheCharacterAtTheGivenIndexWithinTheString(String input, int index)
    {
        int index1 = input.charAt(0);
        System.out.println("The character at position 0 is " + (char)index1);
    }


    public static void main(String[] args)
    {
        String str = "Java Exercises!";

        GetTheCharacterAtTheGivenIndexWithinTheString(str,10);
    }
}
