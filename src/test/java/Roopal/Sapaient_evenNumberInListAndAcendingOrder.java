package Roopal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sapaient_evenNumberInListAndAcendingOrder {

    public static void evenAscending(List<Integer> arrayList)
    {
        int[] arr = new int[arrayList.size()];
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for(int i =0;i< arrayList.size();i++)
        {
            arr[i] = arrayList.get(i);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0)
            {
                evenNumbers.add(arr[i]);
            }
        }
        Collections.sort(evenNumbers);
        for(int i=0;i< evenNumbers.size();i++)
        {

            System.out.print(" "+evenNumbers.get(i)+" ");
        }
    }

    public static void evenAscending1(List<Integer> arrayList)
    {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for(int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i)%2==0)
            {
                evenNumbers.add(arrayList.get(i));
            }
        }
        Collections.sort(evenNumbers);
        for(int i=0;i< evenNumbers.size();i++)
        {

            System.out.print(" "+evenNumbers.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 15,8,49,25,98,32));

        evenAscending1(numbers);
    }
}
