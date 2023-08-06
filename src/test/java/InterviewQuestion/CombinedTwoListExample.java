package InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinedTwoListExample {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        List<String> list2 = Arrays.asList("New York", "London", "Paris");

        List<String> combinedList = new ArrayList<>();
        combinedList.addAll(list1);
        combinedList.addAll(list2);

        List<Integer> list3 = Arrays.asList(1,2,3,4,5);
        List<Integer> list4 = Arrays.asList(5,6,7,8,9);

        List<Integer> combinedList1 = new ArrayList<>();
        combinedList1.addAll(list3);
        combinedList1.addAll(list4);




        System.out.println("Combined List: " + combinedList1);
    }
}
