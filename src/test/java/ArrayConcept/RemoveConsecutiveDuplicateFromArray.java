package ArrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveConsecutiveDuplicateFromArray
{
    public static int[] removeConsecutiveDuplicates(int[] inputArray)
    {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < inputArray.length-1; i++)
        {
            if (inputArray[i] != inputArray[i + 1])
            {
                resultList.add(inputArray[i]);
            }
        }

        // Add the last element of the array
        resultList.add(inputArray[inputArray.length - 1]);

        // Convert the List to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    public static void removeConsecutiveDuplicates1(int[] inputArray)
    {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < inputArray.length - 1; i++)
        {
            if (inputArray[i] != inputArray[i + 1])
            {
                resultList.add(inputArray[i]);
            }
        }

        // Add the last element of the array
        resultList.add(inputArray[inputArray.length - 1]);

        // Convert the List to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++)
        {
            resultArray[i] = resultList.get(i);
        }
        System.out.println(Arrays.toString(resultArray));
        //return resultArray;
    }
    public static void main(String[] args)
    {
        int[] inputArray = {1, 2, 2, 3, 4, 4, 5, 5, 5};
        int[] resultArray = removeConsecutiveDuplicates(inputArray);

        System.out.println("Original Array: " + Arrays.toString(inputArray));
        //System.out.println("Array without consecutive duplicates: " + Arrays.toString(resultArray));
        removeConsecutiveDuplicates1(inputArray);
    }
}
