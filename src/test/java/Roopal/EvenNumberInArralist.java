package Roopal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenNumberInArralist {
    public static boolean isEvenNo(List<Integer> arr)
    {
        boolean status =false;
        ArrayList<Integer> even = new ArrayList<>();
        Scanner sc = new Scanner(System.in);



        return status;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int arrSize, a, countEven = 0, countOdd = 0;
        System.out.println("Please enter number of elements of an array: ");
        arrSize = sc.nextInt();
        int[] arrNumbers = new int[arrSize];
        System.out.println("Please enter " + arrSize + " elements of an array: ");
        for(a = 0; a < arrSize; a++)
        {
            arrNumbers[a] = sc.nextInt();
        }
        for(a = 0; a < arrNumbers.length; a++)
        {
            if(arrNumbers[a] % 2 == 0)
            {
                countEven++;
            }
            else
            {
                countOdd++;
            }
        }
        System.out.println("Total number of even numbers in an array java: " + countEven);
        System.out.println("Total number of odd numbers in an array java: " + countOdd);
        sc.close();
    }
}
