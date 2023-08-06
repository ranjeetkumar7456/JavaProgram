package InterviewQuestion;

import java.util.*;

public class CombinedTwoListWithoutDuplicateExample {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        List<String> list2 = Arrays.asList("La Plata", "New York", "London", "Paris");

        Set<String> combinedSet = new HashSet<>();
        combinedSet.addAll(list1);
        combinedSet.addAll(list2);

        List<String> combinedList = new ArrayList<>(combinedSet);


        List<Integer> list3 = Arrays.asList(1,2,3,4,5);
        List<Integer> list4 = Arrays.asList(5,6,7,8,9);

        Set<Integer> combinedSet1 = new HashSet<>();
        combinedSet1.addAll(list3);
        combinedSet1.addAll(list4);

        List<Integer> combinedList1 = new ArrayList<>(combinedSet1);

        System.out.println("Combined List without duplicates: " + combinedList1);
    }

}
