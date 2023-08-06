package Roopal;

public class test {

    public static void MultiplyAndPrintLastTwoDigits(int[] arr,int multiplier)
    {
        for(int i =0;i< arr.length;i++)
        {
            int product = arr[i] * multiplier;
            int lastTwoDigits = product % 100; // Extract the last 2 digits

            System.out.println(lastTwoDigits);
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 56, 78, 90};
        int multiplier = 5;
        MultiplyAndPrintLastTwoDigits(arr,multiplier);

        /*for (int i = 0; i < arr.length; i++) {
            int product = arr[i] * multiplier;
            int lastTwoDigits = product % 100; // Extract the last 2 digits

            System.out.println(lastTwoDigits);
        }*/
    }
}
