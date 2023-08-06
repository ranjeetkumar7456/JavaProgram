package Roopal;

public class FindMissingNumberInArray {

    public static int getMissingNo(int[] nums)
    {
        int n = nums.length;
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++)
            sum -= nums[i];
        return sum;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 5 };
        //int N = arr.length;
        System.out.println(getMissingNo(arr));

    }
}
