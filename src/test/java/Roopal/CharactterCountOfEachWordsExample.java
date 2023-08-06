package Roopal;

import java.util.HashMap;

public class CharactterCountOfEachWordsExample {

    public static void characterCount(String inputString)
    {
        HashMap<Character,Integer> charCount = new HashMap<>();
        char[] inputStringArray = inputString.toCharArray();

        for(char c: inputStringArray)
        {
            if(charCount.containsKey(c))
            {
                charCount.put(c,charCount.get(c)+1);
            }
            else
            {
                charCount.put(c,1);
            }
        }

        System.out.println(charCount);
    }


    public static void main(String[] args) {

        String input = "java j2ee jsp j2ee";

        characterCount(input);


    }
}
