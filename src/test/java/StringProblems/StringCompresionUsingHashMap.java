package StringProblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompresionUsingHashMap {

    // Using HashMap Concept
    public static void StringCompression_UsingHashMap(String input)
    {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<input.length();i++)
        {
            if(map.get(input.charAt(i))!=null)
            {
                map.put(input.charAt(i),map.get(input.charAt(i))+1);
            }
            else
            {
                map.put(input.charAt(i),1);
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            sb.append(entry.getKey());
            sb1.append(entry.getKey());
            if(entry.getValue()>1)
            {
                sb.append(entry.getValue());
            }
            //sb.append(entry.getValue());
            sb1.append(entry.getValue());
        }
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }

    // Using HashMap Concept
    public static void StringCompression(String input)
    {

    }


    public static String compression1(String s) {
        String ans = "";
        for (int i = 0 ; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
            ans += s.charAt(i);
        }
        return ans;
    }

    public static String compression2(String s) {
        String ans = "";
        for (int i = 0 ; i < s.length(); i++) {
            int count = 1;
            while (i < s.length() - 1
                    && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            ans += s.charAt(i);
            if (count > 1) {
                ans += count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String str ="ranjeet";
        //StringCompression_UsingHashMap(str);

        System.out.println( compression2(str));

        compression1(str);
    }
}
