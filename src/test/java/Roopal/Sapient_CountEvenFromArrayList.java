package Roopal;

import java.util.Scanner;

public class Sapient_CountEvenFromArrayList {

    public static void main(String[] args)
    {
        int evenCount = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print(" Please Enter Number of elements in an array : ");
       int size = sc.nextInt();

        int [] a = new int[size];

        System.out.print(" Please Enter " + size + " elements of an Array  : ");
        for (int i = 0; i < size; i++)
        {
            a[i] = sc.nextInt();
        }
        //System.out.print("\n List of Even Numbers in this Array are :");
        for(int i = 0; i < size; i++)
        {
            if(a[i] % 2 == 0)
            {
                evenCount++;
            }
        }
        System.out.println("\n Total Number of Even Numbers in this Array = " + evenCount);
    }
}
