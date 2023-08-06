package InterviewQuestion;

import java.util.HashSet;
import java.util.Set;

public class StringUnionOfTwoStringExample {

    public static String findUnion(String str1, String str2) {
        Set<Character> unionSet = new HashSet<>();

        for (char c : str1.toCharArray()) {
            unionSet.add(c);
        }

        for (char c : str2.toCharArray()) {
            unionSet.add(c);
        }

        StringBuilder unionBuilder = new StringBuilder();
        for (char c : unionSet) {
            unionBuilder.append(c);
        }

        return unionBuilder.toString();
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "defgh";

        String union = findUnion(str1, str2);

        System.out.println("Union: " + union);
    }



}
