package InterviewQuestion;

import java.util.Arrays;

public class GreatestNumbersAndPrintTheirProduct {

    public static void productOfThreeGreatedElement(int[] arr)
    {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("Array must have at least three elements.");
        }
        Arrays.sort(arr);
        long product = (long)arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        System.out.println(product);
    }
    public static void main(String[] args) {
        int[] numbers = {10, 8, 5, 9, 12, 15, 6};
        int[] number = {10, 8};
        Arrays.sort(numbers);
        /*for (int x: numbers)
        {
            System.out.print(x+" ");
        }
        System.out.println();*/
        productOfThreeGreatedElement(numbers);
        int max_product = Integer.MIN_VALUE;
        //System.out.println(max_product);
    }
}
