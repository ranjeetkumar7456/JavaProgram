package InterviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class CharacterCountExample {

    public static void characterCount(String str)
    {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);

            // If the character is already present in the map, increment its count
            if (charCountMap.containsKey(c))
            {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else
            {
                // Otherwise, add the character to the map with count 1
                charCountMap.put(c, 1);
            }
        }
        // Print the character count
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    public static void characterCount1(String str)
    {
        char[] charArray= str.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for(int i =0; i<charArray.length;i++)
        {
            if (charCountMap.containsKey(charArray[i]))
            {
                charCountMap.put(charArray[i], charCountMap.get(charArray[i]) + 1);
            }
            else
            {
                // Otherwise, add the character to the map with count 1
                charCountMap.put(charArray[i], 1);
            }
        }
        // Print the character count
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


    }

    public static void main(String[] args) {
        String str ="aabbcccccddddddeeffa";
        characterCount(str);
        System.out.println("=================");
        characterCount1(str);

    }
}
