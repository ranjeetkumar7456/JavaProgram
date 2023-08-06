package Roopal;

import java.util.Arrays;

public class InterviewProgramTes {
    public static boolean isAnagram(String input1,String input2)
    {
        boolean status = false;

        String firstWord = input1.replaceAll(" ","").toLowerCase();
        String secondWord = input2.replaceAll(" ","").toLowerCase();
        char[] firstArray = firstWord.toCharArray();
        char[] secondtArray = secondWord.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondtArray);
        if(firstArray.length==secondtArray.length)
        {
            status = Arrays.equals(firstArray,secondtArray);
        }




        return status;

    }
    public static void main(String[] args) {

        String input1 = "peek";
        String input2 = "keep";
        if(isAnagram(input1,input2))
        {
            System.out.println(input1+ " and "+input2+" are Anagram");
        }
        else
        {
            System.out.println(input1+ " and "+input2+" are not Anagram");
        }

    }
}
