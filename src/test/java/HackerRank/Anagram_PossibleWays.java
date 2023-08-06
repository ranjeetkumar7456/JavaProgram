package HackerRank;

import java.util.*;

public class Anagram_PossibleWays {

    // 1. Using Arrays Class

    public static void Anagram_UsingArrayClass(String str1, String str2) {
        //removes white spaces from string 1
        String s1 = str1.replaceAll("\\s", "");
        //removes white spaces from string 2
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        //checks the length of both the strings are equal or not
        if (s1.length() != s2.length()) {
            //if length of strings is not equal status returns false
            status = false;
        }
        //executes if lengths of strings are equal
        else {
            //first converts the string 1 in lower case and then converts the string into a character array
            //final string stores in arrayS1
            char[] arrayS1 = s1.toLowerCase().toCharArray();
            //first converts the string 2 in lower case and then converts the string into a character array
            //final string stores in arrayS2
            char[] arrayS2 = s2.toLowerCase().toCharArray();
            //sorts the character array arrayS1
            Arrays.sort(arrayS1);
            //sorts the character array arrayS2
            Arrays.sort(arrayS2);
            //compares the strings
            status = Arrays.equals(arrayS1, arrayS2);
        }
        if (status) {
            //prints if status returns true
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            //prints if status returns false
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }

//=================================================================================
    // 2. Using for Loop
    public static void Anagram_UsingLoop(String str1, String str2) {
        Boolean status=true;
        //Remove spaces and convert to lowercase
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();

        //If the length of the two strings is not equal, they cannot be anagrams
        if (str1.length() != str2.length()) {
            status=false;
        }

        //Create an array of integers to store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            //Increment the frequency of the current character in str1
            frequency[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            //Decrement the frequency of the current character in str2
            frequency[str2.charAt(i) - 'a']--;
        }

        //If any of the frequencies is not 0, the strings are not anagrams
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                status= false;
            }
        }
        if (status) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }


    //=================================================================================
    // 3. Using substring


    //Function checks anagram using the substring() method
    public static void checkAnagram_substring(String a,String b){
        Boolean status = true;
        //if lengtha sre  not identical then strings are not Anagram
        if(a.length() != b.length())
        {
            status=false;
        }
        /*
         *pick characters from string-I one by one
         *and remove the same from String-II
         */
        int index;
        for(int i=0; i<a.length(); i++){
            //if a character of string-I doesn't even exixit in string-II
            //then the strings are not anagram
            if((index = b.indexOf(a.charAt(i))) != -1){
                //removing character using the substring() method
                b= b.substring(0, index) + b.substring(index+1, b.length());
            } else{
                status=false;
            }
        }
        //If length of string-II reduces to 0, then strings are Anagram
        if(b.length() != 0)
        {
            status=false;
        }

        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }
    }
    //=================================================================================
    // Method 4: Using StringBuffer class

    public static void checkAnagram_StringBuffer(String a, String b){

        Boolean status = true;

        //if lengths are not identical then strings are not Anagram
        if(a.length() != b.length())
        {
            status=false;
        }

        StringBuffer sb = new StringBuffer(b);

        /*
         *pick characters from string-I one by one
         *and remove the same from String-II
         */
        for(int i=0; i<a.length(); i++){
            sb.deleteCharAt(sb.indexOf(a.charAt(i)+""));
        }

        //If length of string-II reduces to 0, then strings are Anagram
        if(sb.length() != 0)
        {
            status=false;
        }

        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }
    }

    //=================================================================================
    // Method 5: Using Using Char Array

    public static void checkAnagram_UsingCharArray(String a, String b){

        char aArray[] = a.toCharArray();
        char bArray[] = b.toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        if(Arrays.equals(aArray,bArray))
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }
    }

    //=================================================================================
    // Method 6: Anagram without using Array

    public static void checkAnagram_without_UsingArray(String s1, String s2) {
        Boolean status = true;
        // Remove all the white space and convert to lower case
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // Check length of both strings
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        s2 = s2.substring(0, j) + s2.substring(j + 1);
                        break;
                    }
                }
            }

            if (s2.length() != 0) {
                status = false;
            }
        }

        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }

    }

    //=================================================================================
    // Method 7: Anagram Program using XOR
    public static void checkAnagram_Using_XOR(String s1, String s2)
    {
        Boolean status =true;
        // Remove all the white space, convert to lower case & character array
        char[] arr1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] arr2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
        if (arr1.length != arr2.length)
        {
            status=false;
        }
        int xor = 0;

        for (int i = 0; i < arr1.length; i++)
        {
            xor ^= arr1[i] ^ arr2[i];
        }
        if(xor!=0)
        {
            status=false;
        }
        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }
    }

    //=================================================================================
    // Method 8: Check Anagram using HashMap

    public static void Anagram_Using_HashMap(String s1, String s2)
    {
        Boolean status=true;
        if (s1.length() != s2.length())
        {
            status=false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for (int i = 0; i < s2.length(); i++)
        {
            char c = s2.charAt(i);
            if (map.containsKey(c))
            {
                if (map.get(c) == 1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            } else
            {
                status=false;
            }
        }
        if (map.size() > 0)
        {
            status=false;
        }
        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }
    }


    //=================================================================================
    // Method 9: Check Anagram using ArrayList


    public static void Anagram_Using_ArrayList(String s1, String s2)
    {
        Boolean status=true;
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length())
        {
            status=false;
        }

        List<Character> list1 = new ArrayList<Character>();
        List<Character> list2 = new ArrayList<Character>();

        for (int i = 0; i < s1.length(); i++)
        {
            list1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++)
        {
            list2.add(s2.charAt(i));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        if (!(list1.equals(list2)))
        {
            status=false;
        }

        if(status)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not an Anagram");
        }

    }

    public static void main(String[] args) {

        // 1. Using Arrays Class
        System.out.println("// 1. Using Arrays Class...");
        Anagram_UsingArrayClass("HEART", "EARTH");

        // 2. Using for Loop
        System.out.println("// 2. Using for Loop...");
        Anagram_UsingLoop("HEART", "EARTH");

        // 3. Using substring
        System.out.println("// 3. Using substring...");
        checkAnagram_substring("HEART", "EARTH");

        // 4. Using StringBuffer
        System.out.println("// 4. Using StringBuffer...");
        checkAnagram_StringBuffer("HEART", "EARTH");

        // 5. Using CharArray
        System.out.println("// 5. Using CharArray...");
        checkAnagram_UsingCharArray("HEART", "EARTH");

        // 6. Without Using Array
        System.out.println("// 6. Without Using Array...");
        checkAnagram_without_UsingArray("HEART", "EARTH");

        // 7. Using XOR method
        System.out.println("// 7. Using XOR method...");
        checkAnagram_Using_XOR("HEART", "EARTH");

        // 8. Using HashMap
        System.out.println("// 8. Using HashMap...");
        Anagram_Using_HashMap("HEART", "EARTH");

        // 9. Using ArrayList
        System.out.println("// 9. Using ArrayList...");
        Anagram_Using_ArrayList("HEART", "EARTH");








        //Anagram_UsingArrayClass("HEART", "EARTH");
        //checkAnagram_substring("HEART", "EARTH");

        //checkAnagram_substring("HEART", "EARTH");

        //checkAnagram_StringBuffer("HEART", "EARTH");
        //checkAnagram_UsingCharArray("HEART", "EARTH");
        //checkAnagram_without_UsingArray("HEART", "EARTH");
        //checkAnagram_Using_XOR("HEART", "EARTH");
        //Anagram_Using_HashMap("HEART1", "EARTH");
        //Anagram_Using_ArrayList("HEART", "EARTH");
        //("HEART", "EARTH");



    }
}
