package InterviewQuestion;



/*
    Initialization of ArrayList


          Type - 1
          ArrayList<String> places = new ArrayList<String>();
          places.add("Buenos Aires");
          places.add("Córdoba");
          places.add("La Plata");

          Type - 2  - initialize and and assign value

          ArrayList<String> places = new ArrayList<String>(
           Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
*/

//Take 2 lists, find the sum of elements in each list and then multiply the resultant sum of both

import java.util.ArrayList;
import java.util.List;

public class ListSumAndMultiplication {
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        int sum1 = calculateSum(list1);
        int sum2 = calculateSum(list2);

        int multiplication = sum1 * sum2;

        System.out.println("Sum of elements in list1: " + sum1);
        System.out.println("Sum of elements in list2: " + sum2);
        System.out.println("Multiplication of sums: " + multiplication);
    }
}
