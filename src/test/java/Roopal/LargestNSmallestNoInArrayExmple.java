package Roopal;

public class LargestNSmallestNoInArrayExmple {

    public static void LargestNSmallestNoInArray(int[] arr)
    {
        int largest =arr[0];
        int smallest =arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                largest = arr[i];
            }
            else if(arr[i]<smallest)
            {
                smallest= arr[i];
            }
        }
        System.out.println("Largest Number in Array is : "+largest);
        System.out.println("Smallest Number in Array is : "+smallest);
    }
    public static void main(String[] args) {


        int[] arr ={34,2,5,8,34,56,77,809};
        LargestNSmallestNoInArray(arr);

    }
}
