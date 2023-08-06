package Roopal;

import java.util.HashMap;
import java.util.Map;

public class Most_frequent_element_in_an_array {
    // Java program to find the most frequent element
    // in an array.
    public static int mostFrequent(int[] arr)
    {
        int maxcount = 0;
        int element_having_max_freq = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int count = 0;
            for (int j = 1; j < arr.length; j++)
            {
                if (arr[i] == arr[j])
                {
                    count++;
                }
            }
            if (count > maxcount) {
                maxcount = count;
                element_having_max_freq = arr[i];
            }
        }

        return element_having_max_freq;
    }

    public static int findMostFrequentElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequentElement = arr[0]; // Initialize with the first element
        int maxFrequency = frequencyMap.get(mostFrequentElement);

        // Find the most frequent element
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                mostFrequentElement = entry.getKey();
                maxFrequency = frequency;
            }
        }

        return mostFrequentElement;
    }

    public static Map<Integer, Integer> findMostFrequentElement1(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Map<Integer, Integer> frequencyCount = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : arr)
        {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        int mostFrequentElement = arr[0]; // Initialize with the first element
        int maxFrequency = frequencyCount.get(mostFrequentElement);

        // Find the most frequent element
        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                mostFrequentElement = entry.getKey();
                maxFrequency = frequency;
            }
        }

        Map<Integer, Integer> result = new HashMap<>();
        result.put(mostFrequentElement, maxFrequency);

        return result;
    }

    // Driver program
    public static void main(String[] args)
    {
        int[] arr = { 40, 50, 30, 40, 50, 30, 30 };
        int n = arr.length;
        System.out.println(mostFrequent(arr));
        System.out.println("=======================");

        System.out.println(findMostFrequentElement(arr));
        System.out.println("=======================");

        System.out.print(findMostFrequentElement1(arr));
    }
}
