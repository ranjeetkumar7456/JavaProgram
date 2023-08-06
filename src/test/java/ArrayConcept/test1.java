package ArrayConcept;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class test1 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("banana");
        strings.add("orange");
        strings.add("apple");
        strings.add("grape");

        System.out.println("Original list: " + strings);

        // Sort the list based on the length of the strings in ascending order
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        System.out.println("Sorted list: " + strings);
    }
}
