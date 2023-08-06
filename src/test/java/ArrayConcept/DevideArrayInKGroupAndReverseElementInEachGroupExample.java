package ArrayConcept;

public class DevideArrayInKGroupAndReverseElementInEachGroupExample {
    public static void reverseGroup(int[] arr, int k)
    {
       /* if(arr==null || arr.length<=1 ||k<=1)
        {
            return;
        }*/
        int n = arr.length;
        for(int i =0;i<n;i =i+k)
        {
            int left=i;
            int right = Math.min(i+k-1,n-1);
            while(left<right)
            {
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }

          /*
          int right = Math.min(i + k - 1, n - 1);: This initializes the variable right to the minimum of (i + k - 1) and (n - 1),
        where n is the length of the array. The variable right represents the ending index of the current group. It ensures that the last group may have fewer
        elements than k if the length of the array is not a multiple of k.


        */

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k =3;
        System.out.println("Original Array");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Devide array in k group and reverse each group element");
        reverseGroup(arr,k);
    }
}
