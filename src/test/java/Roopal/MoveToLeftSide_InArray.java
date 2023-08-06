package Roopal;

public class MoveToLeftSide_InArray {
    public static void moveToLeftSide(int[] arr,int moveElement)
    {
        int count = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--)
        {
            if(arr[i] != moveElement)
            {
                arr[count--] = arr[i];
                //counter--;
            }
        }
        while (count >= 0)
        {
            arr[count--] = moveElement;

        }

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 9, 8, 4, 2,3,4,2,2,2,2,2,2,20, 0, 2, 7, 0, 6, 0, 9};
        //moveZerosToFront(new int[] {-4, 1, 0, 0, 2, 21, 4});
        //int[] arr={1,0,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,1};
        moveToLeftSide(arr,0);

    }
}
