package Roopal;

public class ReverseSubsetInArrayExample {
    public static void reverseSubset(int[] array, int n) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 15, 17, 19};
        int N = 9; // Size of the subset to reverse

        reverseSubset(array, N);

        // Print the reversed array
        for (int num : array) {
            System.out.print(num + " ");
        }
        // Output: 7 5 3 1 9 11 15 17 19
    }
}


/*
        In this implementation, the reverseSubset function takes two arguments: the array and the size of the subset to reverse (N).

        The function initializes start to 0 and end to N - 1, representing the indices of the first and last elements of
        the subset, respectively. It then uses a two-pointer approach to reverse the elements within the subset. The elements
        at start and end are swapped, and the pointers are incremented and decremented until they meet in the middle.

        In the main method, we create an example array and specify the size of the subset to reverse (N). We then call the reverseSubset
        function to reverse the subset in the array. Finally, we print the reversed array using a loop.

        The output will be [7, 5, 3, 1, 9, 11, 15, 17, 19], where the subset [1, 3, 5, 7] is reversed while the rest of the array
        remains unchanged.
*/
