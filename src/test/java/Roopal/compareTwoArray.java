package Roopal;

import java.util.Arrays;

public class compareTwoArray {

    public static boolean arraysCompareCheck_String(String a[], String b[])
    {
        if(a.length!=b.length){
            return false;
        }
        else
        {
            for(int i=0;i<a.length;i++)
            {
                if(a[i]!=b[i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean arraysCompareCheck_int(int[] c, int[] d)
    {
        if(c.length!=d.length){
            return false;
        }
        else
        {
            for(int i=0;i<c.length;i++)
            {
                if(c[i]!=d[i])
                {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean arraysCompareCheck_WithEqualsMethod(int[] c, int[] d)
    {
       boolean status = false;
        status =Arrays.equals(c,d);
        return status;
    }

    public static boolean arraysCompareCheck_WithCompareMethod(int[] c, int[] d)
    {
        boolean status = false;
        int compare = Arrays.compare(c,d);
        //System.out.println(compare);
        if(compare==0)
        {
            status = true;
        }
        return status;
    }
    public static void main(String[] args) {

        String a[] = {"apple","bat","cat"};
        String b[] = {"apple","bat","catt"};

        int[] c = {1,2,19};
        int[] d= {1,2,19};

        if(arraysCompareCheck_String(a, b)){
            System.out.println("Both arrays are equal");
        }
        else
        {
            System.out.println("Both arrays are not equal");
        }


        if(arraysCompareCheck_int(c, d)){
            System.out.println("Both arrays are equal");
        }
        else
        {
            System.out.println("Both arrays are not equal");
        }


        if(arraysCompareCheck_WithCompareMethod(c, d)){
            System.out.println("Both arrays are equal");
        }
        else
        {
            System.out.println("Both arrays are not equal");
        }

        if(arraysCompareCheck_WithEqualsMethod(c, d)){
            System.out.println("Both arrays are equal");
        }
        else
        {
            System.out.println("Both arrays are not equal");
        }




    }
}
