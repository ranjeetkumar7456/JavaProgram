package Roopal;

import java.util.HashMap;
import java.util.Map;

public class mostFrequentWordExample {

    public static String mostFrequentWord(String arr[], int n)
    {
        HashMap<String, Integer> freq = new HashMap<>();
        HashMap<String, Integer> occurrence = new HashMap<>();
        int max = 0;
        String result = "";
        int k = 1;

        for (int i = 0; i < n; i++) {
            if (occurrence.containsKey(arr[i])) {
                continue;
            }

            occurrence.put(arr[i], k);
            k++;
        }

        for (int i = 0; i < n; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
            else
                freq.put(arr[i], +1);

            if (max <= freq.get(arr[i])) {

                if (max < freq.get(arr[i])) {
                    max = freq.get(arr[i]);
                    result = arr[i];
                }
                else {
                    if (occurrence.get(result)
                            < occurrence.get(arr[i])) {
                        max = freq.get(arr[i]);
                        result = arr[i];
                    }
                }
            }
        }

        return result;
    }

    public static void FrequentWord(String array[])
    {
        // Insert all unique strings and update count if a string is not unique.
        Map<String,Integer> hshmap = new HashMap<String, Integer>();
        for (String str : array)
        {
            if (hshmap.keySet().contains(str)) // if already exists then update count.
                hshmap.put(str, hshmap.get(str) + 1);
            else
                hshmap.put(str, 1); // else insert it in the map.
        }
        // Traverse the map for the maximum value.
        String maxStr = "";
        int maxVal = 0;
        for (Map.Entry<String,Integer> entry : hshmap.entrySet())
        {
            String key = entry.getKey();
            Integer count = entry.getValue();
            if (count > maxVal)
            {
                maxVal = count;
                maxStr = key;
            }
            // Condition for the tie.
            else if (count == maxVal){
                if (key.length() < maxStr.length())
                    maxStr = key;
            }
        }
        System.out.println("Most frequent word: "+ maxStr);
        System.out.println("Count: "+ maxVal);
    }

    public static void main(String[] args)
    {

        String arr[]
                = { "geeks",  "for",      "geeks",   "a",
                "portal", "to",       "learn",   "can",
                "be",     "computer", "science", "zoom",
                "yup",    "fire",     "in",      "be",
                "data",   "geeks" };
        int n = arr.length;

        System.out.println(mostFrequentWord(arr,n));
        System.out.println("=========================================");
        String[] arr1 = { "Batman", "Thor", "Batman" , "Flash", "Batman" };
        FrequentWord(arr1);
    }
}
