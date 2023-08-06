package Roopal;

import java.util.HashMap;

public class FirstRepeatingNonRepeatingExample {
    public static void firstRepeatingNNonRepeatingCharater(String inputString)
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

        for(char c: inputStringArray)
        {
            if(charCount.get(c)==1)
            {
                System.out.println("First Non Repeating Charater : "+c);
                break;
            }

        }

        for(char c: inputStringArray)
        {
            if(charCount.get(c)>1)
            {
                System.out.println("First Repeating Charater : "+c);
                break;
            }

        }
    }


    public static void main(String[] args) {

        String input = "zjava j2ee jsp j2ee";

        firstRepeatingNNonRepeatingCharater(input);


    }
}
