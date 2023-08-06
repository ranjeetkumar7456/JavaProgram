package InterviewQuestion;

import java.util.HashSet;

public class FindDuplicatesExample {
    public static void findDuplicatesUsingHashSet(int[] numbers) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();

        for (int number : numbers) {
            if (!uniqueSet.add(number)) {
                duplicateSet.add(number);
            }
        }

        System.out.println("Duplicate numbers: " + duplicateSet);
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 1, 2, 5, 6, 3};
        findDuplicatesUsingHashSet(numbers);
    }
}
