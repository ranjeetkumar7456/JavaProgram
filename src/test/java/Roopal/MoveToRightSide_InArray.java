package Roopal;

public class MoveToRightSide_InArray {
    public static void moveElement_RightSide(int[] arr, int moveElement){
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=moveElement){
                arr[count++]=arr[i];
            }
        }
        while(count<arr.length){
            arr[count++]=moveElement;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void moveElement_LeftSide(int[] arr,int moveElement)
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



    public static void main(String[] args) {
        //int[] arr={1,0,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,1};
        //int[] arr={1,0,3,4,5,3,3,4,5,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,1};
        //int arr[] = {1, 9, 8, 4, 2,3,4,2,2,2,2,2,2,20, 0, 2, 7, 0, 6, 0, 9};
        int arr[] = {0,1,2,0,3,0,4,0,0,5,0,6};

        moveElement_LeftSide(arr,0);
        System.out.println();
        System.out.println("========================");
        moveElement_RightSide(arr, 0);
    }
}
