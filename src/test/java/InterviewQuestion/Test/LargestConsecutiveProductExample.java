package InterviewQuestion.Test;

public class LargestConsecutiveProductExample {
    public static void largestConsecutiveProduct(int[] arr)
    {
        int largestProduct = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int product = arr[i] * arr[i + 1];
            if (product > largestProduct) {
                largestProduct = product;
            }
        }

        System.out.println("Largest product of two consecutive elements: " + largestProduct);
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2,3, 4, 5, 6, 7};
        largestConsecutiveProduct(arr);
    }
}
