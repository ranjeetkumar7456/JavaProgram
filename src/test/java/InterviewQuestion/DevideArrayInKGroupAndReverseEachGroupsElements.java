package InterviewQuestion;

public class DevideArrayInKGroupAndReverseEachGroupsElements {

    //Divide a array into groups of K and reverse the numbers in every group.

    public static void reverseGroups(int[] arr, int k)
    {
        if (arr == null || arr.length <= 1 || k <= 1)
        {
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n; i += k)
        {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void printArray(int[] arr)
    {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        System.out.println("Original Array:");
        printArray(arr);

        reverseGroups(arr, k);

        System.out.println("Array after reversing groups of " + k + ":");
        printArray(arr);
    }
}

/*
        In this code, we define a class ArrayGrouperAndReverser with two methods: reverseGroups() and printArray().

        The reverseGroups() method takes an array arr and a group size k as input. It iterates through the array in
        steps of k and reverses each group of numbers. For each group, it sets the left and right pointers to the start
        and end of the group, respectively. Then, it swaps the elements at the left and right indices while incrementing
        the left pointer and decrementing the right pointer, until they meet at the middle of the group.

        The printArray() method is a utility function to print the elements of the array.

        In the main() method, we create a sample array, specify the group size k, and call the reverseGroups() method
        to reverse the numbers in each group. Finally, we print the modified array to the console.

        Running this code will output the original array and the array after reversing the groups of size k.
*/
