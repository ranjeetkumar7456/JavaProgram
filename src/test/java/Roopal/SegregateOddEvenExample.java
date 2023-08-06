package Roopal;

public class SegregateOddEvenExample {
    public static void segregateEvenOdd(int arr[])
    {
        /* Initialize left and right indexes */
        int left = 0, right = arr.length - 1;
        while (left < right)
        {
            /* Increment left index while we see 0 at left */
            while (arr[left]%2 == 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (arr[right]%2 == 1 && left < right)
                right--;

            if (left < right)
            {
                /* Swap arr[left] and arr[right]*/
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static int[] separateEvenOddNumber1(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        for (int i = 0; i < arr.length; i++) {

            while(arr[left]%2==0)
            {
                left++;
            }
            while(arr[right]%2==1)
            {
                right--;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        return arr;
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
        int arr[] = {12, 34, 45, 9, 8, 90, 3,88};

        /*segregateEvenOdd(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }*/


        separateEvenOddNumber1(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

}
