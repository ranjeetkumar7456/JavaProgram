package Roopal;

import java.util.Arrays;

public class SeparateZerosFromNonZeros {
    static void moveZerosToRight(int inputArray[])
    {
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++)
        {
            if(inputArray[i] != 0)
            {
                inputArray[counter] = inputArray[i];
                counter++;
            }
        }
        while (counter < inputArray.length)
        {
            inputArray[counter] = 0;

            counter++;
        }
        System.out.println(Arrays.toString(inputArray));
    }
    static void moveZerosToLeft(int inputArray[])
    {
        int counter = inputArray.length-1;
        for (int i = inputArray.length-1; i >= 0; i--)
        {
            if(inputArray[i] != 0)
            {
                inputArray[counter] = inputArray[i];
                counter--;
            }
        }
        while (counter >= 0)
        {
            inputArray[counter] = 0;
            counter--;
        }
        System.out.println(Arrays.toString(inputArray));
    }
    public static void main(String[] args)
    {
        int[] array= {12, 0, 7, 0, 8, 0, 3};
        moveZerosToRight(array);
        moveZerosToLeft(array);
    }

}
