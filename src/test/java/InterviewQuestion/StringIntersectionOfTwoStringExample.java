package InterviewQuestion;

import java.util.HashSet;
import java.util.Set;

public class StringIntersectionOfTwoStringExample
{
    public static String findIntersection(String str1, String str2)
    {
        Set<Character> set1 = new HashSet<>();
        Set<Character> intersectionSet = new HashSet<>();

        for (char c : str1.toCharArray()) {
            set1.add(c);
        }

        for (char c : str2.toCharArray()) {
            if (set1.contains(c)) {
                intersectionSet.add(c);
            }
        }

        StringBuilder intersectionBuilder = new StringBuilder();
        for (char c : intersectionSet) {
            intersectionBuilder.append(c);
        }

        return intersectionBuilder.toString();
    }
    public static void main(String[] args)
    {
        String str1 = "abcde";
        String str2 = "defgh";

        String intersection = findIntersection(str1, str2);

        System.out.println("Intersection: " + intersection);
    }


}
