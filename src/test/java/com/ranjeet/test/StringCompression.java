package com.ranjeet.test;

import java.util.*;

public class StringCompression {
    public static String compression(String str) {
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 0;
        for (int i=0; i< str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                sb.append(last + "" + count);
                count = 1;  // here count should be 1 but not 0
            }
            last = str.charAt(i);
        }
        sb.append(last + "" + count); //reflush the last part

        String newStr = sb.toString();
        if (newStr.length() < str.length()) {
            return newStr;
        } else {
            return str;
        }
    }


    /**
     * My Solution: Store every number frequency and then Reconstruct them use a StringBuffer
     * not efficient because of two loop
     */
    public static String compression2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i=0; i<str.length(); i++) {
            char value = str.charAt(i);
            if(map.containsKey(value)) {
                int count = map.get(value) + 1;
                map.put(value, count );
            } else {
                map.put(value, 1);
            }
        }

        // construct string
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }

        String newStr = sb.toString();
        // exclude situation like abc --> a1b1c1
        if (newStr.length() < str.length()) {
            return newStr;
        } else {
            return str;
        }
    }

    public static void compress(String str) {

        Map<Character,Integer> stringMap = new HashMap<Character,Integer>();

        for(int i = 0 ; i < str.length(); i++) {
            char value = str.charAt(i);
            if (stringMap.containsKey(value)) {
                int count = stringMap.get(value)+1;
                stringMap.put(value,count);
            }else{
                stringMap.put(value,1);
            }
        }

        String res = "";
        for (Map.Entry<Character,Integer> entry : stringMap.entrySet()) {
            res = res + ""+entry.getKey() + entry.getValue();
            //System.out.println(""+entry.getKey() + entry.getValue());
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compression(str));
        compress(str);

    }
}
