package Roopal;

public class ContinousSubArrayWhoseSumEqualToGivenExample {

    public static void continousSubArrayWhoseSumEqualToGiven(int[] arr, int input)
    {
        for(int i =0;i<arr.length;i++)
        {
            for(int j= i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]== input)
                {
                    System.out.println("Sum of "+arr[i]+" and "+arr[j]+ " = " +input);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr= {4,5,6,8,-10,8,10,0,20};
        continousSubArrayWhoseSumEqualToGiven(arr,10);

    }
}
