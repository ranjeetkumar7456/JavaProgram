package Roopal;

import java.util.Arrays;

public class AnagramExample {
    public static boolean anagram(String first,String second)
    {
        boolean status = false;
        String firstWord = first.replaceAll(" ","").toLowerCase();
        String secondWord = second.replaceAll(" ","").toLowerCase();
        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();
        if(firstArray.length==secondArray.length               )
        {
            Arrays.sort(firstArray);
            Arrays.sort(secondArray);
            status= Arrays.equals(firstArray,secondArray);
        }
        return status;

    }
    public static void main(String[] args) {

        if(anagram("peek","keep"))
        {
            System.out.println("Both are anagram");
        }
        else
        {
            System.out.println("Both are not anagram");
        }

    }
}
