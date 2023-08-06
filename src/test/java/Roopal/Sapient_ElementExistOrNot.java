package Roopal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sapient_ElementExistOrNot {
    public static boolean isExiist()
    {
        boolean status = false;
        List<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elemennt in array :");
        int noOfElement = sc.nextInt();
        //int[] arr = new int[noOfElement];
        System.out.print(" Please Enter " + noOfElement + " elements of an Array  : ");
        for (int i = 0; i < noOfElement; i++)
        {
            array.add(sc.nextInt());
        }
        System.out.println("Enter which number need to verify");
        int expectedElement = sc.nextInt();
        status = array.contains(expectedElement);
        return status;
    }
    public static void main(String[] args) {
        isExiist();
        boolean status = false;
        List<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elemennt in array :");
        int noOfElement = sc.nextInt();
        System.out.print(" Please Enter " + noOfElement + " elements of an Array  : ");
        for (int i = 0; i < noOfElement; i++)
        {
            array.add(sc.nextInt());
        }
        System.out.println("Enter which number need to verify");
        int expectedElement = sc.nextInt();
        status = array.contains(expectedElement);
        System.out.println(status);
    }
}
