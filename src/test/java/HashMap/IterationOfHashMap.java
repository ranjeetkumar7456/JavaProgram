package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterationOfHashMap {
/*
    There is a numerous number of ways to iterate over HashMap of which 5 are listed as below:

    1. Iterate through a HashMap EntrySet using Iterators.
    2. Iterate through HashMap KeySet using Iterator.
    3. Iterate HashMap using for-each loop.
    4. Iterating through a HashMap using Lambda Expressions.
    5.Loop through a HashMap using Stream API.

    */
    public static void main(String[] args)
    {
        // Method 1: Using a for loop to iterate through a HashMap.
        // Iterating a HashMap through a for loop to use

        Map<String, String> foodTable = new HashMap<String, String>();

        foodTable.put("A", "Angular");
        foodTable.put("J", "Java");
        foodTable.put("P", "Python");
        foodTable.put("H", "Hibernate");


        // Method 1: Using a for loop to iterate through a HashMap.
        // Iterating a HashMap through a for loop to use
        System.out.println("Method 1: Using a for loop to iterate through a HashMap");
        for (Map.Entry<String, String> set : foodTable.entrySet())
        {
            // Printing all elements of a Map
            System.out.println(set.getKey() + " = " + set.getValue());
        }

        // Method 2: Using a forEach to iterate through a HashMap. In the second method,
        // the forEach function to iterate the key-value pairs.
        System.out.println("Method 2: Using a forEach to iterate through a HashMap.");
        foodTable.forEach((key, value) -> System.out.println(key + " = " + value));

        // Method 3: Using an iterator to iterate through a HashMap. In this method, iterator is being used to iterate
        // each mapped pair in HashMap as shown in below java program.

        // Iterator
        Iterator<Map.Entry<String, String>> new_Iterator = foodTable.entrySet().iterator();
        // Iterating every set of entry in the HashMap

        System.out.println("Method 3: Using an iterator to iterate through a HashMap.");
        while (new_Iterator.hasNext())
        {
            Map.Entry<String, String> new_Map = (Map.Entry<String, String>) new_Iterator.next();

            // Displaying HashMap
            System.out.println(new_Map.getKey() + " = " + new_Map.getValue());
        }

        // Method 4: Iterating through a HashMap using Lambda Expressions
        System.out.println("Method 4: Iterating through a HashMap using Lambda Expressions");
        foodTable.forEach((key, value) -> System.out.println(key + " = " + value));

        // Method 5: Loop through a HashMap using Stream API
        System.out.println("Method 5: Loop through a HashMap using Stream API");
        foodTable.entrySet().stream().forEach(input -> System.out.println(input.getKey() + " : "+ input.getValue()));
    }
}
