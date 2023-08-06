package StringProblems;

import java.util.Arrays;


public class SortStringArrayWithSortMethod {
    public static void main(String[] args)
    {
        String[] strAsc = {"Bear","Fox","Deer","Cheetah","Anteater","Elephant"};
        //System.out.println("Before sorting: ====================");
        for(String string : strAsc)
        {
            //System.out.println(string);
        }
        // arrays.sort
        Arrays.sort(strAsc);
        System.out.println("Sorting string array alphabetically:=============== ");
        for(String str : strAsc)
        {
            System.out.println(str);
        }
    }
}
