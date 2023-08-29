package Roopal;

import java.util.Arrays;

public class RotationOfArray {

    public static void arrayLeftRotate(int[] inputArray, int n)
    {
        System.out.println("Input Array Before Rotation :");
        System.out.println(Arrays.toString(inputArray));
        int temp;
        for (int i = 0; i < n; i++)
        {
            temp = inputArray[0];
            for (int j = 0; j < inputArray.length-1; j++)
            {
                inputArray[j] = inputArray[j+1];
            }
            inputArray[inputArray.length - 1] = temp;
        }
        System.out.println("Input Array After Left Rotation By "+n+" Positions :");
        System.out.println(Arrays.toString(inputArray));
    }

    public static void arrayRightRotate(int[] inputArray, int n)
    {
        System.out.println("Input Array Before Rotation :");

        System.out.println(Arrays.toString(inputArray));
        int temp;
        for (int i = 1; i <= n; i++)
        {
            temp = inputArray[inputArray.length-1];
            for (int j = inputArray.length-1; j > 0; j--)
            {
                inputArray[j] = inputArray[j-1];
            }
            inputArray[0] = temp;
        }
        System.out.println("Input Array After Right Rotation By "+n+" Positions :");
        System.out.println(Arrays.toString(inputArray));
    }

    public static void rightExample(int[] arr, int d)
    {
        int n = arr.length;
        int[] temp = new int [d];
        for(int i=0;i<d;i++)
        {
            temp[i] = arr[n-d+i];
        }

        for(int i=n-1;i>=d;i--)
        {
            arr[i] = arr[i-d];
        }

        for(int i=0;i<d;i++)
        {
            arr[i] = temp[i];
        }
        System.out.println("Input Array After Right Rotation By "+d+" Positions :");
        System.out.println(Arrays.toString(arr));

    }
    public static void main(String[] args)
    {
        //arrayLeftRotate(new int[] {1,2,3,4,5,6,7}, 2);

        arrayRightRotate(new int[] {1,2,3,4,5,6,7}, 2);
        System.out.println("----------------------");
        rightExample(new int[] {1,2,3,4,5,6,7}, 2);
    }
}
